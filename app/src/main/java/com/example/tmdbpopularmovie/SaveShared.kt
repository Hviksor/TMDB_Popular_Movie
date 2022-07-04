package com.example.tmdbpopularmovie

import android.content.Context
import android.preference.PreferenceManager

@Suppress("DEPRECATION")
class SaveShared {
    companion object {
        fun setFavorite(context: Context?, key: Int, value: Boolean) {
            val setFavoriteShared = PreferenceManager.getDefaultSharedPreferences(context)
            setFavoriteShared.edit().putBoolean(key.toString(), value).apply()
        }

        fun getFavorite(context: Context?, key: Int): Boolean {
            val getFavoriteShared = PreferenceManager.getDefaultSharedPreferences(context)
            return getFavoriteShared.getBoolean(key.toString(), false)

        }
    }
}