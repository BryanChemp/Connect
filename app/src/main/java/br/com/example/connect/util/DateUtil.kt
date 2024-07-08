package br.com.example.connect.util

import android.os.Build
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

class DateUtil {
    companion object {
        @RequiresApi(Build.VERSION_CODES.O)
        fun getHour(date: java.util.Date): Int {
            val localDateTime = LocalDateTime.ofInstant(date.toInstant(), java.time.ZoneId.systemDefault())
            return localDateTime.hour
        }
        @RequiresApi(Build.VERSION_CODES.O)
        fun formatDate(date: String): String {
            val inputDateTime = LocalDateTime.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))
            val currentDateTime = LocalDateTime.now()

            return if (ChronoUnit.DAYS.between(inputDateTime.toLocalDate(), currentDateTime.toLocalDate()) <= 7) {
                inputDateTime.dayOfWeek.name.substring(0, 3)
            } else {
                inputDateTime.format(DateTimeFormatter.ofPattern("dd/MM"))
            }
        }
    }
}