package mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.app

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.model.AirlineEntity
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.repo.local.AirlineEntityDao

@Database(entities = [(AirlineEntity::class)], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun airlineEntityDao(): AirlineEntityDao
    companion object {
        /**
         * The only instance
         */
        private var sInstance: AppDatabase? = null

        /**
         * Gets the singleton instance of SampleDatabase.
         *
         * @param context The context.
         * @return The singleton instance of SampleDatabase.
         */
        @Synchronized
        fun getInstance(context: Context): AppDatabase {
            if (sInstance == null) {
                sInstance = Room
                        .databaseBuilder(context.applicationContext, AppDatabase::class.java, "AppDatabase")
                        .fallbackToDestructiveMigration()
                        .build()
            }
            return sInstance!!
        }
    }
}