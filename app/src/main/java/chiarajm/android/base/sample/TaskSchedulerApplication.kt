package chiarajm.android.base.sample

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class TaskSchedulerApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder().create(this).inject(this)
        //        DaggerAppComponent.create().inject(this);
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return activityInjector
    }
}