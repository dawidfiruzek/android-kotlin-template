package {{ cookiecutter.core_package_name }}.ui

import android.content.Intent
import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.v7.app.AppCompatActivity
import {{ cookiecutter.core_package_name }}.presentation.BaseContract
import dagger.android.AndroidInjection
import javax.inject.Inject

abstract class BaseActivity<Presenter : BaseContract.Presenter> : AppCompatActivity() {

    @Inject lateinit var presenter: Presenter

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    @CallSuper
    override fun onStart() {
        super.onStart()
        presenter.initialize()
    }

    @CallSuper
    override fun onStop() {
        super.onStop()
        presenter.clear()
    }

    fun <T : BaseActivity<VM, DB>> startActivity(
            activityClass: Class<T>,
            flags: List<Int>? = null,
            extras: Bundle? = null
    ) {
        val intent = Intent(this, activityClass)
        flags?.forEach { intent.addFlags(it) }
        extras?.let { intent.putExtras(it) }
        startActivity(intent)
    }
}