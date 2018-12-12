package chiarajm.android.base.sample.presentation.list

import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.ViewGroup

import chiarajm.android.base.mvp.BaseMvpFragment
import chiarajm.android.base.sample.databinding.TasksListLayoutBinding

class TaskListView : BaseMvpFragment<TaskListContract.Presenter, TaskListContract.ViewModel, TasksListLayoutBinding>() {

    override fun inflateDataBinding(inflater: LayoutInflater, container: ViewGroup?): TasksListLayoutBinding {
        val binding = TasksListLayoutBinding.inflate(inflater, container, false)
        binding.recyclerView.layoutManager = LinearLayoutManager(container!!.context)
        return binding
    }

}
