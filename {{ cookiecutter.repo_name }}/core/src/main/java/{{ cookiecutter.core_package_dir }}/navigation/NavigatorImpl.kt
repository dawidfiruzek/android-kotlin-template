package {{ cookiecutter.core_package_name }}.navigation

import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.Subject
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NavigatorImpl @Inject constructor() : Navigator {

    private val subject: Subject<NavigationEvent> = PublishSubject.create()

    override fun navigateTo(event: NavigationEvent) {
        subject.onNext(event)
    }

    override fun <T : NavigationEvent> getNavigation(eventType: Class<T>): Flowable<NavigationEvent> =
            subject.toFlowable(BackpressureStrategy.MISSING)
                    .filter { it -> it::class.java.simpleName == eventType.simpleName }
}