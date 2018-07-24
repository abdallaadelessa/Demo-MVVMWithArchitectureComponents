package mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.app

import android.app.Application
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.app.di.*
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.di.AirlineLocalDataModule
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.di.AirlineRemoteDataModule
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.domain.di.AirlineUseCaseModule
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.presentation.AirlineUsecaseComponent

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        setup()
    }

    private fun setup() {
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .netModule(NetModule("https://www.kayak.com/h/mobileapis/directory/"))
                .build()

        airlineUsecaseComponent = appComponent.AirlineUsecaseBuilder().build()
    }

    companion object {
         lateinit var appComponent: AppComponent private set
         lateinit var airlineUsecaseComponent: AirlineUsecaseComponent private set
    }
}