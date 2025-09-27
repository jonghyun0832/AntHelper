package com.example.data.datasource.local.datasourceImpl

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.example.data.datasource.local.datasource.StockLocalDataSource
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class StockLocalDataSourceImpl @Inject constructor(
    private val stockDataStore: DataStore<Preferences>
) : StockLocalDataSource {
    override suspend fun saveToken(token: String) {
        stockDataStore.edit { prefs ->
            prefs[TOKEN_KEY] = token
        }
    }

    override suspend fun getToken(): String? {
        return stockDataStore.data.map { it[TOKEN_KEY] }.firstOrNull()
    }

    override suspend fun clearToken() {
        stockDataStore.edit { prefs ->
            prefs.remove(TOKEN_KEY)
        }
    }

    companion object {
        private val TOKEN_KEY = stringPreferencesKey("stock_token")
    }
}

