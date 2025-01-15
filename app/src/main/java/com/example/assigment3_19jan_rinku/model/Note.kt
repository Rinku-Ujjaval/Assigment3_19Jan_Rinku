package com.example.assigment3_19jan_rinku.model

import android.net.Uri
import com.google.gson.Gson
import java.io.Serializable


data class Note(var id: Int? = null, var title: String? = null, var content: String? = null):
    Serializable{
    override fun toString(): String = Uri.encode(Gson().toJson(this))

}
