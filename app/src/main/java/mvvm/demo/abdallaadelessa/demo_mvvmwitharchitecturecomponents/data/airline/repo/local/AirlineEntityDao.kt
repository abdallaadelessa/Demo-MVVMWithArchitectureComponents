package mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.repo.local

import android.arch.persistence.room.*
import io.reactivex.Single
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.model.AirlineEntity


@Dao
interface AirlineEntityDao {
    @get:Query("SELECT * FROM AirlineEntity")
    val all: Single<List<AirlineEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(airlineEntities: List<AirlineEntity>)
}
