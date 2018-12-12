package chiarajm.android.base.sample.presentation.utils.recyclerview

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import chiarajm.android.base.sample.BR


class RecyclerViewRowViewHolder(
        layoutId: Int,
        parent: ViewGroup,
        presenter: Any,
        viewModel: Any) : RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(layoutId, parent, false)), RecyclerViewRowContract.View {

    val binding: ViewDataBinding? = DataBindingUtil.bind(itemView)

    init {
        binding!!.setVariable(BR.presenter, presenter)
        binding.setVariable(BR.viewModel, viewModel)
    }
}