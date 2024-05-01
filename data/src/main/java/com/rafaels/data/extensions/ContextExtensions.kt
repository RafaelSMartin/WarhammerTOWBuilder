package com.rafaels.data.extensions

import android.content.Context
import java.io.IOException

fun Context.getJsonDataFromAsset(fileName: String): String? = try {
    assets.open(fileName).bufferedReader().use { it.readText() }
} catch (e: IOException) {
    e.printStackTrace()
    null
}