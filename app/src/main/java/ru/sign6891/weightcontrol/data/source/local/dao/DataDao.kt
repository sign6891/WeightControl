package ru.sign6891.weightcontrol.data.source.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.coroutines.flow.Flow
import ru.sign6891.weightcontrol.data.source.local.entity.DataElementEntity


@Dao
interface DataDao {

    @Query("SELECT*FROM dataelemententity")
     fun getAllElement(): LiveData<List<DataElementEntity>>

    @Query("SELECT * FROM dataelemententity WHERE :id like elementId")
    fun getElement(id: Int) : LiveData<DataElementEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertElement(dataElement: DataElementEntity)

    @Update
    fun updateElement(dataElement: DataElementEntity)

    @Query("DELETE FROM dataelemententity WHERE :id like elementId" )
    suspend fun deleteElement(id: Int)
}