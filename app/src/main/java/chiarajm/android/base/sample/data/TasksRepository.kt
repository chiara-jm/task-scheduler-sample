package chiarajm.android.base.sample.data

import android.support.annotation.WorkerThread
import chiarajm.android.base.sample.data.model.Task
import chiarajm.android.base.sample.data.model.TaskState
import chiarajm.android.common.Result
import dagger.Binds
import dagger.Module
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton


@Module
abstract class TasksRepositoryModule {

    @Binds
    @Singleton
    abstract fun tasksDataSource(tasksRepository: TasksRepository): TaskDataSource
}

class TasksRepository @Inject constructor() : TaskDataSource {

    private val tasks = mutableMapOf<String, Task>()

    override fun get() = GlobalScope.async {
        Result.Ok(tasks.values.toList())
    }

    override fun get(id: String) = GlobalScope.async {
        tasks[id]?.let { Result.Ok(it) }
        ?: Result.Err(TaskNotFoundException(id))
    }

    override fun save(task: Task) = GlobalScope.async {
        task.id = task.id ?: UUID.randomUUID().toString()
        tasks[task.id!!] = task
        Result.Ok(task)
    }

    @WorkerThread
    override fun remove(task: Task) = GlobalScope.async {
        task.state = TaskState.DELETED
        tasks.remove(task.id)?.let { Result.Ok(it) }
        ?: Result.Err(TaskNotFoundException(task.id!!))
    }
}
