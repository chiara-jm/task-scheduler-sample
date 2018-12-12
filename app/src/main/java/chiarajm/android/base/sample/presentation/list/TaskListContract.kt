package chiarajm.android.base.sample.presentation.list

import chiarajm.android.base.mvp.MvpPresenter
import chiarajm.android.base.sample.data.model.Task
import chiarajm.android.base.sample.presentation.utils.recyclerview.RecyclerViewContract

interface TaskListContract {

    interface Presenter : MvpPresenter {

        fun onCreateClick()

    }

    interface ViewModel : RecyclerViewContract.ViewModel<Task>
}
