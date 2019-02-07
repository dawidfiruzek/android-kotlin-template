package {{ cookiecutter.core_package_name }}.ui

import android.arch.lifecycle.ViewModel
import android.databinding.ViewDataBinding
import android.support.v4.app.Fragment
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

abstract class BaseFragmentActivity<VM : ViewModel, DB: ViewDataBinding> : BaseActivity<VM, DB>(), HasSupportFragmentInjector {

    @Inject lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector(): AndroidInjector<Fragment> =
            fragmentInjector
}