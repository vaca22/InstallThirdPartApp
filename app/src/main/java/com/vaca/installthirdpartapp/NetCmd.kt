package com.vaca.installthirdpartapp


import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream
import java.security.MessageDigest
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.HashMap


object NetCmd {
    private val client = OkHttpClient();
    private val JSON: MediaType? = "application/json; charset=utf-8".toMediaTypeOrNull()

    fun getFile(url: String):ByteArray? {
        val request: Request = Request.Builder().url(url).build()
        client.newCall(request).execute().use {
            return (it.body?.bytes())
        }
    }




}