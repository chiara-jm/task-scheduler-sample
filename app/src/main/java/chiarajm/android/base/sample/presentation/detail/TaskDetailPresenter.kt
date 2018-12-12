package chiarajm.android.base.sample.presentation.detail

import chiarajm.android.base.mvp.BasePresenter
import chiarajm.android.base.sample.data.TaskDataSource
import chiarajm.android.base.sample.data.model.Task
import chiarajm.android.base.sample.data.model.TaskState
import chiarajm.android.base.sample.domain.usecases.UseCase
import chiarajm.android.base.sample.domain.usecases.task.*
import chiarajm.android.base.sample.presentation.Navigation
import chiarajm.android.common.Result
import chiarajm.android.common.runOnResult
import javax.inject.Inject
import javax.inject.Named

class TaskDetailPresenter @Inject constructor(
        viewModel: TaskDetailContract.ViewModel,
        @param:Named(TaskDetailModule.TASK_ID) private val taskId: String,
        private val navigation: Navigation,
        private val dataSource: TaskDataSource
) : BasePresenter<TaskDetailContract.ViewModel>(viewModel), TaskDetailContract.Presenter {

    override fun start() {
        super.start()
        background {
            dataSource[taskId].runOnResult {
                when (this) {
                    is Result.Err -> error(error)
                    is Result.Ok -> viewModel.task = result
                }
            }
        }
    }

    override fun onMoveBackClicked() = background {
        viewModel.state?.let {
            when (it) {
                TaskState.PLANNED -> deleteTask
                TaskState.WORKING -> pauseTask
                TaskState.PAUSED -> rescheduleTask
                TaskState.DONE -> restartTask
                TaskState.ARCHIVED -> unarchiveTask
                TaskState.DELETED -> error("a deleted task should not be here")
            }().runOnResult {
                when (this) {
                    is Result.Err -> error(error)
                    is Result.Ok -> {
                        viewModel.task = result
                        if (result.state == TaskState.DELETED) {
                            navigation.showTaskListScreen()
                        }
                    }
                }
            }
        }
    }

    override fun onMoveForwardClicked() = background {
        viewModel.state?.let {
            when (it) {
                TaskState.PLANNED -> startTask
                TaskState.WORKING -> finishTask
                TaskState.PAUSED -> restartTask
                TaskState.DONE -> archiveTask
                TaskState.ARCHIVED -> deleteTask
                TaskState.DELETED -> error("a deleted task should not be here")
            }().runOnResult {
                when (this) {
                    is Result.Err -> error(error)
                    is Result.Ok -> {
                        viewModel.task = result
                        if (result.state == TaskState.DELETED) {
                            navigation.showTaskListScreen()
                        }
                    }
                }
            }
        }
    }


    private val restartTask: UseCase<Task> get() = RestartTask(viewModel.task!!, dataSource)

    private val rescheduleTask: UseCase<Task> get() = RescheduleTask(viewModel.task!!, dataSource)

    private val startTask: UseCase<Task> get() = StartTask(viewModel.task!!, dataSource)

    private val pauseTask: UseCase<Task> get() = PauseTask(viewModel.task!!, dataSource)

    private val finishTask: UseCase<Task> get() = FinishTask(viewModel.task!!, dataSource)

    private val unarchiveTask: UseCase<Task> get() = TransitionStateTask(viewModel.task!!, TaskState.DONE, dataSource)

    private val archiveTask: UseCase<Task> get() = ArchiveTask(viewModel.task!!, dataSource)

    private val deleteTask: UseCase<Task> get() = DeleteTask(viewModel.task!!, dataSource)

}
