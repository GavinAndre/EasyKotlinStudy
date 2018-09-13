package com.gavinandre.kotlininteroperatewithjava

import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.File
import java.io.IOException
import java.util.concurrent.TimeUnit

/**
 * Kotlin中调用Java中Okhttp库
 */
object OkhttpUtils {
    fun get(url: String): String? {
        var result: String? = ""
        val okhttp = OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.HOURS)
                .readTimeout(1, TimeUnit.HOURS)
                .writeTimeout(1, TimeUnit.HOURS)
                .build()

        val request = Request.Builder()
                .url(url)
                .build()

        val call = okhttp.newCall(request)

        try {
            val response = call.execute()
            result = response.body()?.string()
            val f = File("run.log")
            f.appendText(result!!)
            f.appendText("\n")

        } catch (e: IOException) {
            e.printStackTrace()
        }

        return result
    }
}