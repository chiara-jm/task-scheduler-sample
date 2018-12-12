package chiarajm.android.base.sample.presentation.utils.recyclerview

class RecyclerViewRowPresenter<T>(
        private val mPresenter: RecyclerViewContract.Presenter<T>,
        private val mViewModel: RecyclerViewRowContract.ViewModel<T>) : RecyclerViewRowContract.Presenter {

    override fun performPrimaryAction() {
        mPresenter.onPrimaryActionClick(mViewModel.item!!)
    }

    override fun performSecondaryAction() {
        mPresenter.onSecondaryActionClick(mViewModel.item!!)
    }

    override fun performLongClick(): Boolean {
        return mPresenter.onLongClick(mViewModel.item!!)
    }
}
