package com.example.quicknotes

import android.content.Intent
import android.os.Bundle
import android.os.Environment
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.quicknotes.database.cloud_database.CloudDatabase
import com.example.quicknotes.databinding.ActivityMainBinding
import com.example.quicknotes.models.TypeOfNote
import com.example.quicknotes.ui.InputForm
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.io.File

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )

        val addButton: FloatingActionButton =findViewById<FloatingActionButton>(R.id.floatingActionButton2)

        addButton.setOnClickListener {
            val intent = Intent(this, InputForm::class.java)
            intent.putExtra("typeOfNote", TypeOfNote.HOME_NOTES.toString())
            startActivity(intent)
        }

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
}