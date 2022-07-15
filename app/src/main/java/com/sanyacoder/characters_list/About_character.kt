package com.sanyacoder.characters_list

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

        val name = intent.extras?.getString("name")
        val gender = intent.extras?.getString("gender")
        val species = intent.extras?.getString("species")
        val status = intent.extras?.getString("status")
        val motherland = intent.extras?.getString("motherland")
        val hamon = intent.extras?.getBoolean("hamon")

        nameElement.text = name
        genderElement.text = "Пол: $gender"
        speciesElement.text = "Раса: $species"
        statusElement.text = "Статус: $status"
        motherlandElement.text = "Происхождение: $motherland"
        hamonElement.text = ("Хамон: " + if (hamon!!) "Да" else "Нет")
    }
}