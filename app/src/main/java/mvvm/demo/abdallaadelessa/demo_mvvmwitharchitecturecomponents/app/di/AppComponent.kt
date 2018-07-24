package mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.app.di

import android.content.Context
import dagger.Component
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.presentation.listairlines.ListAirlinesActivity
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.domain.airline.di.AirlineUseCaseModule
import java.util.concurrent.ExecutorService
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        AppModule::class,
        DatabaseModule::class,
        NetModule::class,
        ViewModelModule::class,
        AirlineUseCaseModule::class))
interface AppComponent
{
    fun getAppContext(): Context
    fun getAppExecutorService(): ExecutorService
    fun inject(activity: ListAirlinesActivity)
}