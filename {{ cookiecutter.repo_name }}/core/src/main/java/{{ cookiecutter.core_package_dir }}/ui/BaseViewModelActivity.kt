package {{ cookiecutter.core_package_name }}.ui

import android.arch.lifecycle.ViewModelProviders
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.CallSuper
import pl.dawidfiruzek.core.utils.ViewModelFactory
import javax.inject.Inject
import android.arch.lifecycle.ViewModel

abstract class BaseViewModelActivity<VM : ViewModel, DB: ViewDataBinding> : BaseActivity() {

    @Inject lateinit var viewModelFactory: ViewModelFactory<VM>
    protected lateinit var viewModel: VM
    protected lateinit var dataBinding: DB
    protected abstract val viewModelClassToken: Class<VM>

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(viewModelClassToken)
        dataBinding = DB.inflate(getLayoutInflater(), container, attachToContainer);
        dataBinding.setLifecycleOwner(this)
    }
}