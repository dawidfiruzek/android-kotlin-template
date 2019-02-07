package {{ cookiecutter.core_package_name }}.domain

import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Action
import io.reactivex.functions.Consumer
import org.reactivestreams.Subscription

interface UseCaseExecutor {

    fun execute(
            completable: Completable,
            onComplete: Action,
            onError: Consumer<Throwable>)

    fun <Return> execute(
            single: Single<Return>,
            onSuccess: Consumer<Return>,
            onError: Consumer<Throwable>)

    fun <Return> execute(
            observable: Observable<Return>,
            onSuccess: Consumer<Return>,
            onError: Consumer<Throwable>,
            onComplete: Action? = null,
            onSubscribe: Consumer<Disposable>? = null)

    fun <Return> execute(
            flowable: Flowable<Return>,
            onSuccess: Consumer<Return>,
            onError: Consumer<Throwable>,
            onComplete: Action? = null,
            onSubscribe: Consumer<Subscription>? = null)

    fun clear()
}