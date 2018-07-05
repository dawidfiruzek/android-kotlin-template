package {{ cookiecutter.core_package_name }}.domain

import io.reactivex.Flowable

interface FlowableUseCase<in Params, Return> : UseCase {

    fun build(params: Params? = null): Flowable<Return>
}