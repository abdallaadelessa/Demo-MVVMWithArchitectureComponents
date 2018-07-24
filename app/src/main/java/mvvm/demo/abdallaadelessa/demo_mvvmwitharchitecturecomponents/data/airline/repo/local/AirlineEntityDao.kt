package mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.repo.local

import android.arch.persistence.room.*
import android.content.Context
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single



@Dao
interface AirlineEntityDao {
    @get:Query("SELECT * FROM AirlineEntity")
    val all: Single<List<AirlineEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(airlineEntities: List<AirlineEntity>)
}
