package {{ cookiecutter.app_package_name }}.utils.injection

import android.app.Application
import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjectionModule
import io.reactivex.disposables.CompositeDisposable
import {{ cookiecutter.app_package_name }}.BaseApplication
import {{ cookiecutter.app_package_name }}.utils.injection.NetworkModule
import {{ cookiecutter.core_package_name }}.utils.injection.ConfigurationModule
import {{ cookiecutter.core_package_name }}.utils.injection.ResourcesModule
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    fun context(app: Application): Context =
            app

    @Provides
    fun compositeDisposable(): CompositeDisposable =
            CompositeDisposable()
}

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    AppModule::class,
    NetworkModule::class,
    ConfigurationModule::class,
    ResourcesModule::class
])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun bindApplication(app: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: BaseApplication)
}