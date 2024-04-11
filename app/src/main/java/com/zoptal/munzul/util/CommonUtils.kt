package com.zoptal.munzul.util


import android.R
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.res.Configuration
import android.net.Uri
import android.os.Build
import android.provider.Settings
import android.text.TextUtils
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import java.util.*


/*
 * Created by neha on 17/5/18.
 */
class CommonUtils {
    companion object {
        val ACCEPTED = "ACCEPTED"
        var isSheetOpen: Int = 0
        var isImageOpen: Int = 0


        /**
         * @param context=  Describes the instance
         * @param message = Describes the message to show
         * @return void
         * Display Toast Message
         */
        fun showToastMessageShort(context: Context, message: String) {
            Toast.makeText(
                context.applicationContext, message,
                Toast.LENGTH_SHORT
            ).show()
        }

        /**
         * @param context=  Describes the fragment instance
         * @param message = Describes the message to show
         * @return void
         * Display Toast Message
         */
        fun showToastMessageShortFragment(context: Context, message: String) {
            Toast.makeText(
                context, message,
                Toast.LENGTH_SHORT
            ).show()
        }


        /**
         * method to check Tab or Not
         **/
        fun isTablet(context: Context): Boolean {
            return ((context.resources.configuration.screenLayout
                    and Configuration.SCREENLAYOUT_SIZE_MASK)
                    >= Configuration.SCREENLAYOUT_SIZE_LARGE)
        }

        /**
         * @param context
         * @param mView = Id of view
         * @return void
         */
        fun hideKeyboard(context: Context, mView: View?) {
            if (mView != null) {
                val imm =
                    context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(mView.windowToken, 0)
            }
        }

        fun getInitials(name: String): String {
            var nameparts = name.split(" ")
            var initials = ""
            try {
                if (nameparts.size < 4) {
                    for (i in 0..nameparts.size - 1) {
                        initials = initials + nameparts.get(i).substring(0, 1)
                            .uppercase(Locale.getDefault())
                    }
                } else {
                    for (i in 0..2) {
                        initials = initials + nameparts.get(i).substring(0, 1)
                            .uppercase(Locale.getDefault())
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return initials

        }

        fun showErrorDialog(context: Context, message: String, title: String) {
            try {
                if (context != null) {
                    AlertDialog.Builder(context, R.style.Theme_Material_Dialog_Alert)
                        .setTitle(title)
                        .setMessage(message)
                        .setPositiveButton(
                            "Yes",
                            DialogInterface.OnClickListener { dialogInterface: DialogInterface, i: Int ->
                                dialogInterface.cancel()
                                val intent =
                                    Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                                val uri: Uri =
                                    Uri.fromParts("package", context.packageName, null)
                                intent.data = uri
                                context.startActivity(intent)
                            })
                        .setIcon(R.drawable.ic_dialog_alert)
                        .show()
                }
            } catch (e: WindowManager.BadTokenException) {
                showToastMessageShort(context, message)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }


        fun getDeviceName(): String {
            val manufacturer = Build.MANUFACTURER
            val model = Build.MODEL
            return if (model.lowercase(Locale.getDefault())
                    .startsWith(manufacturer.lowercase(Locale.getDefault()))
            ) {
                capitalize(model)
            } else {
                capitalize(manufacturer) + " " + model
            }
        }

        private fun capitalize(s: String?): String {
            if (s == null || s.length == 0) {
                return ""
            }
            val first = s[0]
            return if (Character.isUpperCase(first)) {
                s
            } else {
                Character.toUpperCase(first) + s.substring(1)
            }
        }


        fun isLocationEnabled(context: Context): Boolean {
            var locationMode = 0
            val locationProviders: String

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                try {
                    locationMode = Settings.Secure.getInt(
                        context.contentResolver,
                        Settings.Secure.LOCATION_MODE
                    )

                } catch (e: Settings.SettingNotFoundException) {
                    e.printStackTrace()
                }

                return locationMode != Settings.Secure.LOCATION_MODE_OFF
            } else {
                locationProviders = Settings.Secure.getString(
                    context.contentResolver,
                    Settings.Secure.LOCATION_PROVIDERS_ALLOWED
                )
                return !TextUtils.isEmpty(locationProviders)
            }
        }

    }
}

