package {{ cookiecutter.app_package_name }}.utils.injection.app

import android.app.Application
import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjectionModule
import {{ cookiecutter.app_package_name }}.BaseApplication
import {{ cookiecutter.app_package_name }}.utils.injection.NetworkModule
import {{ cookiecutter.core_package_name }}.utils.injection.ConfigurationModule
import {{ cookiecutter.core_package_name }}.utils.injection.ResourcesModule
import {{ cookiecutter.core_package_name }}.utils.injection.DomainModule
import {{ cookiecutter.core_package_name }}.utils.injection.BindingModule
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    fun context(app: Application): Context =
            app
}

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    AppModule::class,
    NetworkModule::class,
    ConfigurationModule::class,
    ResourcesModule::class,
    DomainModule::class,
    BindingModule::class
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
