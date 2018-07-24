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
