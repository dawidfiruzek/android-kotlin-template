package {{ cookiecutter.core_package_name }}.utils

import android.databinding.BindingAdapter
import android.view.View

@BindingAdapter("android:visible")
fun View.setVisibile(isVisible: Boolean) {
    visibility = if (isVisible) View.VISIBLE else View.GONE
}
