package {{ cookiecutter.core_package_name }}.utils.configuration

object StringConstants {
    const val BASE_URL = "base url"
    {% if cookiecutter.amplitude_lib == "y" %}const val AMPLITUDE_KEY = "amplitude key"{% endif %}
}