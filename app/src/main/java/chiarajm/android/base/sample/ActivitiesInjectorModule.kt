package chiarajm.android.base.sample

import chiarajm.android.base.injection.ActivityScope
import chiarajm.android.base.injection.BaseApplicationModule
import chiarajm.android.base.sample.presentation.RootActivity
import chiarajm.android.base.sample.presentation.RootActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivitiesInjectorModule : BaseApplicationModule<TaskSchedulerApplication>() {

    @ActivityScope
    @ContributesAndroidInjector(modules = [RootActivityModule::class])
    abstract fun rootActivity(): RootActivity
}
