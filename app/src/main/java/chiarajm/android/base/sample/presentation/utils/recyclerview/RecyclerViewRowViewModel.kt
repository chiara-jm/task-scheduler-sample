package chiarajm.android.base.sample.presentation.utils.recyclerview

import android.content.Context
import chiarajm.android.base.mvp.BaseViewModel


open class RecyclerViewRowViewModel<T>(context: Context) : BaseViewModel(context), RecyclerViewRowContract.ViewModel<T> {

    override var item: T? = null
        protected set

    override fun bind(item: T) {
        this.item = item
        notifyChange()
    }

}
