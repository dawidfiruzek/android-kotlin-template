package {{ cookiecutter.core_package_name }}.domain

import io.reactivex.Flowable

interface FlowableUseCase<Params, Return> {

    fun build(params: Params? = null): Flowable<Return>
}