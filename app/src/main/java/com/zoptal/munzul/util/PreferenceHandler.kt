package com.zoptal.munzul.util

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type



object PreferenceHandler {

    val PREF_NAME = "TEAMMEET_PREFERENCES"
    val MODE = Context.MODE_PRIVATE
    val USER_ID = "USER_ID"


    fun writeBoolean(context: Context, key: String, value: Boolean) {
        getEditor(context).putBoolean(key, value).commit()
    }

    fun readBoolean(context: Context, key: String,
                    defValue: Boolean): Boolean {
        return getPreferences(context).getBoolean(key, defValue)
    }

    fun writeInteger(context: Context, key: String, value: Int) {
        getEditor(context).putInt(key, value).commit()
    }

    fun readInteger(context: Context, key: String, defValue: Int): Int {
        return getPreferences(context).getInt(key, defValue)
    }

    fun writeString(context: Context, key: String, value: String) {
        getEditor(context).putString(key, value).commit()
    }

    fun readString(context: Context, key: String, defValue: String): String {
        return getPreferences(context).getString(key, defValue)!!
    }

    fun writeFloat(context: Context, key: String, value: Float) {
        getEditor(context).putFloat(key, value).commit()
    }

    fun readFloat(context: Context, key: String, defValue: Float): Float {
        return getPreferences(context).getFloat(key, defValue)
    }

    fun writeLong(context: Context, key: String, value: Long) {
        getEditor(context).putLong(key, value).commit()
    }

    fun readLong(context: Context, key: String, defValue: Long): Long {
        return getPreferences(context).getLong(key, defValue)
    }

    fun getPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREF_NAME, MODE)
    }

    fun getEditor(context: Context): SharedPreferences.Editor {
        return getPreferences(context).edit()
    }

    fun clearSharePreferences(context: Context) {
        val preferences = context.getSharedPreferences(PREF_NAME, MODE)
        preferences.edit().clear().apply()
    }
   /* fun getUserId(context: Context):String{
        return readString(context, PreferenceHandler.USER_ID, "")
    }*/


    fun <T> setList(context: Context, key: String, list: List<T>) {
        val gson = Gson()
        val json = gson.toJson(list)
        set(context, key, json)
    }

    operator fun set(context: Context, key: String, value: String) {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)

        if (preferences != null) {
            val prefsEditor = preferences.edit()
            prefsEditor.putString(key, value)
            prefsEditor.commit()
        }
    }
    fun saveArrayList(context: Context,list: ArrayList<String?>?, key: String?) {
        val prefs: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        val editor: SharedPreferences.Editor = prefs.edit()
        val gson = Gson()
        val json: String = gson.toJson(list)
        editor.putString(key, json)
        editor.apply()
    }

    fun getArrayList(context: Context,key: String?): ArrayList<String?>? {
        val prefs: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        val gson = Gson()
        val json: String = prefs.getString(key, null)!!
        val type: Type = object : TypeToken<ArrayList<String?>?>() {}.type
        return gson.fromJson(json, type)
    }

}
