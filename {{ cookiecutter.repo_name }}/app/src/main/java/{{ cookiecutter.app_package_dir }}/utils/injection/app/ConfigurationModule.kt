package {{ cookiecutter.core_package_name }}.utils.injection.app

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import dagger.Module
import dagger.Provides
import {{ cookiecutter.core_package_name }}.utils.configuration.Configuration
import {{ cookiecutter.core_package_name }}.utils.configuration.ConfigurationImpl

@Module
class ConfigurationModule {

    @Provides
    fun sharedPreferences(context: Context): SharedPreferences =
            PreferenceManager.getDefaultSharedPreferences(context)

    @Provides
    fun configuration(sharedPreferences: SharedPreferences): Configuration =
            ConfigurationImpl(sharedPreferences)
}