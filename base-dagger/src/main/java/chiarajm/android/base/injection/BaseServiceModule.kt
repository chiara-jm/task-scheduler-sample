package chiarajm.android.base.injection

import android.app.Service
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
abstract class BaseServiceModule<T : Service> {

    @Provides
    @ActivityScope
    fun service(service: T): Service = service

    @Provides
    @ActivityScope
    @Named(SERVICE_CONTEXT)
    fun serviceContext(service: Service): Context = service
}
