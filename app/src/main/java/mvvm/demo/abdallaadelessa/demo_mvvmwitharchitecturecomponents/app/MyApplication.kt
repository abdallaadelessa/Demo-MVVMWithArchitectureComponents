package mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.app

import android.app.Application
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.app.di.*
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.di.AirlineDataModule
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.domain.di.AirlineUseCaseModule
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.presentation.AirlineUsecaseComponent

class MyApplication : Application() {
    private lateinit var appComponent: AppComponent private set
    private lateinit var airlineUsecaseComponent: AirlineUsecaseComponent private set

    override fun onCreate() {
        super.onCreate()
        setup()
    }

    private fun setup() {
        Instance = this

        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(Instance))
                .netModule(NetModule("https://www.kayak.com/h/mobileapis/directory/"))
                .build()

        airlineUsecaseComponent = appComponent.AirlineUsecaseBuilder()
                .airlineDataModule(AirlineDataModule())
                .airlineUseCaseModule(AirlineUseCaseModule())
                .build()
    }

    fun getAppComponent() : AppComponent = appComponent

    fun getAirlineUsecaseComponent() : AirlineUsecaseComponent = airlineUsecaseComponent

    companion object {
        lateinit var Instance: MyApplication
           private set
    }
}