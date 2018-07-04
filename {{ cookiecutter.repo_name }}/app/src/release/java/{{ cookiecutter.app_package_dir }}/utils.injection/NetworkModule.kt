package {{ cookiecutter.app_package_name }}.utils.injection

import android.content.Context
import com.facebook.stetho.okhttp3.StethoInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import javax.inject.Named
import javax.inject.Singleton
import {{ cookiecutter.core_package_dir }}.utils.injection.BaseNetworkModule

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
class NetworkModule : BaseNetworkModule() {

    @Singleton
    @Provides
    fun okHttpClient(): OkHttpClient =
            OkHttpClient()
