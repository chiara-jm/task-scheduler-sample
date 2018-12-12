package chiarajm.android.base.sample.domain.usecases.task

import chiarajm.android.base.sample.data.TaskDataSource
import chiarajm.android.base.sample.data.model.Task
import chiarajm.android.base.sample.domain.usecases.UseCase

class DeleteTask(
        private val task: Task,
        private val dataSource: TaskDataSource
) : UseCase<Task> {

    override fun invoke() = dataSource.remove(task)

}
