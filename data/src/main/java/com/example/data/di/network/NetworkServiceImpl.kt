package com.example.data.di.network

import com.example.data.di.datamodule
import com.example.data.di.model.DataProductModel
import com.example.domain.di.model.Product
import com.example.domain.di.network.NetworkService
import com.example.domain.di.network.ResultWrapper
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.request.header
import io.ktor.client.request.request
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.HttpMethod
import io.ktor.http.Parameters
import io.ktor.http.contentType
import io.ktor.utils.io.InternalAPI


class NetworkServiceImpl(val client: HttpClient): NetworkService {
    private val basedUrl = "https://fakestoreapi.com"
    override suspend fun getProducts(category: String?): ResultWrapper<List<Product>> {
        val url =
            if(category !=null) "$basedUrl/products/category/$category" else "$basedUrl/products"
        return makeWebRequest(
            url = "https://fakestoreapi.com/products",
            method = HttpMethod.Get,
            mapper = { dataModels: List<DataProductModel> ->
                dataModels.map { it.toProduct()}
            }
        )
    }

    @OptIn(InternalAPI::class)
    suspend inline fun <reified T, R> makeWebRequest(
        url: String,
        method: HttpMethod,
        body: Any? = null,
        headers: Map<String, String> = emptyMap(),
        parameters: Map<String, String> = emptyMap(),
        noinline mapper: ((T) -> R)? = null
    ): ResultWrapper<R> {
        return try {
            val response = client.request(url) {
                // Set the HTTP method
                this.method = method

                // Append query parameters
                url {
                    this.parameters.appendAll(Parameters.build {
                        parameters.forEach { (key, value) ->
                            append(key, value)
                        }
                    })
                }

                // Set headers
                headers.forEach { (key, value) ->
                    header(key, value)
                }

                // Set body if it exists
                if (body != null) {
                    setBody(body)
                }

                // Set content type
                contentType(ContentType.Application.Json)
            }.body<T>()

            // Automatically parse the response into the desired type `T`
            val result: R = mapper?.invoke(response) ?: response as R
            ResultWrapper.Success(result)
        } catch (e: ClientRequestException) {
            ResultWrapper.Failure(e)
        } catch (e: ServerResponseException) {
            ResultWrapper.Failure(e)
        }
    }
}