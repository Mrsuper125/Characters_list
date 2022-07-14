package com.sanyacoder.characters_list

import android.content.Context
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class About_character : AppCompatActivity() {

    private lateinit var nameElement : TextView
    private lateinit var genderElement : TextView
    private lateinit var speciesElement : TextView
    private lateinit var statusElement : TextView
    private lateinit var hamonElement : TextView
    private lateinit var motherlandElement : TextView
    private lateinit var image : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_character)

        nameElement = findViewById(R.id.name)
        genderElement = findViewById(R.id.gender)
        speciesElement = findViewById(R.id.species)
        statusElement = findViewById(R.id.status)
        hamonElement = findViewById(R.id.hamon)
        motherlandElement = findViewById(R.id.motherland)
        image = findViewById(R.id.image)

        image.setImageResource(image.context.resources.getIdentifier(intent.extras?.getString("image"), "drawable", image.context.packageName))

        var name = intent.extras?.getString("name")
        var gender = intent.extras?.getString("gender")
        var species = intent.extras?.getString("species")
        var status = intent.extras?.getString("status")
        var motherland = intent.extras?.getString("motherland")
        var hamon = intent.extras?.getBoolean("hamon")

        nameElement.text = name
        genderElement.text = "Пол: $gender"
        speciesElement.text = "Раса: $species"
        statusElement.text = "Статус: $status"
        motherlandElement.text = "Происхождение: $motherland"
        hamonElement.text = ("Хамон: " + if (hamon!!) "Да" else "Нет")
    }
}