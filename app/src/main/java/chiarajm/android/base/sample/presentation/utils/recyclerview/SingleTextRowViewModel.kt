package chiarajm.android.base.sample.presentation.utils.recyclerview

interface SingleTextRowViewModel<T> : RecyclerViewRowContract.ViewModel<T> {
    val text: String
}
