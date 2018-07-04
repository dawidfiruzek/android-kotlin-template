package {{ cookiecutter.core_package_dir }}.utils.resources

interface ResourceProvider {

    fun getString(val stringId: Int): String
}