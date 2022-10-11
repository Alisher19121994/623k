package com.example.a623k.managers

import android.content.Context
import android.content.SharedPreferences
import com.example.a623k.models.Member
import com.google.gson.Gson

class PrefsManager(context: Context) {

    private var sharedPreferences: SharedPreferences?

    init {
        sharedPreferences = context.getSharedPreferences("sharedP", Context.MODE_PRIVATE)
    }


    companion object {
        private var prefsManager: PrefsManager? = null

        fun getInstance(context: Context): PrefsManager? {
            if (prefsManager == null) {
                prefsManager = PrefsManager(context)
            }
            return prefsManager
        }
    }

    fun saveDate(member: Member) {
        val editor = sharedPreferences?.edit()
        val gson = Gson()
        val json = gson.toJson(member)
        editor?.putString("object", json)
        editor?.apply()
    }
}