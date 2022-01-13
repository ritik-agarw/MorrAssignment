package com.example.loginapp

import java.util.regex.Pattern

class Validation {
    fun IsValid(z: String): Boolean //luhn validation
    {
        val creditNumber = IntArray(z.length)
        for (i in z.indices) {
            creditNumber[i] = z.substring(i, i + 1).toInt()
            var temp = creditNumber[i]
            if (i % 2 == 0) {
                temp *= 2
                if (temp > 9) {
                    temp -= 9
                }
            }
            creditNumber[i] = temp
        }
        var total = 0
        for (i in 0 until z.length) {
            total += creditNumber[i]
        }
        return total % 10 == 0
    }

    fun type_validation(k: String?): Boolean {
        val americanExpress = "^3[47][0-9]{13}$"
        val discover =
            "^65[4-9][0-9]{13}|64[4-9][0-9]{13}|6011[0-9]{12}|(622(?:12[6-9]|1[3-9][0-9]|[2-8][0-9][0-9]|9[01][0-9]|92[0-5])[0-9]{10})$"
        val masterCard =
            "^(5[1-5][0-9]{14}|2(22[1-9][0-9]{12}|2[3-9][0-9]{13}|[3-6][0-9]{14}|7[0-1][0-9]{13}|720[0-9]{12}))$"
        val visaCard = "^4[0-9]{12}(?:[0-9]{3})?$"
        val r1 = Pattern.matches(americanExpress, k)
        val r2 = Pattern.matches(discover, k)
        val r3 = Pattern.matches(masterCard, k)
        val r4 = Pattern.matches(visaCard, k)
        return r1 || r2 || r3 || r4
    }

    fun cvv_validation(t: String?): Boolean {
        val cvvRegex = "^[0-9]{3,4}$"
        val r1 = Pattern.matches(cvvRegex, t)
        return r1
    }

    fun date_validation(q: String?): Boolean {
//        String date_regex = "^(0[1-9]|1[0-2])(/)([0-9]{2})$";
//        String date_regex = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
        val dateRegex = "^(0[1-9]|1[0-2]|[1-9])\\/(1[4-9]|[2-9][0-9]|20[1-9][1-9])$"
        val r1 = Pattern.matches(dateRegex, q)
        return r1
    }

    fun Name_validation(j: String?): Boolean //
    {
        val nameRegex = "^[A-Z][a-z]*$"
        val r1 = Pattern.matches(nameRegex, j)
        return r1
    }
}