package mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.domain.common.model

sealed class DataResult<E>{
    sealed class Success<E> (val result : E) : DataResult<E>() {
        class Network<E>(result : E): Success<E>(result)
        class Local<E>(result : E): Success<E>(result)
    }
    sealed class Error<E> (val throwable : Throwable): DataResult<E>(){
        class Network<E>(throwable : Throwable): Error<E>(throwable)
        class Local<E>(throwable : Throwable): Error<E>(throwable)
    }
}