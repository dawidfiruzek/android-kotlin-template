package {{ cookiecutter.core_package_name }}.domain

import io.reactivex.Single

interface SingleUseCase<Params, Return> {

    fun build(params: Params? = null): Single<Return>
}