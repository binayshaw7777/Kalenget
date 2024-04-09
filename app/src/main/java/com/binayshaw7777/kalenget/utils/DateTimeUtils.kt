package com.binayshaw7777.kalenget.utils

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

internal object DateTimeUtils {
    const val ROW_COUNT = 6
    const val COLUMN_COUNT = 7

    const val DAY_FORMAT = "EEE"
    const val MONTH_DATE_FORMAT = "MMM dd"
    const val MONTH_YEAR_FORMAT = "MMM yyyy"
    const val FULL_DATE_FORMAT = "MMM dd, yyyy"
    const val DATE_FORMAT = "dd"
    const val WEEK_DAY_FORMAT = "EEEEE"

    fun getCalendar(timeInMillis: Long? = null): Calendar {
        val calendar = Calendar.getInstance()
        timeInMillis?.let {
            calendar.timeInMillis = it
        }
        return calendar
    }

    fun setTimeToBeginningOfDay(calendar: Calendar) {
        calendar.set(Calendar.HOUR_OF_DAY, 0)
        calendar.set(Calendar.MINUTE, 0)
        calendar.set(Calendar.SECOND, 0)
        calendar.set(Calendar.MILLISECOND, 0)
    }

    fun isSameDay(dayOne: Calendar, dayTwo: Calendar): Boolean {
        return dayOne.get(Calendar.YEAR) == dayTwo.get(Calendar.YEAR)
                && dayOne.get(Calendar.DAY_OF_YEAR) == dayTwo.get(Calendar.DAY_OF_YEAR)
    }

    fun formatDateTime(
        timeInMillis: Long,
        requiredFormat: String): String {
        val requiredSimpleDateFormat = SimpleDateFormat(requiredFormat,  Locale.getDefault())
        return requiredSimpleDateFormat.format(Date(timeInMillis))
    }
}