package com.example.data.datasource.local.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore

private const val STOCK_DATASTORE_NAME = "stock_prefs"

val Context.stockDataStore: DataStore<Preferences> by preferencesDataStore(name = STOCK_DATASTORE_NAME)