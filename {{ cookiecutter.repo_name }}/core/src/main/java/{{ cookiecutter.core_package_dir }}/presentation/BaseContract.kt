package {{ cookiecutter.core_package_name }}.presentation

interface BaseContract {

    interface Presenter {
        fun initialize()
        fun clear()
    }
}