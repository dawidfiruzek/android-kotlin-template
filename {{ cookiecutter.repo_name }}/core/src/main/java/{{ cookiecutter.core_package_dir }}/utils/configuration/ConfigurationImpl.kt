package {{ cookiecutter.core_package_name }}.utils.configuration

import android.content.SharedPreferences

class ConfigurationImpl(
        private val sharedPreferences: SharedPreferences
) : Configuration