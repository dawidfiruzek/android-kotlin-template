package {{ cookiecutter.core_package_name }}.domain

import io.reactivex.Completable

interface CompletableUseCase<Params> {

    fun build(params: Params? = null): Completable
}