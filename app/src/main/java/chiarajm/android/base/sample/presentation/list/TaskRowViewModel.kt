package chiarajm.android.base.sample.presentation.list

import android.content.Context

import chiarajm.android.base.sample.data.model.Task
import chiarajm.android.base.sample.presentation.utils.recyclerview.RecyclerViewRowViewModel
import chiarajm.android.base.sample.presentation.utils.recyclerview.SingleTextRowViewModel

class TaskRowViewModel(
        context: Context
) : RecyclerViewRowViewModel<Task>(context), SingleTextRowViewModel<Task> {
    override val text: String
        get() {
            if (item == null) return ""
            return item!!.state.toString() + " - " + item!!.what
        }
}
