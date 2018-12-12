package chiarajm.android.base.sample.presentation.create

import chiarajm.android.base.injection.FragmentScope
import chiarajm.android.base.mvp.BasePresenter
import chiarajm.android.base.sample.data.TaskDataSource
import chiarajm.android.base.sample.domain.usecases.task.CreateTask
import chiarajm.android.base.sample.presentation.Navigation
import chiarajm.android.common.Result
import chiarajm.android.common.runOnResult
import javax.inject.Inject

@FragmentScope
class TaskCreatePresenter @Inject constructor(
        viewModel: TaskCreateContract.ViewModel,
        private val navigation: Navigation,
        private val dataSource: TaskDataSource
) : BasePresenter<TaskCreateContract.ViewModel>(viewModel), TaskCreateContract.Presenter {

    override fun start() {}

    override fun createTask() = background {
        CreateTask(
                viewModel.what ?: "",
                viewModel.time,
                dataSource)().runOnResult {
            when (this) {
                is Result.Err -> navigation.showError(error.message)
                is Result.Ok -> {
                    navigation.closeCurrentScreen()
                    navigation.showTaskDetailScreen(result.id!!)
                }
            }
        }
    }
}
