package {{ cookiecutter.core_package_name }}.utils.injection

import dagger.Binds
import dagger.Module
import {{ cookiecutter.core_package_name }}.navigation.Navigator
import {{ cookiecutter.core_package_name }}.navigation.NavigatorImpl

@Module
abstract class NavigationModule {

    @Binds
    abstract fun navigation(navigator: NavigatorImpl): Navigator
}