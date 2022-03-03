package com.nisith.kotlindemoapp1

import android.content.Context
import android.content.SharedPreferences

class MySharedPreference(context: Context) {
    private var sharedPreference: SharedPreferences =
        context.getSharedPreferences("theme_file", Context.MODE_PRIVATE)

    fun saveBackgroundTheme(themeName: String){
        val editor: SharedPreferences.Editor = sharedPreference.edit()
        editor.putString(Constants.BACKGROUND_THEME,themeName)
        editor.apply()
    }

    fun getSavedBackgroundTheme(): String? {
        return sharedPreference.getString(Constants.BACKGROUND_THEME,Constants.LIGHT_THEME)
    }


}