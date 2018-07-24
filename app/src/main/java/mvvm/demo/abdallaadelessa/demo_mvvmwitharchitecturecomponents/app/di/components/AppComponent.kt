package mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.app.di.components

import android.content.Context
import dagger.Component
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.app.di.modules.AppModule
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.app.di.modules.DatabaseModule
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.app.di.modules.NetModule
import java.util.concurrent.ExecutorService
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class, DatabaseModule::class, NetModule::class))
interface AppComponent
{
    fun getAppContext(): Context
    fun getAppExecutorService(): ExecutorService
    fun AirlineUsecaseBuilder(): AirlineUsecaseComponent.Builder
}