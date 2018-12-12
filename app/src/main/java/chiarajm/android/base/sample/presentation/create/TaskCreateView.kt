package chiarajm.android.base.sample.presentation.create

import android.view.LayoutInflater
import android.view.ViewGroup

import chiarajm.android.base.mvp.BaseMvpFragment
import chiarajm.android.base.sample.databinding.TaskCreateLayoutBinding

class TaskCreateView : BaseMvpFragment<TaskCreateContract.Presenter, TaskCreateContract.ViewModel, TaskCreateLayoutBinding>() {

    override fun inflateDataBinding(inflater: LayoutInflater, container: ViewGroup?): TaskCreateLayoutBinding =
            TaskCreateLayoutBinding.inflate(inflater, container, false)
}
