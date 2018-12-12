package chiarajm.android.base.mvp

import android.databinding.Observable

interface MvpPresenter {

    fun start()

    fun resume()

    fun pause()

    fun stop()

}

interface MvpViewModel : Observable {

    fun onPropertyChanged(propertyId: Int, action: () -> Unit)
}

