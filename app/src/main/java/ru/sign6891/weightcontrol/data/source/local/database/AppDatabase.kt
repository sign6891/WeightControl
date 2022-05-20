package ru.sign6891.weightcontrol.data.source.local.database

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import ru.sign6891.weightcontrol.data.source.local.dao.DataDao
import ru.sign6891.weightcontrol.data.source.local.entity.DataElementEntity

@Database(entities = [DataElementEntity::class], version = 1, exportSchema = false)
 abstract class AppDatabase : RoomDatabase() {

    abstract fun dataDao(): DataDao

    companion object {
        // For Singleton instantiation
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "database.db"
                ).addCallback(AppDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }

    private class AppDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    populateDatabase(database.dataDao())
                }
            }
        }

        suspend fun populateDatabase(dataDao: DataDao) {
            // Delete all content here.
            //dataDao.deleteAll()

            // Add sample words.
            var word = DataElementEntity("", "")
            dataDao.insertElement(word)
        }
    }
}