package org.simonmonk.eds

val digit_text = arrayOf("", "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve", "diez", "once", "doce", "trece",
        "catorce", "quince", "dieciseis", "diecesiete", "dieciocho", "diecinueve")
val tens_text = arrayOf("", "", "vienti", "trenta", "cuarenta", "cincuenta", "sesenta", "setenta", "ochenta", "noventa")
val hundreds_text = arrayOf("", "ciento", "doscientos", "trescientos", "cuatorcientos", "quinientos", "seiscientos",
        "setecientos", "ochocientos", "novecientos")


fun numberToText(n : Int) : String {
    if (n == 0) {
        return "cero"
    }
    if (n < 20) {
        return(digit_text[n])
    }
    if (n < 100) {
        val tens = n / 10
        val units = n % 10
        if (units == 0) {
            return tens_text[tens]
        }
        else {
            if (tens == 2) {
                return tens_text[2] + numberToText(n - 20)
            }
            else {
                return tens_text[tens] + " y " + numberToText(n - (tens * 10))
            }
        }
    }
    if (n == 100) {
        return "cien"
    }
    if (n < 1000) {
        val hundreds = n / 100
        return hundreds_text[hundreds] + " " + numberToText(n - (hundreds * 100))
    }
    if (n == 1000) {
        return "mil"
    }
    if (n < 1000000) {
        val thousands = n / 1000
        if (thousands == 1) {
            return "mil " + numberToText(n - (thousands * 1000))
        }
        else {
            return numberToText(thousands) + " mil " + numberToText(n - (thousands * 1000))
        }
    }
    return ""
}

