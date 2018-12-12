package chiarajm.android.base.sample.presentation.create

import android.content.Context
import chiarajm.android.base.injection.ACTIVITY_CONTEXT
import chiarajm.android.base.injection.FragmentScope
import chiarajm.android.base.mvp.BaseViewModel
import java.util.*
import javax.inject.Inject
import javax.inject.Named

@FragmentScope
class TaskCreateViewModel @Inject constructor(
        @Named(ACTIVITY_CONTEXT) context: Context
) : BaseViewModel(context), TaskCreateContract.ViewModel {

    override var what: String? = null
    override val calendar = Calendar.getInstance()!!

    override var time: Long
        get() = calendar.timeInMillis
        set(time) {
            calendar.timeInMillis = time
        }
}
