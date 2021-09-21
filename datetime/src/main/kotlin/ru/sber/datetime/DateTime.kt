package ru.sber.datetime

import java.time.*
import java.time.format.DateTimeFormatter
import java.util.*

// 1.
fun getZonesWithNonDivisibleByHourOffset(): Set<String> {
    val zonesSet = mutableSetOf<String>()
    val localDateTime = LocalDateTime.now()

    for (item in ZoneId.getAvailableZoneIds()) {
        val id = ZoneId.of(item)
        val zonedDateTime = localDateTime.atZone(id)
        val zoneOffset = zonedDateTime.offset
        if (zoneOffset.totalSeconds % 3600 != 0)
            zonesSet.add(item)
    }
    return zonesSet
}

// 2.
fun getLastInMonthDayWeekList(year: Int): List<String> {
    val list = mutableListOf<String>()

    for (i in 1..12) {
        val month = YearMonth.of(year, i)
        val date = month.atEndOfMonth()
        list.add(date.dayOfWeek.name)
    }
    return list

}

// 3.
fun getNumberOfFridayThirteensInYear(year: Int): Int {
    var count = 0

    for (i in 1..12) {
        val date = LocalDate.of(year, i, 13)
        if (date.dayOfWeek == DayOfWeek.FRIDAY)
            count++
    }
    return count
}

// 4.
fun getFormattedDateTime(dateTime: LocalDateTime): String {
    val pattern = "dd MMM yyyy, HH:mm"
    val dateTimeFormatter = DateTimeFormatter.ofPattern(pattern, Locale.US)
    return dateTimeFormatter.format(dateTime)
}
