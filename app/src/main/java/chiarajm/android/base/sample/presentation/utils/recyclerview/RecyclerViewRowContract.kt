package chiarajm.android.base.sample.presentation.utils.recyclerview

import android.databinding.Observable

interface RecyclerViewRowContract {

    interface View

    interface Presenter {
        fun performPrimaryAction()
        fun performSecondaryAction()
        fun performLongClick(): Boolean
    }

    interface ViewModel<T> : Observable {
        val item: T?
        fun bind(item: T)
    }
}
