package com.zoptal.munzul.di.component

import android.app.Application
import com.zoptal.munzul.MunzulApp
import com.zoptal.munzul.di.module.ActivityModule
import com.zoptal.munzul.di.module.AppModule
import com.zoptal.munzul.di.module.ContextModule
import com.zoptal.munzul.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


/*
 * We mark this interface with the @Component annotation.
 * And we define all the modules that can be injected.
 * Note that we provide AndroidSupportInjectionModule.class
 * here. This class was not created by us.
 * It is an internal class in Dagger 2.10.
 * Provides our activities and fragments with given module.
 * */
@Component(
    modules = arrayOf(
        ViewModelModule::class,
        AppModule::class,
        ActivityModule::class,
        AndroidSupportInjectionModule::class,
        ContextModule::class
   )
)
@Singleton
interface AppComponent {

    /*
     * We will call this builder interface from our custom Application class.
     * This will set our application object to the AppComponent.
     * So inside the AppComponent the application instance is available.
     * So this application instance can be accessed by our modules
     * such as ApiModule when needed
     *
     * */
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    /*
     * This is our custom Application class
     * */
    fun inject(appController: MunzulApp)
}