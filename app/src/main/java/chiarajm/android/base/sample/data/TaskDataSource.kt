package chiarajm.android.base.sample.data

import android.support.annotation.WorkerThread

import chiarajm.android.base.sample.data.model.Task
import chiarajm.android.common.Result
import kotlinx.coroutines.Deferred

interface TaskDataSource {

    fun get(): Deferred<Result<List<Task>>>

    operator fun get(id: String): Deferred<Result<Task>>

    @WorkerThread
    fun save(task: Task): Deferred<Result<Task>>

    @WorkerThread
    fun remove(task: Task): Deferred<Result<Task>>
}

class TaskNotFoundException(val id: String) : Exception()
