package {{ cookiecutter.core_package_name }}.utils.injection.app

import android.app.Activity
import android.support.v4.app.Fragment
import dagger.Binds
import dagger.Module

@Module
abstract class BindingModule {

    @Binds
    abstract fun activity(activity: Activity): Activity

    @Binds
    abstract fun fragment(fragment: Fragment): Fragment
}