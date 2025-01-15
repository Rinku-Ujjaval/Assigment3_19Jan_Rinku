package com.example.assigment3_19jan_rinku

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import android.graphics.Color
import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.text.TextStyle
import androidx.navigation.NavHostController
import com.example.assigment3_19jan_rinku.model.Note

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListOFNotes(
    noteViewModel: NoteViewModel,
    navHostController: NavHostController
) {
    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
        TopAppBar(
            title = { Text("Note List") },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = androidx.compose.ui.graphics.Color(
                    Color.BLACK
                ),
                titleContentColor = androidx.compose.ui.graphics.Color(Color.WHITE)
            )
        )
    }, floatingActionButton = {
        FloatingActionButton(
            containerColor = androidx.compose.ui.graphics.Color(Color.BLACK),
            onClick = {
                navHostController.navigate("${Screen.AddNote.route}/${Note()}/${"Add Note"}")
            }) {
            Icon(
                Icons.Filled.Add, "Add", tint = androidx.compose.ui.graphics.Color(
                    Color.WHITE
                )
            )
        }
    }) { innerPadding ->
        LazyColumn(
            Modifier
                .padding(innerPadding)
                .clickable {
                }) {
            items(noteViewModel.listNotes) { it ->
                Card(
                    onClick = {
                        navHostController.navigate("${Screen.AddNote.route}/${it}/${"Edit Note"}")
                    },
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxSize()
                ) {
                    Column(
                        modifier = Modifier.padding(10.dp),
                        verticalArrangement = Arrangement.SpaceAround
                    ) {
                        Text(
                            text = it.title.toString(), color = androidx.compose.ui.graphics.Color(
                                Color.BLACK
                            ), fontSize = 18.sp, fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = it.content.toString(),
                            maxLines = 2,
                            style = TextStyle()
                        )
                    }
                }
            }
        }
    }
}
