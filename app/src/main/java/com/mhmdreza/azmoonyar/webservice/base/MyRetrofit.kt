package com.mhmdreza.azmoonyar.webservice.base

import com.mhmdreza.azmoonyar.webservice.base.constants.BASE_URL
import com.mhmdreza.azmoonyar.webservice.pref.WebservicePrefSetting
import com.google.gson.GsonBuilder
import io.fabric.sdk.android.services.network.HttpRequest
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MyRetrofit {

    var webserviceUrls = getUrls()

    private fun getUrls(): WebserviceUrls {
        val gson = GsonBuilder()
                .setLenient()
                .create()
        val builder = OkHttpClient.Builder()
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        builder.addInterceptor(interceptor)
        addAuthHeader(builder)
        val client = builder.build()
        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build()
        return retrofit.create(WebserviceUrls::class.java)
    }

    private fun addAuthHeader(client: OkHttpClient.Builder) {
        if (WebservicePrefSetting.instanceWithoutContext.isRegister) {
            client.addInterceptor { chain ->
                val original = chain.request()
                val password = "info37|Mqu1eow6W8n8t8ptdrk1"
                val encode = HttpRequest.Base64.encode(password)
                val request = original.newBuilder()
                        .addHeader("Authorization", "Basic $encode")
                        .addHeader("appVersion", "2.0.0")
                        .addHeader("Content-Type", "application/json")
                        .build()

                chain.proceed(request)
            }
        }
    }
}
