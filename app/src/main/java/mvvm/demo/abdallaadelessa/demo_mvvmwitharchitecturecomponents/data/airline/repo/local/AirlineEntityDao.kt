package mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.repo.local

import android.arch.persistence.room.*
import android.content.Context
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single

@Entity(tableName = "AirlineEntity")
public class AirlineEntity( site : String?,
                            defaultName : String?,
                            logoURL : String?,
                            phone : String?,
                            usName : String?,
                            name : String?,
                            code : String) {
    @ColumnInfo(name = "site")
    var site: String? = site

    @ColumnInfo(name = "defaultName")
    var defaultName: String? = defaultName

    @ColumnInfo(name = "logoURL")
    var logoURL: String? = logoURL

    @ColumnInfo(name = "phone")
    var phone: String? = phone

    @ColumnInfo(name = "usName")
    var usName: String? = usName

    @ColumnInfo(name = "name")
    var name: String? = name

    @PrimaryKey
    var code: String = code

}

@Dao
interface AirlineEntityDao {
    @get:Query("SELECT * FROM AirlineEntity")
    val all: Single<List<AirlineEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(airlineEntities: List<AirlineEntity>)
}

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