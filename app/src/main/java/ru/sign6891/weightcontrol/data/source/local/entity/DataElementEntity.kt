package ru.sign6891.weightcontrol.data.source.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class DataElementEntity(var time: String?, var weight: String) {
    @PrimaryKey(autoGenerate = true)
    var elementId = 0
}
