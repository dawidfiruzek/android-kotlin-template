package {{ cookiecutter.core_package_name }}.ui

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.annotation.CallSuper

import javax.inject.Inject
import android.arch.lifecycle.ViewModel

abstract class BaseViewModelActivity<VM : ViewModel> : BaseActivity() {

    @Inject lateinit var viewModelFactory: ViewModelFactory<VM>
    protected lateinit var viewModel: VM
    protected abstract viewModelClassToken: Class<VM>

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(viewModelClassToken)
    }
}