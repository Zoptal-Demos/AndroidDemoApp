package com.zoptal.munzul.di.module


import com.zoptal.munzul.base.BaseActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector



@Module
abstract class ActivityModule {

    @get:ContributesAndroidInjector
    internal abstract val baseActivity: BaseActivity

    }