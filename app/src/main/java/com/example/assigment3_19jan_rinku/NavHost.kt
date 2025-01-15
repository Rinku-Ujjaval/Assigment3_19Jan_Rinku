package com.example.assigment3_19jan_rinku

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.assigment3_19jan_rinku.model.Note
import com.google.gson.Gson

@Composable
fun RootNavHost() {
    val navController = rememberNavController()
    val noteViewModel = viewModel { NoteViewModel() }
    var addNote: String = "Add"

    NavHost(
        navController = navController, startDestination = Screen.NoteList.route
    ) {
        composable(Screen.NoteList.route) {
            ListOFNotes(noteViewModel, navController)
        }

        composable(
            "${Screen.AddNote.route}/{item}/{name}", arguments = listOf(
                navArgument("item") { type = NoteArgType() },
            )
        ) { backStackEntry ->
            val item = backStackEntry.arguments?.getString("item")
                ?.let { Gson().fromJson(it, Note::class.java) }
            val name = backStackEntry.arguments?.getString("name")

            AddListNote(noteViewModel, name, item) {
                navController.navigate(Screen.NoteList.route)
            }
        }
    }
}