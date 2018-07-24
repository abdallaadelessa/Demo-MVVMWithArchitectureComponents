package mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.presentation.listairlines

import android.arch.lifecycle.ViewModel
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.model.AirlineModel
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.domain.airline.useCase.AirlineUseCase
import android.arch.lifecycle.MutableLiveData
import io.reactivex.disposables.CompositeDisposable
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.domain.common.model.DataResult
import android.arch.lifecycle.LiveData
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.app.application.MyApplication
import javax.inject.Inject


class ListAirlineViewModel @Inject constructor(val airlineUseCase: AirlineUseCase): ViewModel() {
    private val disposables = CompositeDisposable()

    init {
        loadAirlines()
    }

    //region Public

    private val airlines: MutableLiveData<List<AirlineModel>> = MutableLiveData()
    fun getAirLines(): LiveData<List<AirlineModel>> {
        return airlines
    }

    private val errorMessage: MutableLiveData<String> = MutableLiveData()
    fun getErrorMessage(): LiveData<String> {
        return errorMessage
    }

    override fun onCleared() {
        disposables.clear()
    }

    //endregion

    //region Private

    private fun loadAirlines() {
        disposables.add(airlineUseCase.listAirlines().subscribe(
                { dataResult ->
                    when (dataResult) {
                        is DataResult.Success -> airlines.value = dataResult.result
                        is DataResult.Error -> errorMessage.value = dataResult.throwable.message
                    }
                },
                { throwable ->
                    errorMessage.value = throwable.message
                }))
    }

    //endregion
}