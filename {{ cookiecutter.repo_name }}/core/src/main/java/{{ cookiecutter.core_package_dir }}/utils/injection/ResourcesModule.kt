package {{ cookiecutter.core_package_name }}.utils.injection

import {{ cookiecutter.core_package_name }}.utils.resources.ResourceProvider
import {{ cookiecutter.core_package_name }}.utils.resources.ResourceProviderImpl
import dagger.Binds
import dagger.Module

@Module
abstract class ResourcesModule {

    @Binds
    abstract fun resourceProvider(impl: ResourceProviderImpl): ResourceProvider
}