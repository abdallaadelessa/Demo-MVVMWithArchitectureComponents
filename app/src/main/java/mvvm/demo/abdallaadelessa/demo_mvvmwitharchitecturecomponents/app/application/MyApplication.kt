package mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.app.application

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.BuildConfig
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.app.di.*
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.app.di.AppModule
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.app.di.NetModule
import timber.log.Timber
import javax.inject.Inject
import timber.log.Timber.DebugTree



class MyApplication : Application() , HasActivityInjector {
    @Inject
    lateinit var dispatchingActivityInjector : DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        setup()
    }

    private fun setup() {
        if (BuildConfig.DEBUG) Timber.plant(DebugTree())
        InitDagger()
    }

    private fun InitDagger() {
        appComponent = DaggerAppComponent.builder()
                .application(this)
                .appModule(AppModule(this))
                .netModule(NetModule("https://www.kayak.com/h/mobileapis/directory/"))
                .build()
        appComponent.inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> = dispatchingActivityInjector

    companion object {
         lateinit var appComponent: AppComponent private set
    }
}