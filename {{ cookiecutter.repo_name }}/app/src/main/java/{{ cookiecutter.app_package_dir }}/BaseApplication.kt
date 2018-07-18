package {{ cookiecutter.app_package_name }}

import android.app.Activity
import android.app.Application
{% if cookiecutter.amplitude_lib == "y" %}import com.amplitude.api.Amplitude{% endif %}
import com.crashlytics.android.Crashlytics
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import io.fabric.sdk.android.Fabric
import {{ cookiecutter.app_package_name }}.utils.injection.DaggerAppComponent
{% if cookiecutter.amplitude_lib == "y" %}import {{ cookiecutter.core_package_name }}.utils.configuration.StringConstants{% endif %}
import javax.inject.Inject

abstract class BaseApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        Fabric.with(this, Crashlytics())
        {% if cookiecutter.amplitude_lib == "y" %}Amplitude.getInstance().initialize(this, StringConstants.AMPLITUDE_KEY){% endif %}
        initTimber()
        initDaggerComponent()
    }

    abstract fun initTimber()

    private fun initDaggerComponent() {
        DaggerAppComponent.builder()
                .bindApplication(this)
                .build()
                .inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> =
            activityInjector
}