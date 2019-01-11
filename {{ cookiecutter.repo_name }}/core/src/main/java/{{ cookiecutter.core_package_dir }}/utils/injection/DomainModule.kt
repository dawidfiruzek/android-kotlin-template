package {{ cookiecutter.core_package_name }}.utils.injection

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
        const val UI_EXECUTION = "{{ cookiecutter.core_package_name }}.schedulers.ui"
        const val IO_EXECUTION = "{{ cookiecutter.core_package_name }}.schedulers.io"
        const val COMPUTATION_EXECUTION = "{{ cookiecutter.core_package_name }}.schedulers.computation"
        const val NEW_THREAD_EXECUTION = "{{ cookiecutter.core_package_name }}.schedulers.new thread"
    }

    @Provides
    @Named(UI_EXECUTION)
    fun uiScheduler(): Scheduler =
            AndroidSchedulers.mainThread()

    @Provides
    @Named(IO_EXECUTION)
    fun ioScheduler(): Scheduler =
            Schedulers.io()

    @Provides
    @Named(COMPUTATION_EXECUTION)
    fun computationScheduler(): Scheduler =
            Schedulers.computation()

    @Provides
    @Named(NEW_THREAD_EXECUTION)
    fun newThreadScheduler(): Scheduler =
            Schedulers.newThread()

    @Provides
    @Named(UI_EXECUTION)
    fun uiExecutor(
            @Named(UI_EXECUTION) subscribrOnScheduler: Scheduler,
            @Named(UI_EXECUTION) observeOnScheduler: Scheduler
    ): UseCaseExecutor =
            UseCaseExecutor(
                    subscribrOnScheduler,
                    observeOnScheduler
            )

    @Provides
    @Named(IO_EXECUTION)
    fun ioExecutor(
            @Named(IO_EXECUTION) subscribrOnScheduler: Scheduler,
            @Named(UI_EXECUTION) observeOnScheduler: Scheduler
    ): UseCaseExecutor =
            UseCaseExecutor(
                    subscribrOnScheduler,
                    observeOnScheduler
            )

    @Provides
    @Named(COMPUTATION_EXECUTION)
    fun computationExecutor(
            @Named(COMPUTATION_EXECUTION) subscribrOnScheduler: Scheduler,
            @Named(UI_EXECUTION) observeOnScheduler: Scheduler
    ): UseCaseExecutor =
            UseCaseExecutor(
                    subscribrOnScheduler,
                    observeOnScheduler
            )

    @Provides
    @Named(NEW_THREAD_EXECUTION)
    fun newThreadExecutor(
            @Named(NEW_THREAD_EXECUTION) subscribrOnScheduler: Scheduler,
            @Named(UI_EXECUTION) observeOnScheduler: Scheduler
    ): UseCaseExecutor =
            UseCaseExecutor(
                    subscribrOnScheduler,
                    observeOnScheduler
            )
}