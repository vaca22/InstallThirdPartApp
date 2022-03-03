package com.vaca.installthirdpartapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.File

class MainActivity : AppCompatActivity() {
    val dataScope = CoroutineScope(Dispatchers.IO)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val strApkToInstall = "app.apk"
//        GlobalScope.launch {
//            val cc = NetCmd.getFile("http://139.9.206.3:8000/app-release.apk")
//            Log.e("dada", cc!!.size.toString())
//
//            File(getExternalFilesDir("Download"), strApkToInstall).writeBytes(cc)
//            val ccx = File(getExternalFilesDir("Download"), strApkToInstall).readBytes()
//            Log.e(
//                "dada",
//                "fduck" + ccx.size + File(
//                    getExternalFilesDir("Download"),
//                    strApkToInstall
//                ).absolutePath
//            )
//        }

        val fileApkToInstall = File(getExternalFilesDir("Download"), strApkToInstall)
        val apkUri = FileProvider.getUriForFile(
            this@MainActivity,
            BuildConfig.APPLICATION_ID + ".provider",
            fileApkToInstall
        )
        val intent = Intent(Intent.ACTION_INSTALL_PACKAGE)
        intent.data = apkUri
        intent.flags = Intent.FLAG_GRANT_READ_URI_PERMISSION
        startActivity(intent)
    }
}