package chiarajm.android.base.injection

import android.support.v4.app.Fragment
import dagger.Binds
import dagger.Module

@Module
abstract class BaseFragmentModule<F : Fragment> {

    @Binds
    @FragmentScope
    abstract fun fragment(fragment: F): Fragment
}
