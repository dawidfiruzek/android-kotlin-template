package {{ cookiecutter.core_package_name }}.domain

import io.reactivex.schedulers.TestScheduler

class TestUseCaseExecutor(
        private val scheduler: TestScheduler = TestScheduler(),
        private val internalExecutor: UseCaseExecutor = UseCaseExecutorImpl(
                scheduler,
                scheduler
        )
) : UseCaseExecutor by internalExecutor {

    fun triggerActions() {
        scheduler.triggerActions()
    }
}