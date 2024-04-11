package com.zoptal.munzul.base


import android.app.Dialog
import android.os.Build
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector

import javax.inject.Inject


    abstract class BaseActivity : AppCompatActivity(), HasAndroidInjector {
    @Inject
    lateinit var supportFragmentInjector: DispatchingAndroidInjector<Any>
    private var mProgressDialog: Dialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)

        super.onCreate(savedInstanceState)
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return supportFragmentInjector
    }







  /*  @SuppressLint("HardwareIds")
    fun getAppVersion(): String {
        return BuildConfig.VERSION_NAME
    }*/


    fun setTitle(title: String){
        // supportActionBar?.title=title
    }

    fun popBackStack(){
        supportFragmentManager.popBackStack()
    }

    //show status bar
    fun AppCompatActivity.showSystemUI() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            // show app content in fullscreen, i. e. behind the bars when they are shown (alternative to
            // deprecated View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION and View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
            window.setDecorFitsSystemWindows(false)
            // finally, show the system bars
            window.insetsController?.show(WindowInsets.Type.systemBars())

        } else {
            // Shows the system bars by removing all the flags
            // except for the ones that make the content appear under the system bars.
            @Suppress("DEPRECATION")
            window.decorView.systemUiVisibility = (
                    View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
        }
    }



}
