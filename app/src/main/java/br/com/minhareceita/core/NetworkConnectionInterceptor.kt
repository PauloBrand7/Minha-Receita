package br.com.minhareceita.core

import android.content.Context
import android.net.ConnectivityManager
import okhttp3.Interceptor
import okhttp3.Response

class NetworkConnectionInterceptor(private val context: Context) : Interceptor {


    override fun intercept(chain: Interceptor.Chain): Response {
//        val connectivityManager =
//            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
//        val isConnected = connectivityManager.activeNetworkInfo?.isConnected ?: false

//        if (!isConnected) {
//
//        }

        val builder = chain.request().newBuilder()
        return chain.proceed(builder.build())

    }
}