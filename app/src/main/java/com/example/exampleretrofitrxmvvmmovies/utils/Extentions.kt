package com.example.exampleretrofitrxmvvmmovies.utils

import android.content.Context
import android.net.ConnectivityManager
import java.lang.Exception
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

fun isNetworkAvailable(context: Context): Boolean {
    try {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    } catch (e: Exception) {
        return false
    }
}

fun String.removePTags(): String {
    // Verificar si el string comienza y termina con <p> y </p> respectivamente
    return if (startsWith("<p>") && endsWith("</p>")) {
        // Obtener la subcadena sin <p> al inicio y </p> al final
        substring(3, length - 4)
    } else {
        // Si no comienza y termina con <p>, devolver el mismo string
        this
    }
}

fun String.convertirDate(): String {
    // Parsear la cadena a LocalDateTime
    val formatoEntrada = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    val fechaEntrada = LocalDateTime.parse(this, formatoEntrada)

    // Formatear la fecha de salida
    val formatoSalida = DateTimeFormatter.ofPattern("d MMMM yyyy", Locale("es", "ES"))
    return  fechaEntrada.format(formatoSalida)
}
