package com.example.venderapp.pref

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

class UserPrefImp(private val dataStore: DataStore<Preferences>): UserPref {
    override fun getPref(): Flow<Int> {
        return dataStore.data.catch {
//            If error comes
            emit(emptyPreferences())
        }.map {
            it[USER_KEY] ?: 0
        }
    }

    override suspend fun setPref(userId: Int) {
        dataStore.edit {
            it[USER_KEY] = userId
        }
    }

}