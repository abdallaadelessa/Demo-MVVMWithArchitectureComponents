package mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.app.di

import android.content.Context
import dagger.Module
import dagger.Provides
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.app.database.AppDatabase
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