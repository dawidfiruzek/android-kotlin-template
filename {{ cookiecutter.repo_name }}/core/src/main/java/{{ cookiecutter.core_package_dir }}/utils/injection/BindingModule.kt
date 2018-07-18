package {{ cookiecutter.core_package_name }}.utils.injection

import android.app.Activity
import android.support.v4.app.Fragment

@Module
abstract class BindingModule {

    @Binds
    abstract fun activity(activity: Activity): Activity

    @Binds
    abstract fun fragment(fragment: Fragment): Fragment
}