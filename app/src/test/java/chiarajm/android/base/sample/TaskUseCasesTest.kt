package chiarajm.android.base.sample


import android.util.Log
import chiarajm.android.base.domain.UseCase
import chiarajm.android.base.domain.UseCaseExecutor
import chiarajm.android.base.sample.data.TaskDataSource
import chiarajm.android.base.sample.data.TasksRepository
import chiarajm.android.base.sample.data.model.Task
import chiarajm.android.base.sample.data.model.TaskState
import chiarajm.android.base.sample.domain.usecases.task.*
import io.reactivex.schedulers.Schedulers
import org.hamcrest.CoreMatchers.nullValue
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner

@RunWith(PowerMockRunner::class)
@PrepareForTest(Log::class)
class TaskUseCasesTest {

    var sUseCaseExecutor: UseCaseExecutor = UseCaseExecutor.instance
    var sTaskDataSource: TaskDataSource = TasksRepository()

    private lateinit var task: Task

    @Before
    fun createTask() {
        task = sTaskDataSource.save(Task(TEST_WHAT, System.currentTimeMillis())).blockingGet()
    }

    @Test
    @Throws(Exception::class)
    fun create_task_UC() {

        val time = System.currentTimeMillis()
        sUseCaseExecutor.execute(
                CreateTask(TEST_WHAT, time, sTaskDataSource),
                {
                    //Assert that task has a valid Id
                    assertNotNull(it.id)
                    //Assert that task has correct data
                    assertEquals(TEST_WHAT, it.what)
                    assertEquals(time, it.time)
                    assertEquals(TaskState.PLANNED, it.state)
                },
                { e ->
                    e.printStackTrace()
                    fail(e.message)
                },
                { },
                Schedulers.trampoline(),
                Schedulers.trampoline()
        )
    }

    @Test
    @Throws(Exception::class)
    fun start_task_UC() {
        assert_task_state_transition(
                StartTask(task, sTaskDataSource),
                TaskState.WORKING
        )
    }

    @Test
    @Throws(Exception::class)
    fun pause_task_UC() {
        assert_task_state_transition(
                PauseTask(task, sTaskDataSource),
                TaskState.PAUSED
        )
    }

    @Test
    @Throws(Exception::class)
    fun reschedule_task_UC() {
        assert_task_state_transition(
                RescheduleTask(task, sTaskDataSource),
                TaskState.PLANNED
        )
    }

    @Test
    @Throws(Exception::class)
    fun finish_task_UC() {
        assert_task_state_transition(
                FinishTask(task, sTaskDataSource),
                TaskState.DONE
        )
    }

    @Test
    @Throws(Exception::class)
    fun restart_task_UC() {
        assert_task_state_transition(
                RestartTask(task, sTaskDataSource),
                TaskState.WORKING
        )
    }

    @Test
    @Throws(Exception::class)
    fun archive_task_UC() {
        assert_task_state_transition(
                ArchiveTask(task, sTaskDataSource),
                TaskState.ARCHIVED
        )
    }

    @Test
    @Throws(Exception::class)
    fun delete_task_UC() {
        sUseCaseExecutor.execute(
                DeleteTask(task, sTaskDataSource),
                { assertThat(sTaskDataSource[task.id!!], nullValue()) },
                { it.printStackTrace() },
                {},
                Schedulers.trampoline(),
                Schedulers.trampoline()
        )
    }

    @Throws(Exception::class)
    private fun assert_task_state_transition(transitionUC: UseCase<Task>, state: TaskState) {
        val id = task.id
        val time = task.time
        sUseCaseExecutor.execute(
                transitionUC,
                {
                    //Assert that there are no unexpected changes
                    assertEquals(id, it.id)
                    assertEquals(TEST_WHAT, it.what)
                    assertEquals(time, it.time)
                    //Assert that the state is the expected
                    assertEquals(state, it.state)
                },
                { it.printStackTrace() },
                { },
                Schedulers.trampoline(),
                Schedulers.trampoline()
        )
    }

    companion object {
        const val TEST_WHAT = "TEST WHAT"
    }
}