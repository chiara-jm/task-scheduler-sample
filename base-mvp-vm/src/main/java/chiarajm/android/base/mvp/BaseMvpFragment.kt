package chiarajm.android.base.mvp

import android.databinding.ViewDataBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import dagger.android.support.DaggerFragment
import javax.inject.Inject

abstract class BaseMvpFragment<P : MvpPresenter, VM : MvpViewModel, VDB : ViewDataBinding> : DaggerFragment() {

    @Inject
    lateinit var presenter: P
    @Inject
    lateinit var viewModel: VM
    protected var binding: VDB? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): android.view.View? {
        inflateDataBinding(inflater, container).run {
            setVariable(BR.presenter, presenter)
            setVariable(BR.viewModel, viewModel)
            executePendingBindings()
            binding = this
        }
        return binding?.root
    }

    protected abstract fun inflateDataBinding(inflater: LayoutInflater, container: ViewGroup?): VDB

    override fun onStart() {
        super.onStart()
        presenter.start()
    }

    override fun onResume() {
        super.onResume()
        presenter.resume()
    }

    override fun onPause() {
        super.onPause()
        presenter.pause()
    }

    override fun onStop() {
        super.onStop()
        presenter.stop()
    }

}
