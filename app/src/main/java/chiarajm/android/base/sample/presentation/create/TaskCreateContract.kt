package chiarajm.android.base.sample.presentation.create

import chiarajm.android.base.mvp.MvpPresenter
import chiarajm.android.base.mvp.MvpViewModel
import java.util.*

interface TaskCreateContract {

    interface Presenter : MvpPresenter {
        fun createTask()
    }

    interface ViewModel : MvpViewModel {

        var what: String?

        val calendar: Calendar
        var time: Long
    }
}
