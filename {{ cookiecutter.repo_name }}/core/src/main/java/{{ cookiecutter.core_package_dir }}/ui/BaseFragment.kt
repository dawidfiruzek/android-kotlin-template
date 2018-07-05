package {{ cookiecutter.core_package_name }}.ui

import android.content.Context
import android.support.annotation.CallSuper
import android.support.v4.app.Fragment
import dagger.android.support.AndroidSupportInjection

abstract class BaseFragment : Fragment() {

    // how to handle navigation in fragments in case of need
    // 1. create listener property
//    private lateinit var navigationListener: NavigationListener

    @CallSuper
    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
//        2. Set listener in onAttach method from Activity and implement NavigationListener there
//        activity?.let {
//            navigationListener = it as NavigationListener
//        }
    }

//    3. call listener's method in case of navigation
//    fun handleNavigation(event: HomeNavigation) {
//        navigationListener.handleEvent(event)
//    }
}

interface NavigationEvent

interface NavigationListener {
    fun handleEvent(event: NavigationEvent)
}

// e.g. navigation events specific to home
// enum class HomeNavigation : NavigationEvent {
//    PAY_CLICKED
//}