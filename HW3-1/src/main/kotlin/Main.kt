fun main() {
    val visitingTime = 1727

    println("Был(а) ${agoToText(visitingTime)}")
}

fun agoToText(visitingTime: Int): String {
    return when {
        visitingTime >= 0 && visitingTime < 60 -> "только что"
        visitingTime >= 60 && visitingTime < 60 * 60 -> "${visitingTime / 60} ${minutesForTime(visitingTime)} назад"
        visitingTime >= 60 * 60 && visitingTime < 24 * 60 * 60 -> "${visitingTime / 60 / 60} ${hoursForTime(visitingTime)} назад"
        visitingTime >= 24 * 60 * 60 && visitingTime < 2 * 24 * 60 * 60 -> "вчера"
        visitingTime >= 2 * 24 * 60 * 60 && visitingTime < 3 * 24 * 60 * 60 -> "позавчера"
        else -> "давно"
    }
}

fun minutesForTime(visitingTime: Int): String {
    val minute = visitingTime / 60
    return when {
        minute === 1 || minute > 11 && (minute - 1) % 10 === 0 -> "минуту"
        minute in 2..4 || minute > 20 && minute % 10 in 1..5 -> "минуты"
        else -> "минут"
    }
}

fun hoursForTime(visitingTime: Int): String {
    val hour = visitingTime / 60 / 60
    return when {
        hour === 1 || hour > 11 && (hour - 1) % 10 === 0 -> "час"
        hour in 2..4 || hour > 20 && hour % 10 in 1..5 -> "часа"
        else -> "часов"
    }
}