package {{ cookiecutter.core_package_name }}.ui

import android.content.Intent
import android.os.Parcelable
import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import {{ cookiecutter.core_package_name }}.BaseContract
import javax.inject.Inject

abstract class BaseActivity<Presenter : BaseContract.Presenter> : AppCompatActivity(), HasSupportFragmentInjector {

    @Inject lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>
    @Inject lateinit var presenter: Presenter

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        presenter.initialize()
    }

    override fun onStop() {
        super.onStop()
        presenter.clear()
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> =
            fragmentInjector

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