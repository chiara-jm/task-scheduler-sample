package chiarajm.android.base.sample.domain.usecases.task

import chiarajm.android.base.sample.data.TaskDataSource
import chiarajm.android.base.sample.data.model.Task
import chiarajm.android.base.sample.data.model.TaskState
import chiarajm.android.base.sample.domain.usecases.UseCase
import chiarajm.android.common.Result
import kotlinx.coroutines.Deferred

open class TransitionStateTask(
        private val task: Task,
        private val state: TaskState,
        private val dataSource: TaskDataSource
) : UseCase<Task> {

    override operator fun invoke(): Deferred<Result<Task>> {
        task.state = state
        return dataSource.save(task)
    }
}


class StartTask(
        task: Task,
        dataSource: TaskDataSource
) : TransitionStateTask(task, TaskState.WORKING, dataSource)

class PauseTask(
        task: Task,
        dataSource: TaskDataSource
) : TransitionStateTask(task, TaskState.PAUSED, dataSource)

class RestartTask(
        task: Task,
        dataSource: TaskDataSource
) : TransitionStateTask(task, TaskState.WORKING, dataSource)

class FinishTask(
        task: Task,
        dataSource: TaskDataSource
) : TransitionStateTask(task, TaskState.DONE, dataSource)

class ArchiveTask(
        task: Task,
        dataSource: TaskDataSource
) : TransitionStateTask(task, TaskState.ARCHIVED, dataSource)


class RescheduleTask(
        task: Task,
        dataSource: TaskDataSource
) : TransitionStateTask(task, TaskState.PLANNED, dataSource)
