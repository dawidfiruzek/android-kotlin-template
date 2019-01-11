package {{ cookiecutter.core_package_name }}.ui

import android.content.Intent
import android.os.Parcelable
import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import javax.inject.Inject

abstract class BaseActivity : AppCompatActivity() {

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    fun <T : BaseActivity> startActivity(
            activityClass: Class<T>,
            flags: List<Int>? = null,
            parcelable: Pair<String, Parcelable>? = null
    ) {
        val intent = Intent(this, activityClass)
        flags?.forEach { intent.addFlags(it) }
        parcelable?.let { intent.putExtra(it.first, it.second) }
        startActivity(intent)
    }
}