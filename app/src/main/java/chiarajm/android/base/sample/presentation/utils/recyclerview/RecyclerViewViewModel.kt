package chiarajm.android.base.sample.presentation.utils.recyclerview

import android.content.Context
import chiarajm.android.base.mvp.BaseViewModel


open class RecyclerViewViewModel<T> : BaseViewModel, RecyclerViewContract.ViewModel<T> {

    @get:Deprecated("")
    override lateinit var adapter: RecyclerViewAdapter<T>

    @Deprecated("")
    constructor(context: Context) : super(context)

    constructor(context: Context, adapter: RecyclerViewAdapter<T>) : super(context) {
        this.adapter = adapter
    }

    override fun setItems(items: List<T>) {
        adapter.setItems(items)
    }

    override fun updateItem(item: T) {
        adapter.updateItem(item)
    }

    override fun dropItem(item: T) {
        adapter.dropItem(item)
    }
}
