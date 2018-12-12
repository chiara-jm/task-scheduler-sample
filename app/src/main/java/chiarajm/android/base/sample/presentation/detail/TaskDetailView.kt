package chiarajm.android.base.sample.presentation.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import chiarajm.android.base.mvp.BaseMvpFragment
import chiarajm.android.base.sample.BR
import chiarajm.android.base.sample.databinding.TaskDetailLayoutBinding

class TaskDetailView : BaseMvpFragment<TaskDetailContract.Presenter, TaskDetailContract.ViewModel, TaskDetailLayoutBinding>() {

    override fun inflateDataBinding(inflater: LayoutInflater, container: ViewGroup?): TaskDetailLayoutBinding {
        return TaskDetailLayoutBinding.inflate(inflater, container, false)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = super.onCreateView(inflater, container, savedInstanceState)
        viewModel.onPropertyChanged(
                BR._all
        ){ Toast.makeText(context, viewModel.state?.name, Toast.LENGTH_LONG).show() }

        return root
    }
}
