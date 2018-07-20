package {{ cookiecutter.core_package_name }}.domain

import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Action
import io.reactivex.functions.Consumer
import org.reactivestreams.Subscription

class UseCaseExecutor(
        private val subscribeOnScheduler: Scheduler,
        private val observeOnScheduler: Scheduler
) {

    private val compositeDisposable = CompositeDisposable()

    fun execute(
            completable: Completable,
            onComplete: Action,
            onError: Consumer<Throwable>) {
        compositeDisposable.add(
                completable
                        .subscribeOn(subscribeOnScheduler)
                        .observeOn(observeOnScheduler)
                        .subscribe(onComplete, onError)
        )
    }

    fun <Return> execute(
            single: Single<Return>,
            onSuccess: Consumer<Return>,
            onError: Consumer<Throwable>) {
        compositeDisposable.add(
                single
                        .subscribeOn(subscribeOnScheduler)
                        .observeOn(observeOnScheduler)
                        .subscribe(onSuccess, onError)
        )
    }

    fun <Return> execute(
            observable: Observable<Return>,
            onSuccess: Consumer<Return>,
            onError: Consumer<Throwable>,
            onComplete: Action? = null,
            onSubscribe: Consumer<Disposable>? = null) {
        var o = observable
        onComplete?.let { o = o.doOnComplete(it) }
        onSubscribe?.let { o = o.doOnSubscribe(it) }

        compositeDisposable.add(
                o.subscribeOn(subscribeOnScheduler)
                        .observeOn(observeOnScheduler)
                        .subscribe(onSuccess, onError)
        )
    }

    fun <Return> execute(
            flowable: Flowable<Return>,
            onSuccess: Consumer<Return>,
            onError: Consumer<Throwable>,
            onComplete: Action? = null,
            onSubscribe: Consumer<Subscription>? = null) {
        var f = flowable
        onComplete?.let { f = f.doOnComplete(it) }
        onSubscribe?.let { f = f.doOnSubscribe(it) }

        compositeDisposable.add(
                f.subscribeOn(subscribeOnScheduler)
                        .observeOn(observeOnScheduler)
                        .subscribe(onSuccess, onError)
        )
    }

    fun clear() {
        compositeDisposable.clear()
    }
}