package mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.app.di

import android.content.Context
import dagger.Module
import dagger.Provides
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.app.application.MyApplication
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