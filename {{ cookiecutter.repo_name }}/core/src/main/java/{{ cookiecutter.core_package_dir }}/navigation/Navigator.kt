package {{ cookiecutter.core_package_name }}.navigation

import io.reactivex.Flowable

interface Navigator {

    fun navigateTo(event: NavigationEvent)

    fun <T : NavigationEvent> getNavigation (eventType: Class<T>): Flowable<NavigationEvent>
}

interface NavigationEvent
