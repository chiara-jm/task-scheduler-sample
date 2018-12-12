package chiarajm.android.base.injection

import android.app.Application
import android.content.Context

import javax.inject.Named
import javax.inject.Singleton

import dagger.Binds
import dagger.Module

@Module
abstract class BaseApplicationModule<T : Application> {

    @Binds
    @Singleton
    internal abstract fun application(app: T): Application

    @Binds
    @Named(APPLICATION_CONTEXT)
    @Singleton
    internal abstract fun applicationContext(app: T): Context
}
