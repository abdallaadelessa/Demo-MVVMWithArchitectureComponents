package mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.presentation.common.model

sealed class ViewState<E>{
    class Success<E>(val data:E) : ViewState<E>()
    class Loading<E>() : ViewState<E>()
    class Error<E>(val message:String?): ViewState<E>()
}