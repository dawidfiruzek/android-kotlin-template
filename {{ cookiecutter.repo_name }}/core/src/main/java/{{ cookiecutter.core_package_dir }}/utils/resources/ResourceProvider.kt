package {{ cookiecutter.core_package_name }}.utils.resources

interface ResourceProvider {

    fun getString(stringId: Int): String
}