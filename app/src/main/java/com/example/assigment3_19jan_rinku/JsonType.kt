package com.example.assigment3_19jan_rinku

import android.os.Bundle
import androidx.navigation.NavType
import com.example.assigment3_19jan_rinku.model.Note
import com.google.gson.Gson

abstract class JsonNavType<T> : NavType<T>(isNullableAllowed = false) {
    abstract fun fromJsonParse(value: String): T
    abstract fun T.getJsonParse(): String

    override fun get(bundle: Bundle, key: String): T? =
        bundle.getString(key)?.let { parseValue(it) }

    override fun parseValue(value: String): T = fromJsonParse(value)

    override fun put(bundle: Bundle, key: String, value: T) {
        bundle.putString(key, value.getJsonParse())
    }
}

class NoteArgType : JsonNavType<Note>() {
    override fun fromJsonParse(value: String): Note = Gson().fromJson(value, Note::class.java)
    override fun Note.getJsonParse(): String {
        return Gson().toJson(this)
    }

}
