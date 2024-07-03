package com.example.venderapp.pref

import androidx.datastore.preferences.core.intPreferencesKey
import kotlinx.coroutines.flow.Flow

val USER_KEY = intPreferencesKey("user_key")
interface UserPref {
    fun getPref(): Flow<Int>
    suspend fun setPref(userId: Int)
}