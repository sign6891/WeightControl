package ru.sign6891.weightcontrol.data.source.local.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import ru.sign6891.weightcontrol.data.source.local.entity.DataElementEntity


@Dao
interface DataDao {

    @Query("SELECT*FROM dataelemententity")
     fun getAllElement(): Flow<List<DataElementEntity>>

    @Query("SELECT * FROM dataelemententity WHERE :id like elementId")
    fun getElement(id: Int) : DataElementEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertElement(dataElement: DataElementEntity)

    @Update
    fun updateElement(dataElement: DataElementEntity)

    @Query("DELETE FROM dataelemententity WHERE :id like elementId" )
    suspend fun deleteElement(id: Int)
}