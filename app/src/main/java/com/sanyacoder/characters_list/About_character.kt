package com.sanyacoder.characters_list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class About_character : AppCompatActivity() {

    private lateinit var nameElement : TextView
    private lateinit var genderElement : TextView
    private lateinit var speciesElement : TextView
    private lateinit var statusElement : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_character)

        nameElement = findViewById(R.id.name)
        genderElement = findViewById(R.id.gender)
        speciesElement = findViewById(R.id.species)
        statusElement = findViewById(R.id.status)

        var name = intent.extras?.getString("name")
        var gender = intent.extras?.getString("gender")
        var species = intent.extras?.getString("species")
        var status = intent.extras?.getString("status")

        nameElement.text = name
        genderElement.text = gender
        speciesElement.text = species
        statusElement.text = status
    }
}