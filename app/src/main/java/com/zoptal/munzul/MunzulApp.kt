package com.zoptal.munzul


import android.app.Application
import android.content.Context
import android.os.StrictMode
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ProcessLifecycleOwner
import androidx.multidex.MultiDex
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import io.reactivex.plugins.RxJavaPlugins
import com.zoptal.munzul.di.component.DaggerAppComponent


import javax.inject.Inject
class MunzulApp  : Application(), HasAndroidInjector, LifecycleObserver {
    val TAG: String = MunzulApp::class.java.simpleName

    companion object {
        var context: Context? = null
        var app: Application? = null

        fun start(mContext: Context) {
            context = mContext
        }


    }

    override fun onCreate() {
        super.onCreate()
        try {
            app = this
            context = this

            val SDK_INT = android.os.Build.VERSION.SDK_INT
            try {
                if (SDK_INT > 8) {
                    val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
                    StrictMode.setThreadPolicy(policy)
                }

                RxJavaPlugins.setErrorHandler { throwable: Throwable? -> } //

            } catch (e: Exception) {
                e.printStackTrace()
            }

            // initializeSocket();
            ProcessLifecycleOwner.get().lifecycle
                .addObserver(this)

            DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this)
            MultiDex.install(this)

        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onMoveToForeground() {
        Log.d("Lifecycle", "Returning to foreground…")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onMoveToBackground() {
        Log.d("Lifecycle", "Moving to background…")

    }


    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> {
        return dispatchingAndroidInjector
    }
}