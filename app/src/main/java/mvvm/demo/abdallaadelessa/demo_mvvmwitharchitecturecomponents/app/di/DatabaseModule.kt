package mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.app.di

import android.content.Context
import dagger.Module
import dagger.Provides
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.app.AppDatabase
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.app.MyApplication
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import javax.inject.Singleton

@Module
class DatabaseModule()
{
    @Singleton
    @Provides
    fun providesAppDatabase(context: Context): AppDatabase {
        return AppDatabase.getInstance(context)
    }

}