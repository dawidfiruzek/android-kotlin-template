package {{ cookiecutter.core_package_name }}.domain

import io.reactivex.Single

interface SingleUseCase<in Params, Return> : UseCase {

    fun build(params: Params? = null): Single<Return>
}