package {{ cookiecutter.core_package_name }}.utils.resources

interface ResourceProvider {

    fun getString(val stringId: Int): String
}