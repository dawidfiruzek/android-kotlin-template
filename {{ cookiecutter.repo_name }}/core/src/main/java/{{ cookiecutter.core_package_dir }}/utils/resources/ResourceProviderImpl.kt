package {{ cookiecutter.core_package_name }}.utils.resources

import android.content.Context
import javax.inject.Inject

class ResourceProviderImpl @Inject constructor(
        private val context: Context
) : ResourceProvider {

    override fun getString(stringId: Int): String =
            context.getString(stringId)
}