package {{ cookiecutter.core_package_name }}.utils.injection.app

import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import pl.dawidfiruzek.core.domain.UseCaseExecutor
import javax.inject.Named

@Module
class DomainModule {

    companion object {
        const val UI = "ui"
        const val IO = "io"
        const val COMPUTATION = "computation"
        const val NEW_THREAD = "new thread"
    }

    @Provides
    @Named(UI)
    fun uiScheduler(): Scheduler =
            AndroidSchedulers.mainThread()

    @Provides
    @Named(IO)
    fun ioScheduler(): Scheduler =
            Schedulers.io()

    @Provides
    @Named(COMPUTATION)
    fun computationScheduler(): Scheduler =
            Schedulers.computation()

    @Provides
    @Named(NEW_THREAD)
    fun newThreadScheduler(): Scheduler =
            Schedulers.newThread()

    @Provides
    @Named(UI)
    fun uiExecutor(
            @Named(UI) subscribrOnScheduler: Scheduler,
            @Named(UI) observeOnScheduler: Scheduler
    ): UseCaseExecutor =
            UseCaseExecutor(
                    subscribrOnScheduler,
                    observeOnScheduler
            )

    @Provides
    @Named(IO)
    fun ioExecutor(
            @Named(IO) subscribrOnScheduler: Scheduler,
            @Named(UI) observeOnScheduler: Scheduler
    ): UseCaseExecutor =
            UseCaseExecutor(
                    subscribrOnScheduler,
                    observeOnScheduler
            )

    @Provides
    @Named(COMPUTATION)
    fun computationExecutor(
            @Named(COMPUTATION) subscribrOnScheduler: Scheduler,
            @Named(UI) observeOnScheduler: Scheduler
    ): UseCaseExecutor =
            UseCaseExecutor(
                    subscribrOnScheduler,
                    observeOnScheduler
            )

    @Provides
    @Named(NEW_THREAD)
    fun newThreadExecutor(
            @Named(NEW_THREAD) subscribrOnScheduler: Scheduler,
            @Named(UI) observeOnScheduler: Scheduler
    ): UseCaseExecutor =
            UseCaseExecutor(
                    subscribrOnScheduler,
                    observeOnScheduler
            )
}