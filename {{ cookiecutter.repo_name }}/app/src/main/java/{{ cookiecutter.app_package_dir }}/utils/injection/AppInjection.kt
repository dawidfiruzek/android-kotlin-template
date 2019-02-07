package {{ cookiecutter.app_package_name }}.utils.injection

import android.app.Activity
import android.app.Application
import android.content.Context
import android.support.v4.app.Fragment
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.android.AndroidInjectionModule
import {{ cookiecutter.app_package_name }}.BaseApplication
import {{ cookiecutter.app_package_name }}.utils.injection.NetworkModule
import {{ cookiecutter.core_package_name }}.utils.injection.ConfigurationModule
import {{ cookiecutter.core_package_name }}.utils.injection.ResourcesModule
import {{ cookiecutter.core_package_name }}.utils.injection.DomainModule
import {{ cookiecutter.core_package_name }}.utils.injection.NavigationModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    AppModule::class,
    ActivityBindings::class,
    NetworkModule::class,
    ConfigurationModule::class,
    ResourcesModule::class,
    DomainModule::class,
    NavigationModule::class
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

@Module
abstract class AppModule {

    @Binds
    abstract fun context(app: Application): Context

    @Binds
    abstract fun activity(activity: Activity): Activity

    @Binds
    abstract fun fragment(fragment: Fragment): Fragment
}

@Module
abstract class ActivityBindings {

    /*
    todo add activities bindings here e.g.
    @ContributesAndroidInjector
    abstract fun splash(): SplashActivity
     */
}
