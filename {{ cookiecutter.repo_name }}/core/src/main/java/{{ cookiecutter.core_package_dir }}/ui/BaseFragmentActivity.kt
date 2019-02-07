package {{ cookiecutter.core_package_name }}.ui

import android.support.v4.app.Fragment
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import {{ cookiecutter.core_package_name }}.presentation.BaseContract
import javax.inject.Inject

abstract class BaseFragmentActivity<Presenter : BaseContract.Presenter> : BaseActivity<Presenter>(), HasSupportFragmentInjector {

    @Inject lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector(): AndroidInjector<Fragment> =
            fragmentInjector
}