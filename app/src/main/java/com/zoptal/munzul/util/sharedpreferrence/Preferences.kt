package com.zoptal.munzul.util.sharedpreferrence

import android.content.Context

/**
 * Created by Keshav on 12/04/22.
 */
class Preferences {
    companion object {
        var prefs: EncryptedPreferences? = null
        fun initPreferences(context: Context) {
            prefs = EncryptedPreferences(context)
        }
    }
}