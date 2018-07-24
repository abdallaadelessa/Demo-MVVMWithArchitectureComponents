package mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.presentation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.R
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.app.MyApplication
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.repo.local.AirlineLocalRepo
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.domain.airline.AirlineUseCase
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

        @Inject
        lateinit var airlineUseCase : AirlineUseCase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MyApplication.airlineUsecaseComponent.inject(this)

        airlineUseCase.listAirlines().subscribe({
            it?.let {
                Log.d("DebugTag",it.toString())
            }
        },{
            it?.let {
            Log.d("DebugTag",it.toString())
        }})
    }
}
