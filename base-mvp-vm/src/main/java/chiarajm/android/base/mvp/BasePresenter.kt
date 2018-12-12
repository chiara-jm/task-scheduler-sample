package chiarajm.android.base.mvp

import android.support.annotation.MainThread
import android.support.annotation.VisibleForTesting
import kotlinx.coroutines.*
import timber.log.Timber

abstract class BasePresenter<VM : MvpViewModel>(val viewModel: VM) : MvpPresenter {

    private val jobs = mutableListOf<Job>()

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    var launchInBackground: (suspend CoroutineScope.() -> Unit) -> Job = { block ->
        GlobalScope.launch(Dispatchers.Main) { block(this) }
    }

    @MainThread
    override fun start() {
        Timber.d("started: ${this}")
    }

    @MainThread
    override fun resume() {
        Timber.d("resumed: ${this}")
    }

    @MainThread
    override fun pause() {
        Timber.d("paused: ${this}")
    }

    @MainThread
    override fun stop() {
        Timber.d("stopped:  ${this}")
        jobs.forEach { it.cancel() }
        jobs.clear()
    }

    fun background(block: suspend CoroutineScope.() -> Unit) {
        jobs.add(launchInBackground(block))
    }
}
