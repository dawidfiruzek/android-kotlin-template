package {{ cookiecutter.core_package_name }}.ui

import android.content.Context
import android.support.annotation.CallSuper
import android.support.v4.app.Fragment
import dagger.android.support.AndroidSupportInjection

abstract class BaseFragment : Fragment() {

    @CallSuper
    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }
}

interface NavigationEvent

interface NavigationListener {
    fun handleEvent(event: NavigationEvent)
}