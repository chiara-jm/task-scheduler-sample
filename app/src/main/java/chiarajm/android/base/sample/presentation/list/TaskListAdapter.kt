package chiarajm.android.base.sample.presentation.list

import android.content.Context
import chiarajm.android.base.sample.R
import chiarajm.android.base.sample.data.model.Task
import chiarajm.android.base.sample.databinding.SingleTextRowLayoutBinding
import chiarajm.android.base.sample.presentation.utils.recyclerview.*
import javax.inject.Inject

class TaskListAdapter @Inject constructor(
        private val mPresenter: RecyclerViewContract.Presenter<Task>?
) : RecyclerViewAdapter<Task>() {

    override fun createPresenter(viewType: Int, viewModel: Any, context: Context): Any {
        return RecyclerViewRowPresenter(mPresenter!!, viewModel as RecyclerViewRowContract.ViewModel<Task>)
    }

    override fun getLayoutId(viewType: Int): Int {
        return R.layout.single_text_row_layout
    }

    override fun createViewModel(viewType: Int, context: Context): RecyclerViewRowContract.ViewModel<Task> {
        return TaskRowViewModel(context)
    }

    override fun onBindViewHolder(holder: RecyclerViewRowViewHolder, position: Int) {
        (holder.binding as SingleTextRowLayoutBinding).viewModel?.bind(getItem(position))
    }

}
