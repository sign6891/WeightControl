package ru.sign6891.weightcontrol.util

import java.text.SimpleDateFormat
import java.util.*

fun getDefaultFormattedDate(date: Long): String {
    val simpleDateFormat = SimpleDateFormat("dd.MM.yyyy | HH:mm", Locale.getDefault())
    return simpleDateFormat.format(date)
}