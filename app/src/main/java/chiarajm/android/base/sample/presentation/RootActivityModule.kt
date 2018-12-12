package chiarajm.android.base.sample.presentation

import chiarajm.android.base.injection.ActivityScope
import chiarajm.android.base.injection.BaseActivityModule
import dagger.Binds
import dagger.Module

@Module(includes = [
    FragmentsInjectorModule::class
])
abstract class RootActivityModule : BaseActivityModule<RootActivity>() {

    @Binds
    @ActivityScope
    abstract fun navigation(activity: RootActivity): Navigation
}