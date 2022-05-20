package ru.sign6891.weightcontrol.data.repository

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow
import ru.sign6891.weightcontrol.data.source.local.dao.DataDao
import ru.sign6891.weightcontrol.data.source.local.entity.DataElementEntity

class DataRepository(private val dataDao: DataDao){

    val allDataElement: Flow<List<DataElementEntity>> = dataDao.getAllElement()

    fun getElement(elementId: Int): DataElementEntity = dataDao.getElement(elementId)


    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(dataElevent: DataElementEntity) {
        dataDao.insertElement(dataElevent)
    }

}