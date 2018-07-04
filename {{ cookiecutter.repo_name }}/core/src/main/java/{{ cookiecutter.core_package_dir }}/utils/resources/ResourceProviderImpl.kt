package {{ cookiecutter.core_package_dir }}.utils.resources

import android.content.Context

class ResourceProviderImpl(
        private val context: Context
) : ResourceProvider {

    override fun getString(val stringId: Int): String =
            context.getString(stringId)
}