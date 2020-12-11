package com.mac.mylibraryhelper

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.preference.PreferenceManager
import java.text.DecimalFormat

fun showToast(context: Context?, message: String?) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}

fun setDataPrefFloat(ctx: Context, key: String, value: Float) {
    val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(ctx)
    sharedPreferences.edit().putFloat(key, value).apply()
}

fun getDataPrefFloat(ctx: Context, key: String): Float {
    val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(ctx)
    return sharedPreferences.getFloat(key, 0.0f)
}

fun setDataPrefString(ctx: Context, key: String, value: String) {
    val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(ctx)
    sharedPreferences.edit().putString(key, value).apply()
}

fun setDataPrefBoolean(ctx: Context, key: String, value: Boolean) {
    val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(ctx)
    sharedPreferences.edit().putBoolean(key, value).apply()
}

fun getDataPrefBoolean(ctx: Context, key: String): Boolean {
    val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(ctx)
    return sharedPreferences.getBoolean(key, false)
}

fun getDataPrefString(ctx: Context, key: String): String? {
    val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(ctx)
    return sharedPreferences.getString(key, "")
}

fun getDataPrefInt(ctx: Context, key: String): Int {
    val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(ctx)
    return sharedPreferences.getInt(key, 0)
}

fun setDataPrefInt(ctx: Context, key: String, value: Int) {
    val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(ctx)
    sharedPreferences.edit().putInt(key, value).apply()
}

fun setDataPrefLong(ctx: Context, key: String, value: Long) {
    val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(ctx)
    sharedPreferences.edit().putLong(key, value).apply()
}

fun getDataPrefLong(ctx: Context, key: String): Long {
    val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(ctx)
    return sharedPreferences.getLong(key, 0)
}

fun removeDataPrefString(ctx: Context, key: String) {
    val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(ctx)
    sharedPreferences.edit().remove(key).apply()
}

fun removeDataPrefBoolean(ctx: Context, key: String) {
    val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(ctx)
    sharedPreferences.edit().remove(key).apply()
}

fun removeDataInt(ctx: Context, key: String) {
    val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(ctx)
    sharedPreferences.edit().remove(key).apply()
}

fun myInflateRecyclerViewAdapter(parent: ViewGroup, resource: Int) =
    LayoutInflater.from(parent.context).inflate(resource, parent, false) as View

fun getDecimal(value: Int): String {
    return try {
        val dec = DecimalFormat("#,###.##")
        dec.format(value)
    } catch (e: Exception) {
        "0"
    }
}

fun alertDialogWithTitle(context: Context?, title: String, message: String?) {
    val success = AlertDialog.Builder(context!!)
    success.setTitle(title)
    success.setMessage(message)
    success.setPositiveButton("Ok") { _, _ ->

    }
    success.setCancelable(false)
    success.create().show()
}

fun alertDialogDefault(context: Context?, message: String?) {
    val success = AlertDialog.Builder(context!!)
    success.setMessage(message)
    success.setPositiveButton("Ok") { _, _ ->

    }
    success.setCancelable(false)
    success.create().show()
}

fun changeToRupiah(price: Int): String {
    val formatter = DecimalFormat("#,###")
    val convert = formatter.format(price)
    val filter = convert.replace(",", ".")
    return "Rp. $filter"
}

fun changeWithoutRupiah(price: Int): String {
    val formatter = DecimalFormat("#,###")
    val convert = formatter.format(price)
    return convert.replace(",", ".")
}