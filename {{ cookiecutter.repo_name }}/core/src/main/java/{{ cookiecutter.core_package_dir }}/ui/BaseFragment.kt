package {{ cookiecutter.core_package_name }}.ui

import android.content.Context
import android.support.annotation.CallSuper
import android.support.v4.app.Fragment
import dagger.android.support.AndroidSupportInjection
import {{ cookiecutter.core_package_name }}.BaseContract
import javax.inject.Inject

abstract class BaseFragment<Presenter : BaseContract.Presenter> : Fragment() {

    @Inject lateinit var presenter: Presenter

    @CallSuper
    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onStart() {
        super.onStart()
        presenter.initialize()
    }

    override fun onStop() {
        super.onStop()
        presenter.clear()
    }
}
