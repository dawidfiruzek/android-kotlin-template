package {{ cookiecutter.core_package_name }}

interface BaseContract {

    interface Presenter {
        fun initialize()
        fun clear()
    }
}