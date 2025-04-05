package com.example.quicknotes.ui

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quicknotes.R
import com.example.quicknotes.database.cloud_database.CloudDatabase
import com.example.quicknotes.models.TypeOfNote

class InputForm() : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       var noteTypes:String = intent.getStringExtra("typeOfNote")?:""
        enableEdgeToEdge()
        setContentView(R.layout.activity_input_form)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val note = findViewById<EditText>(R.id.editTextTextMultiLine)

        val spinner: Spinner = findViewById<Spinner>(R.id.dropdown_menu_ID)
        ArrayAdapter.createFromResource(
            this,
            R.array.dropdown_menu,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        val insertDatButton = findViewById<Button>(R.id.button)
        insertDatButton.setOnClickListener{
            if (noteTypes==TypeOfNote.HOME_NOTES.toString()){
                  CloudDatabase.setNotes(note.text.toString(),spinner.selectedItem.toString())
            }
            if (noteTypes==TypeOfNote.ARCHIVED_NOTES.toString()){
            CloudDatabase.setArchivedNotesData(note.text.toString(),spinner.selectedItem.toString())
            }
            if (noteTypes==TypeOfNote.AI_GENERATED_NOTES.toString()){
                CloudDatabase.setAIGeneratedNotesData(note.text.toString(),spinner.selectedItem.toString())
            }
            if (noteTypes==TypeOfNote.LOCKED_NOTES.toString()){
                CloudDatabase.setLockedNotesData(note.text.toString(),spinner.selectedItem.toString())
            }
        }
    }
}