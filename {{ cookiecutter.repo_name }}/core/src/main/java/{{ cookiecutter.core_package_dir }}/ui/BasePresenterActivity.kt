package {{ cookiecutter.core_package_name }}.ui

import {{ cookiecutter.core_package_name }}.BaseContract
import javax.inject.Inject

abstract class BasePresenterActivity<Presenter : BaseContract.Presenter> : BaseActivity() {

    @Inject lateinit var presenter: Presenter

    override fun onStart() {
        super.onStart()
        presenter.initialize()
    }

    override fun onStop() {
        super.onStop()
        presenter.clear()
    }
}