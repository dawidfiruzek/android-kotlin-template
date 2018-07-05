package {{ cookiecutter.app_package_name }}.utils.injection

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import javax.inject.Singleton
import {{ cookiecutter.core_package_name }}.utils.injection.BaseNetworkModule

@Module
class NetworkModule : BaseNetworkModule() {

    @Singleton
    @Provides
    fun okHttpClient(): OkHttpClient =
            OkHttpClient()
}
