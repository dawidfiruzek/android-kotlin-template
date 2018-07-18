package {{ cookiecutter.core_package_name }}.utils.injection

import android.content.Context
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Named

@Module
class DomainModule {

    companion object {
        const val UI_SCHEDULER = "ui scheduler"
        const val IO_SCHEDULER = "io scheduler"
        const val COMPUTATION_SCHEDULER = "computation scheduler"
        const val NEW_THREAD_SCHEDULER = "new thread scheduler"
    }

    @Provides
    @Named(UI_SCHEDULER)
    fun uiScheduler(): Scheduler =
            AndroidSchedulers.mainThread()

    @Provides
    @Named(IO_SCHEDULER)
    fun ioScheduler(): Scheduler =
            Schedulers.io()

    @Provides
    @Named(COMPUTATION_SCHEDULER)
    fun computationScheduler(): Scheduler =
            Schedulers.computation()

    @Provides
    @Named(NEW_THREAD_SCHEDULER)
    fun newThreadScheduler(): Scheduler =
            Schedulers.newThread()
}