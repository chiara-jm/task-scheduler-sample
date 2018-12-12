package chiarajm.android.base.sample.presentation.list

import chiarajm.android.base.mvp.BasePresenter
import chiarajm.android.base.sample.data.TaskDataSource
import chiarajm.android.base.sample.presentation.Navigation
import chiarajm.android.common.Result
import chiarajm.android.common.runOnResult
import javax.inject.Inject

class TaskListPresenter @Inject constructor(
        viewModel: TaskListContract.ViewModel,
        private val navigation: Navigation,
        private val dataSource: TaskDataSource
) : BasePresenter<TaskListContract.ViewModel>(viewModel), TaskListContract.Presenter {

    override fun start() {
        background {
            dataSource.get().runOnResult {
                when (this) {
                    is Result.Err -> error(error)
                    is Result.Ok -> viewModel.setItems(result)
                }
            }
        }
    }

    override fun onCreateClick() {
        navigation.showCreateTaskScreen()
    }
}
