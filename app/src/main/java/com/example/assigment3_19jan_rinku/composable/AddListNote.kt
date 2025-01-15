package com.example.assigment3_19jan_rinku.composable

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.assigment3_19jan_rinku.model.Note
import com.example.assigment3_19jan_rinku.viewmodel.NoteViewModel
import kotlin.text.isNullOrEmpty
import kotlin.toString

@SuppressLint("RememberReturnType")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddListNote(
    noteViewModel: NoteViewModel,
    name: String?,
    item: Note?,
    noteList: () -> Unit
) {
    var title = remember {
        if (item?.title.isNullOrEmpty()) mutableStateOf(TextFieldValue("")) else mutableStateOf(
            TextFieldValue(item?.title.toString())
        )
    }
    var content = remember {
        if (item?.content.isNullOrEmpty()) mutableStateOf(TextFieldValue("")) else
            mutableStateOf(TextFieldValue(item?.content.toString()))
    }

    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
        TopAppBar(
            title = {
                Text(name.toString())
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = androidx.compose.ui.graphics.Color(
                    Color.BLACK
                ),
                titleContentColor = androidx.compose.ui.graphics.Color(Color.WHITE)
            )
        )
    }) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = androidx.compose.ui.graphics.Color(
                        Color.BLACK
                    )
                ),
                modifier = Modifier
                    .padding(10.dp)
                    .background(color = androidx.compose.ui.graphics.Color.Black)
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(10.dp)

                ) {
                    TextField(
                        label = { Text(text = "Title") },
                        value = title.value,
                        onValueChange = { it ->
                            title.value = it
                        })
                    TextField(
                        maxLines = 2,
                        label = { Text(text = "Content") },
                        value = content.value,
                        onValueChange = { it ->
                            content.value = it
                        })
                    Spacer(modifier = Modifier.height(10.dp))
                    Row {
                        Button(
                            onClick = {
                                if (name == "Add Note") {
                                    noteViewModel.addNote(
                                        title.value.text.toString(),
                                        content.value.text.toString()
                                    )
                                } else {
                                    noteViewModel.updateNote(
                                        Note(
                                            item?.id,
                                            title.value.text.toString(),
                                            content.value.text.toString()
                                        )
                                    )
                                }
                                noteList()
                            }, modifier = Modifier
                                .width(100.dp)
                                .height(50.dp)
                        ) {
                            Text("Save")
                        }
                        Button(onClick = {
                            noteViewModel.delete(item!!)
                        }) {
                            Text("Delete")
                        }
                    }
                }
            }
        }
    }
}