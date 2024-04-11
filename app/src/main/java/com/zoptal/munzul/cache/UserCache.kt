package com.zoptal.munzul.cache

import android.content.Context
import com.zoptal.munzul.constants.CacheConstants
import com.zoptal.munzul.util.Prefs


fun getToken(context: Context): String? {
    return Prefs.with(context).getString(CacheConstants.USER_TOKEN, "")
}

fun saveToken(context: Context, token: String) {
    Prefs.with(context).save(CacheConstants.USER_TOKEN, token)
}

fun setUserType(context: Context, value: Int) {
    Prefs.with(context).save(CacheConstants.USER_TYPE, value)
}

fun getUserType(context: Context): Int {
    return Prefs.with(context).getInt(CacheConstants.USER_TYPE, 1)
}

fun clearAllData(context: Context) {
    Prefs.with(context).removeAll()
}

fun getFullName(context: Context): String? {
    return Prefs.with(context).getString(CacheConstants.GET_NAME, "")
}

fun saveFullName(context: Context, fullName: String) {
    Prefs.with(context).save(CacheConstants.GET_NAME, fullName)
}

fun getPhoneNumber(context: Context): String? {
    return Prefs.with(context).getString(CacheConstants.GET_PHONE, "")
}

fun savePhoneNumber(context: Context, phoneNumber: String) {
    Prefs.with(context).save(CacheConstants.GET_PHONE, phoneNumber)
}

fun getAudioFile(context: Context): String? {
    return Prefs.with(context).getString(CacheConstants.FILE_NAME, "")
}

fun saveAudioFile(context: Context, file: String) {
    Prefs.with(context).save(CacheConstants.FILE_NAME, file)
}

fun getEmail(context: Context): String? {
    return Prefs.with(context).getString(CacheConstants.EMAIL, "")
}

fun saveEmail(context: Context, phoneNumber: String) {
    Prefs.with(context).save(CacheConstants.EMAIL, phoneNumber)
}

fun getScreenStatus(context: Context): String? {
    return Prefs.with(context).getString(CacheConstants.SCREEN_STATUS, "")
}

fun saveScreenStatus(context: Context, phoneNumber: String) {
    Prefs.with(context).save(CacheConstants.SCREEN_STATUS, phoneNumber)
}

fun getWallpaper(context: Context): String? {
    return Prefs.with(context).getString(CacheConstants.WALLPAPER, "")
}

fun saveWallpaper(context: Context, imageName: String) {
    Prefs.with(context).save(CacheConstants.WALLPAPER, imageName)
}

fun getAlertText(context: Context): String? {
    return Prefs.with(context).getString(CacheConstants.ALERT_TEXT, "")
}

fun saveAlertText(context: Context, text: String) {
    Prefs.with(context).save(CacheConstants.ALERT_TEXT, text)
}

fun getMessageType(context: Context): Int {
    return Prefs.with(context).getInt(CacheConstants.MSG_TYPE, 0)
}

fun saveMessageType(context: Context, text: Int) {
    Prefs.with(context).save(CacheConstants.MSG_TYPE, text)
}

fun getSessionExpired(context: Context): Boolean {
    return Prefs.with(context).getBoolean(CacheConstants.SESSION, false)
}

fun setSessionExpired(context: Context, text: Boolean) {
    Prefs.with(context).save(CacheConstants.SESSION, text)
}




