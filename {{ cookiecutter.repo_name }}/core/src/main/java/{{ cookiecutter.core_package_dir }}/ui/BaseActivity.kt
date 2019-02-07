package {{ cookiecutter.core_package_name }}.ui

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import {{ cookiecutter.core_package_name }}.presentation.ViewModelFactory
import javax.inject.Inject

abstract class BaseActivity<VM : ViewModel, DB: ViewDataBinding> : AppCompatActivity() {

    @Inject lateinit var viewModelFactory: ViewModelFactory<VM>
    protected lateinit var viewModel: VM
    protected abstract val viewModelClassToken: Class<VM>
    private lateinit var dataBinding: DB

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(viewModelClassToken)
        dataBinding = getBinding()
        dataBinding.setLifecycleOwner(this)
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

    abstract fun getBinding(): DB
}