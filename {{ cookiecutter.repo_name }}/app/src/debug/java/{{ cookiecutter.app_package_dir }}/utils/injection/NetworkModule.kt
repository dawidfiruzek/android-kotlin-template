package {{ cookiecutter.app_package_name }}.utils.injection

import android.content.Context
import com.facebook.stetho.okhttp3.StethoInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import javax.inject.Named
import javax.inject.Singleton
import {{ cookiecutter.core_package_name }}.utils.injection.BaseNetworkModule

@Module
class NetworkModule : BaseNetworkModule() {

    @Provides
    fun stethoInterceptor(): Interceptor =
            StethoInterceptor()

    @Singleton
    @Provides
    fun okHttpClient(stethoInterceptor: Interceptor): OkHttpClient =
            OkHttpClient.Builder()
                    .addNetworkInterceptor(chuckInterceptor)
                    .addNetworkInterceptor(stethoInterceptor)
                    .build()
}