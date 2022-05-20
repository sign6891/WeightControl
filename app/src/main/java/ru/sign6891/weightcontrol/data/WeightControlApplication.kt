package ru.sign6891.weightcontrol.data

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import ru.sign6891.weightcontrol.data.repository.DataRepository
import ru.sign6891.weightcontrol.data.source.local.database.AppDatabase

class WeightControlApplication : Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy { AppDatabase.getDatabase(this, applicationScope) }
    val repository by lazy { DataRepository(database.dataDao()) }
}