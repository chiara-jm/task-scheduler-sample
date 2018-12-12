package chiarajm.android.base.sample

import chiarajm.android.base.sample.data.TasksRepositoryModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    ActivitiesInjectorModule::class,
    AppModule::class,
    TasksRepositoryModule::class
])
internal interface AppComponent : AndroidInjector<TaskSchedulerApplication> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<TaskSchedulerApplication>()
}
