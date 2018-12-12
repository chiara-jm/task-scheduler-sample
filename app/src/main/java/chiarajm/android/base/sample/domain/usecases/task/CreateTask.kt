package chiarajm.android.base.sample.domain.usecases.task

import chiarajm.android.base.sample.data.TaskDataSource
import chiarajm.android.base.sample.data.model.Task
import chiarajm.android.base.sample.domain.usecases.UseCase
import javax.inject.Inject

class CreateTask @Inject
constructor(
        private val what: String,
        private val time: Long,
        private val dataSource: TaskDataSource
) : UseCase<Task> {

    override operator fun invoke() = dataSource.save(Task(what, time))

}
