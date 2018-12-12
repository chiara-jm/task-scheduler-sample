package chiarajm.android.base.sample.presentation.detail


import android.content.Context
import chiarajm.android.base.injection.ACTIVITY_CONTEXT
import chiarajm.android.base.mvp.BaseViewModel
import chiarajm.android.base.sample.R
import chiarajm.android.base.sample.data.model.Task
import chiarajm.android.base.sample.data.model.TaskState
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject
import javax.inject.Named


class TaskDetailViewModel @Inject constructor(
        @Named(ACTIVITY_CONTEXT) context: Context
) : BaseViewModel(context), TaskDetailContract.ViewModel {

    override var task: Task? = null
        set(value) {
            field = value
            notifyChange()
        }

    internal var mDateFormat = SimpleDateFormat("dd/MM/yyyy")

    override val what: String?
        get() = task?.what

    override val time: String?
        get() {
            if (task == null) return null
            val calendar = Calendar.getInstance()
            calendar.timeInMillis = task!!.time
            return mDateFormat.format(calendar.time)
        }

    override val state: TaskState?
        get() = task?.state

    override val moveBackAction: String?
        get() {
            return when (task?.state) {
                TaskState.PLANNED -> context.getString(R.string.task_action_delete)
                TaskState.WORKING -> context.getString(R.string.task_action_pause)
                TaskState.PAUSED -> context.getString(R.string.task_action_reschedule)
                TaskState.DONE -> context.getString(R.string.task_action_restart)
                TaskState.ARCHIVED -> context.getString(R.string.task_action_unarchive)

                else -> null
            }
        }

    override val moveForwardAction: String?
        get() {
            return when (task?.state) {
                TaskState.PLANNED -> context.getString(R.string.task_action_start)
                TaskState.WORKING -> context.getString(R.string.task_action_finish)
                TaskState.PAUSED -> context.getString(R.string.task_action_restart)
                TaskState.DONE -> context.getString(R.string.task_action_archive)
                TaskState.ARCHIVED -> context.getString(R.string.task_action_delete)

                else -> null
            }
        }

}
