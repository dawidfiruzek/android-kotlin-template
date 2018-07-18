package {{ cookiecutter.app_package_name }}.utils.injection

import android.app.Activity
import android.app.Application
import android.content.Context
import android.support.v4.app.Fragment
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjectionModule
import io.reactivex.disposables.CompositeDisposable
import {{ cookiecutter.app_package_name }}.BaseApplication
import {{ cookiecutter.core_package_name }}.utils.injection.ConfigurationModule
import {{ cookiecutter.core_package_name }}.utils.injection.ResourcesModule
import {{ cookiecutter.core_package_name }}.utils.injection.DomainModule
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

@Module
abstract class BindingModule {

    @Binds
    abstract fun activity(activity: Activity): Activity

    @Binds
    abstract fun fragment(fragment: Fragment): Fragment
}