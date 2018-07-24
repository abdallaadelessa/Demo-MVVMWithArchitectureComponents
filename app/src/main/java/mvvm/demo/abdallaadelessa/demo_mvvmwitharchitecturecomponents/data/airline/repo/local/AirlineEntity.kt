package mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.repo.local

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

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