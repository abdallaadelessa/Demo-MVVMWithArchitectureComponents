package mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.app.application

import android.app.Application
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.app.di.AppComponent
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.app.di.AppModule
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.app.di.DaggerAppComponent
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.app.di.NetModule

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
    }

    companion object {
         lateinit var appComponent: AppComponent private set
    }
}