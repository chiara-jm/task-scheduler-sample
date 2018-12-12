package chiarajm.android.base.sample.presentation.list

import android.content.Context
import chiarajm.android.base.injection.ACTIVITY_CONTEXT
import chiarajm.android.base.sample.data.model.Task
import chiarajm.android.base.sample.presentation.utils.recyclerview.RecyclerViewAdapter
import chiarajm.android.base.sample.presentation.utils.recyclerview.RecyclerViewViewModel
import javax.inject.Inject
import javax.inject.Named


class TaskListViewModel @Inject constructor(
        @Named(ACTIVITY_CONTEXT) context: Context,
        adapter: RecyclerViewAdapter<Task>
) : RecyclerViewViewModel<Task>(context, adapter), TaskListContract.ViewModel
