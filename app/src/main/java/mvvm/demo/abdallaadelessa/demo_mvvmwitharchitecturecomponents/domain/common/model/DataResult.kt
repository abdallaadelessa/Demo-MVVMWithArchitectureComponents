package mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.domain.common.model

sealed class DataResult<E>(val source: DataSource) {
    class Success<E>(source: DataSource, val result: E) : DataResult<E>(source) {
        val isEmpty : Boolean
        get(){ if(result is List<*>) return result.isEmpty() else return result == null }
    }

    class Error<E>(source: DataSource, val throwable: Throwable) : DataResult<E>(source) {
    }
}
enum class DataSource { Network, Local }