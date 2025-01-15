package com.example.assigment3_19jan_rinku


private object Route {
    const val NOTELIST = "NoteList"
    const val ADDNOTE = "AddNote"
}

sealed class Screen(val route: String) {
    object NoteList : Screen(Route.NOTELIST)
    object AddNote : Screen(Route.ADDNOTE)
}

