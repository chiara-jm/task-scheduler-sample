package chiarajm.android.base.injection

import android.app.Activity
import android.content.Context
import dagger.Binds
import dagger.Module
import javax.inject.Named

@Module
abstract class BaseActivityModule<T : Activity> {

    @Binds
    @ActivityScope
    abstract fun activity(activity: T): Activity

    @Binds
    @ActivityScope
    @Named(ACTIVITY_CONTEXT)
    abstract fun activityContext(activity: T): Context
}
