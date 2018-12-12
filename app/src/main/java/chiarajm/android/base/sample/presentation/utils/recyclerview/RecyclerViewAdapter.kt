package chiarajm.android.base.sample.presentation.utils.recyclerview

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import java.util.*

abstract class RecyclerViewAdapter<T> : RecyclerView.Adapter<RecyclerViewRowViewHolder>() {

    protected var mItems: MutableList<T> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewRowViewHolder {
        val viewModel = createViewModel(viewType, parent.context)
        val presenter = createPresenter(viewType, viewModel, parent.context)
        return RecyclerViewRowViewHolder(getLayoutId(viewType), parent, presenter, viewModel)
    }

    protected abstract fun createPresenter(viewType: Int, viewModel: Any, context: Context): Any

    protected abstract fun getLayoutId(viewType: Int): Int

    protected abstract fun createViewModel(viewType: Int, context: Context): Any

    abstract override fun onBindViewHolder(holder: RecyclerViewRowViewHolder, position: Int)

    override fun getItemCount(): Int {
        return mItems.size
    }

    fun setItems(items: List<T>) {
        mItems = ArrayList(items)
        notifyDataSetChanged()
    }

    fun updateItem(item: T) {
        if (mItems.contains(item)) {
            val i = mItems.indexOf(item)
            mItems[i] = item
            notifyItemChanged(i)
        }
    }

    protected fun getItem(position: Int): T {
        return mItems[position]
    }

    override fun getItemViewType(position: Int): Int {
        return ITEM_ROW
    }

    fun dropItem(item: T) {
        if (mItems.contains(item)) {
            val i = mItems.indexOf(item)
            mItems.removeAt(i)
            notifyItemRemoved(i)
        }
    }

    companion object {

        val ITEM_ROW = 0
    }
}
