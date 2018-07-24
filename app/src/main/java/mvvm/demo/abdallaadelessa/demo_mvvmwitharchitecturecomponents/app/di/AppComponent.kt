package mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.app.di

import android.content.Context
import dagger.Component
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.domain.airline.di.AirlineUseCaseComponent
import java.util.concurrent.ExecutorService
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class, DatabaseModule::class, NetModule::class))
interface AppComponent
{
    fun inject(context: Context)
    fun getAppContext(): Context
    fun getAppExecutorService(): ExecutorService
    fun AirlineUseCaseBuilder(): AirlineUseCaseComponent.Builder
}