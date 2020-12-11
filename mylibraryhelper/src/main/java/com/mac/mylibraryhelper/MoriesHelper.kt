package com.mac.mylibraryhelper

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.preference.PreferenceManager
import java.text.DecimalFormat

class MoriesHelper(context: Context?) {

    private val context: Context?

    init {
        this.context = context
    }

    fun showToast(message: String?) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    fun setDataPrefFloat(key: String, value: Float) {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        sharedPreferences.edit().putFloat(key, value).apply()
    }

    fun getDataPrefFloat(key: String): Float {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        return sharedPreferences.getFloat(key, 0.0f)
    }

    fun setDataPrefString(key: String, value: String) {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        sharedPreferences.edit().putString(key, value).apply()
    }

    fun setDataPrefBoolean(key: String, value: Boolean) {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        sharedPreferences.edit().putBoolean(key, value).apply()
    }

    fun getDataPrefBoolean(key: String): Boolean {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        return sharedPreferences.getBoolean(key, false)
    }

    fun getDataPrefString(key: String): String? {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        return sharedPreferences.getString(key, "")
    }

    fun getDataPrefInt(key: String): Int {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        return sharedPreferences.getInt(key, 0)
    }

    fun setDataPrefInt(key: String, value: Int) {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        sharedPreferences.edit().putInt(key, value).apply()
    }

    fun setDataPrefLong(ctx: Context, key: String, value: Long) {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        sharedPreferences.edit().putLong(key, value).apply()
    }

    fun getDataPrefLong(key: String): Long {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        return sharedPreferences.getLong(key, 0)
    }

    fun removeDataPrefString(key: String) {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        sharedPreferences.edit().remove(key).apply()
    }

    fun removeDataPrefBoolean(key: String) {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        sharedPreferences.edit().remove(key).apply()
    }

    fun removeDataInt(key: String) {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
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

    fun alertDialogWithTitle(title: String, message: String?) {
        val success = AlertDialog.Builder(context)
        success.setTitle(title)
        success.setMessage(message)
        success.setPositiveButton("Ok") { _, _ ->

        }
        success.setCancelable(false)
        success.create().show()
    }

    fun alertDialogDefault(message: String?) {
        val success = AlertDialog.Builder(context)
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
}