package chiarajm.android.base.sample.presentation.list

import chiarajm.android.base.sample.data.model.Task
import chiarajm.android.base.sample.presentation.Navigation
import chiarajm.android.base.sample.presentation.utils.recyclerview.RecyclerViewContract
import javax.inject.Inject

class TaskRowPresenter @Inject constructor(
        private val mNavigation: Navigation
) : RecyclerViewContract.Presenter<Task> {

    override fun onPrimaryActionClick(item: Task) {
        mNavigation.showTaskDetailScreen(item.id!!)
    }

    override fun onSecondaryActionClick(item: Task) {

    }

    override fun onLongClick(item: Task): Boolean = false
}
