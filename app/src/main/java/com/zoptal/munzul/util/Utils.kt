package com.zoptal.munzul.util



import okhttp3.MediaType
import okhttp3.RequestBody
import java.text.SimpleDateFormat
import java.util.*
import java.util.regex.Matcher
import java.util.regex.Pattern


/**
 * Created by android on 2/11/17.
 * *
 */
object Utils {

    fun convertWithStringDate(time: String): String {
        val date = Date(time.toLong())
        val sdf = SimpleDateFormat("dd-MM-yyyy", Locale.US)
        sdf.timeZone = TimeZone.getDefault()

        return sdf.format(date)
    }

    fun getDate(time: Long): String {
        val date = Date(time * 1000L) // *1000 is to convert seconds to milliseconds
        val sdf = SimpleDateFormat("hh:mm a") // the format of your date
        sdf.timeZone = TimeZone.getDefault()

        return sdf.format(date)
    }

    fun convertWithStringTime(time: String): String {
        val date = Date(time.toLong())

        val sdf = SimpleDateFormat("dd MMM yyyy", Locale.US)

        sdf.timeZone = TimeZone.getDefault()

        return sdf.format(date)
    }

    /**
     * calculate the time according to mins, days, weeks, months, years
     *
     * @param time
     * @return
     */
    fun showChatTime(time: Long): String {
        val startDate = Date(time)
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = startDate.time

        val now = Calendar.getInstance()
        var different = now.timeInMillis - calendar.timeInMillis

        val secondsInMilli: Long = 1000
        val minutesInMilli = secondsInMilli * 60
        val hoursInMilli = minutesInMilli * 60
        val daysInMilli = hoursInMilli * 24
        val weeksInMilli = daysInMilli * 7
        val monthsInMilli = daysInMilli * 30
        val yearsInMilli = daysInMilli * 365

        val elapsedYears = different / yearsInMilli
        different %= yearsInMilli

        val elapsedMonths = different / monthsInMilli
        different %= monthsInMilli

        val elapsedWeeks = different / weeksInMilli
        different %= weeksInMilli

        val elapsedDays = different / daysInMilli
        different %= daysInMilli

        val elapsedHours = different / hoursInMilli
        different %= hoursInMilli

        val elapsedMinutes = different / minutesInMilli
        different %= minutesInMilli

        if (elapsedYears > 0) {
            return if (elapsedYears == 1L) "$elapsedYears year ago" else "$elapsedYears years ago"
        } else if (elapsedMonths > 0) {
            return if (elapsedMonths == 1L) "$elapsedMonths month ago" else "$elapsedMonths months ago"
        } else if (elapsedWeeks > 0) {
            return if (elapsedWeeks == 1L) "$elapsedWeeks week ago" else "$elapsedWeeks weeks ago"
        } else if (elapsedDays > 0) {
            val calendar2 = Calendar.getInstance()
            calendar2.add(Calendar.DAY_OF_MONTH, -1)
            if (calendar2.get(Calendar.DATE) == calendar.get(Calendar.DATE)) {
                return "Yesterday"
            }
            return if (elapsedDays == 1L) "$elapsedDays day ago" else "$elapsedDays days ago"
        } else if (elapsedHours > 0) {
            return if (elapsedHours == 1L) "$elapsedHours hour ago" else "$elapsedHours hours ago"
        } else if (elapsedMinutes > 0) {
            return if (elapsedMinutes == 1L) "$elapsedMinutes min ago" else "$elapsedMinutes mins ago"
        }
        return "Just now"
    }




     fun setTime(time: String):String {
         val simpleDate = SimpleDateFormat("dd/M/yyyy hh:mm a", Locale.ENGLISH)
         simpleDate.setTimeZone(TimeZone.getTimeZone("UTC"))
         val date = Date(time.toLong())
         simpleDate.setTimeZone(TimeZone.getDefault())
         val finalDate=simpleDate.format(date)
         return finalDate
     }



    /**
     * @Method to Convert String to Request Body
     * @return RequestBody
     **/
    fun createRequestBody(data: String?): RequestBody {

        return RequestBody.create(MediaType.parse("multipart/form-data"), data)

    }

}