package chiarajm.android.base.mvp

import android.content.Context
import android.databinding.BaseObservable
import android.databinding.Observable
import android.util.SparseArray
import java.util.*

open class BaseViewModel(protected val context: Context) : BaseObservable(), MvpViewModel {

    private val onChangeObservers = SparseArray<MutableList<() -> Unit>>()


    init {
        addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable, propertyId: Int) {

                if (onChangeObservers[propertyId] != null) {
                    onChangeObservers[propertyId].forEach { it.invoke() }
                }
            }
        })
    }

    override fun onPropertyChanged(propertyId: Int, action: () -> Unit) {
        if (onChangeObservers[propertyId] != null) {
            onChangeObservers[propertyId].add(action)
        } else {
            val observers = ArrayList<() -> Unit>()
            observers.add(action)
            onChangeObservers.put(propertyId, observers)
        }
    }
}
