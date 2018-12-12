package chiarajm.android.base.sample.presentation.detail

import chiarajm.android.base.mvp.MvpPresenter
import chiarajm.android.base.mvp.MvpViewModel
import chiarajm.android.base.sample.data.model.Task
import chiarajm.android.base.sample.data.model.TaskState

interface TaskDetailContract {

    interface Presenter : MvpPresenter {
        fun onMoveBackClicked()

        fun onMoveForwardClicked()
    }

    interface ViewModel : MvpViewModel {

        var task: Task?

        val what: String?

        val time: String?

        val state: TaskState?

        val moveBackAction: String?

        val moveForwardAction: String?
    }
}
