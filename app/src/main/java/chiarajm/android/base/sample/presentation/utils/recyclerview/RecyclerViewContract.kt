package chiarajm.android.base.sample.presentation.utils.recyclerview

import chiarajm.android.base.mvp.MvpViewModel

interface RecyclerViewContract {

    interface Presenter<T> {
        fun onPrimaryActionClick(item: T)

        fun onSecondaryActionClick(item: T)

        fun onLongClick(item: T): Boolean
    }

    interface ViewModel<T> : MvpViewModel {

        @set:Deprecated("")
        var adapter: RecyclerViewAdapter<T>

        fun setItems(items: List<T>)

        fun updateItem(item: T)

        fun dropItem(t: T)
    }
}