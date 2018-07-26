package mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.presentation.listairlines

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.model.AirlineModel
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.domain.airline.useCase.AirlineUseCase
import android.arch.lifecycle.MutableLiveData
import io.reactivex.disposables.CompositeDisposable
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.domain.common.model.DataResult
import android.arch.lifecycle.LiveData
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.app.application.MyApplication
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.presentation.common.model.ViewState
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.R
import javax.inject.Inject


class ListAirlineViewModel @Inject constructor(application: Application,private val airlineUseCase: AirlineUseCase): AndroidViewModel(application) {
    private val disposables = CompositeDisposable()
    private val viewState: MutableLiveData<ViewState<List<AirlineModel>>> = MutableLiveData()
    private val app : Application = getApplication<MyApplication>()

    init {
        loadAirlines()
    }

    //region Public

    fun getViewStatus(): LiveData<ViewState<List<AirlineModel>>> {
        return viewState
    }

    override fun onCleared() {
        disposables.clear()
    }

    //endregion

    //region Private

    private fun loadAirlines() {
        viewState.postValue(ViewState.Loading())
        disposables.add(airlineUseCase.listAirlines().subscribe { dataResult ->
            when (dataResult) {
                is DataResult.Success -> {
                    if(dataResult.isEmpty){
                        viewState.postValue(ViewState.Error(app.getString(R.string.placeholder_empty)))
                    }else{
                        viewState.postValue(ViewState.Success(dataResult.result))
                    }
                }
                is DataResult.Error -> {
                    viewState.postValue(ViewState.Error(dataResult.throwable.message))
                }
            }
        })
    }

    //endregion
}