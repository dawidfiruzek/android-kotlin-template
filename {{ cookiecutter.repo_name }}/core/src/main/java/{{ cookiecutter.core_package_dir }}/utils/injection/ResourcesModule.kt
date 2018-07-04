package {{ cookiecutter.core_package_name }}.utils.injection

import android.content.Context
import {{ cookiecutter.core_package_name }}.utils.resources.ResourceProvider
import {{ cookiecutter.core_package_name }}.utils.resources.ResourceProviderImpl
import dagger.Module
import dagger.Provides

@Module
class ResourcesModule {

    @Provides
    fun resourceProvider(context: Context): ResourceProvider =
            ResourceProviderImpl(context)
}