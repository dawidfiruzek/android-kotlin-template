package {{ cookiecutter.package_name }}

import timber.log.Timber


class Application : BaseApplication() {

    override fun initTimber() {
        Timber.plant(ReleaseTree())
    }
}