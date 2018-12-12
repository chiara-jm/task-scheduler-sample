package chiarajm.android.base.sample.presentation.utils

import android.databinding.BindingAdapter
import android.graphics.drawable.Drawable
import android.net.Uri
import android.support.v7.content.res.AppCompatResources
import android.view.View
import android.widget.DatePicker
import android.widget.ImageView
import android.widget.TextView
import java.util.*

object ViewAdapters {

    @JvmStatic
    @BindingAdapter("android:visibility")
    fun setVisibility(view: View, visible: Boolean) {
        view.visibility = if (visible) View.VISIBLE else View.GONE
    }

    @JvmStatic
    @BindingAdapter("android:background")
    fun setBackgroundResource(imageView: ImageView, resource: Int) {
        imageView.setBackgroundResource(resource)
    }

    @JvmStatic
    @BindingAdapter("android:background")
    fun setBackgroundDrawable(view: ImageView, drawable: Drawable) {
        view.background = drawable
    }

}


object DatePickerAdapters {

    @JvmStatic
    @BindingAdapter("calendar")
    fun setCalendar(view: DatePicker, calendar: Calendar?) {
        if (calendar == null) return
        view.init(
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
        ) { datePicker, year, month, day ->
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, month)
            calendar.set(Calendar.DAY_OF_MONTH, day)
        }
    }
}


object ImageViewAdapters {

    @JvmStatic
    @BindingAdapter("android:src")
    fun setImageUri(view: ImageView, imageUri: Uri) {
        view.setImageURI(imageUri)
    }

    @JvmStatic
    @BindingAdapter("android:src")
    fun setImageDrawable(view: ImageView, drawable: Drawable) {
        view.setImageDrawable(drawable)
    }

    @JvmStatic
    @BindingAdapter("android:src")
    fun setImageResource(imageView: ImageView, resource: Int) {
        imageView.setImageResource(resource)
    }
}


object TextViewAdapters {

    @JvmStatic
    @BindingAdapter("android:drawableLeft")
    fun setDrawableLeft(view: TextView, resourceId: Int) {
        view.setCompoundDrawablesWithIntrinsicBounds(
                AppCompatResources.getDrawable(view.context, resourceId),
                null, null, null
        )
    }

    @JvmStatic
    @BindingAdapter("android:drawableStart")
    fun setDrawableStart(view: TextView, resourceId: Int) {
        view.setCompoundDrawablesWithIntrinsicBounds(
                AppCompatResources.getDrawable(view.context, resourceId), null, null, null
        )
    }

    @JvmStatic
    @BindingAdapter("android:drawableRight")
    fun setDrawableRight(view: TextView, resourceId: Int) {
        view.setCompoundDrawablesWithIntrinsicBounds(
                AppCompatResources.getDrawable(view.context, resourceId), null, null, null
        )
    }

    @JvmStatic
    @BindingAdapter("android:drawableEnd")
    fun setDrawableEnd(view: TextView, resourceId: Int) {
        view.setCompoundDrawablesWithIntrinsicBounds(null, null,
                AppCompatResources.getDrawable(view.context, resourceId), null
        )
    }

    @JvmStatic
    @BindingAdapter("android:drawableTop")
    fun setDrawableTop(view: TextView, resourceId: Int) {
        view.setCompoundDrawablesWithIntrinsicBounds(null,
                AppCompatResources.getDrawable(view.context, resourceId), null, null
        )
    }

    @JvmStatic
    @BindingAdapter("android:drawableBottom")
    fun setDrawableBottom(view: TextView, resourceId: Int) {
        view.setCompoundDrawablesWithIntrinsicBounds(null, null, null,
                AppCompatResources.getDrawable(view.context, resourceId)
        )
    }

    @JvmStatic
    @BindingAdapter("android:text")
    fun setText(view: TextView, resourceId: Int) {
        if (resourceId == 0) {
            view.text = ""
        } else {
            view.setText(resourceId)
        }
    }
}
