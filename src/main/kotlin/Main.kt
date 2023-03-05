fun main() {
    agoToText(39600)
}

fun agoToText(time: Int) {

    when {
        isTimeSeconds(time) -> println("Был в сети ${timeToText(time)} назад")
        isTimeMinuts(time) -> println("Был в сети ${timeToText(time)} назад")
        isTimeHours(time) -> println("Был в сети ${timeToText(time)} назад")
        isTimeYesterday(time) -> println("Был в сети вчера")
        isTimeBeforeYesterday(time) -> println("Был в сети позавчера")
        isTimeLongTimeAgo(time) -> println("Был в сети давно")
    }
}

fun timeToText(time: Int): String {
    when {
        isTimeSeconds(time) -> when {
            time % 10 == 1 && time % 100 != 11 -> return "$time секунду"
            time % 10 in 2..4 -> return "$time секунды"
            time % 10 in 5..9 || time % 10 == 0 || time % 100 == 11 -> return "$time секунд"
        }

        isTimeMinuts(time) -> return returnCorrectStringForMinutes(time)
        isTimeHours(time) -> return returnCorrectStringForHours(time)
    }
    return ""
}

fun returnCorrectStringForMinutes(time: Int): String {
    val convertedMinutes = convertSecondsToMinutes(time)
    when {
        convertedMinutes % 10 == 1 && convertedMinutes % 100 != 11 -> return "$convertedMinutes минуту"
        convertedMinutes % 10 in 2..4 -> return "$convertedMinutes минуты"
        convertedMinutes % 10 in 5..9 || convertedMinutes % 10 == 0 || convertedMinutes % 100 == 11 -> return "$convertedMinutes минут"
    }
    return ""
}

fun returnCorrectStringForHours(time: Int): String {
    val convertedHours = convertSecondsToHours(time)
    when {
        convertedHours % 10 == 1 && convertedHours % 100 != 11 -> return "$convertedHours час"
        convertedHours % 10 in 2..4 -> return "$convertedHours часа"
        convertedHours % 10 in 5..9 || convertedHours % 10 == 0 || convertedHours % 100 == 11 -> return "$convertedHours часов"
    }
    return ""
}


fun isTimeSeconds(time: Int): Boolean {
    if (time < 60) {
        return true
    }
    return false
}

fun isTimeMinuts(time: Int): Boolean {
    if (time >= 60 && time < 60 * 60) {
        return true
    }
    return false
}

fun isTimeHours(time: Int): Boolean {
    if (time >= 60 * 60 && time < 60 * 60 * 24) {
        return true
    }
    return false
}

fun isTimeYesterday(time: Int): Boolean {
    if (time >= 60 * 60 * 24 && time < 60 * 60 * 24 * 2) {
        return true
    }
    return false
}

fun isTimeBeforeYesterday(time: Int): Boolean {
    if (time >= 60 * 60 * 24 * 2 && time < 60 * 60 * 24 * 3) {
        return true
    }
    return false
}

fun isTimeLongTimeAgo(time: Int): Boolean {
    if (time > 60 * 60 * 24 * 3) {
        return true
    }
    return false
}


fun convertSecondsToMinutes(time: Int) = time / 60 % 60
fun convertSecondsToHours(time: Int) = time / 3600
