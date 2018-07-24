package mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.app.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.app.AppDatabase
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.app.MyApplication
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import javax.inject.Singleton


@Module
class AppModule(val app : MyApplication)
{
    @Singleton
    @Provides
    fun provideAppContext(): Context = app.applicationContext

    @Singleton
    @Provides
    fun provideAppExecutorService(): ExecutorService {
        return Executors.newFixedThreadPool(10)
    }
}