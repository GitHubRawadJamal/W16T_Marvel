package com.srj.w16t_marvel.util

import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp

object Constants {
    const val MARVEL_BASE_URL = "https://gateway.marvel.com"
    val TIME_STAMP = Timestamp(System.currentTimeMillis()).time.toString()
    const val API_KEY = "2e740d5494320b40a484c768d299f1d6"
    private const val PRIVATE_KEY = "00e819079e6e7457f02a44e66d9447deaa22efce"
    const val LIMIT = "90"
    fun hash(): String{
        val input = "$TIME_STAMP$PRIVATE_KEY$API_KEY"
        val md5 = MessageDigest.getInstance("MD5")
        return BigInteger(1, md5.digest(input.toByteArray())).toString(16).padStart(32, '0')
    }
}