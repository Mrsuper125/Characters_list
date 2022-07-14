package com.sanyacoder.characters_list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

data class Character(val id: Int, val name: String, val species: String, val gender: String, val status: String)


val characters = listOf(
    Character(
        id = 0,
        name = "Beth Smith",
        species = "Human",
        gender = "Female",
        status = "Alive"
    ),
    Character(
        id = 1,
        name = "Squid Costume Morty",
        species = "Robot",
        gender = "Male",
        status = "Dead"
    ),
    Character(
        id = 2,
        name = "Rick Sanchez",
        species = "Human",
        gender = "Male",
        status = "Alive"
    )
)

fun search_for_characters(keyWord:String) : List<Character>{
    var found = mutableListOf<Character>()
    for (i in characters){
        if (i.name.contains(keyWord, true)){
            found.add(i)
        }
    }
    return found
}

class MainActivity : AppCompatActivity() {

    private lateinit var search_input : EditText
    private lateinit var search_button : Button
    private lateinit var forward : Button
    private lateinit var backward : Button
    private lateinit var search_result : TextView

    private lateinit var found_characters : List<Character>

    fun refresh(found_character : Character){
        search_result.text = found_character.name
        search_result.setOnClickListener{
            val intent = Intent(this@MainActivity, About_character::class.java)
            intent.putExtra("name", found_character.name)
            intent.putExtra("gender", found_character.gender)
            intent.putExtra("species", found_character.species)
            intent.putExtra("status", found_character.status)
            startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        search_input = findViewById(R.id.search_input)
        search_button = findViewById(R.id.search_button)
        forward = findViewById(R.id.forward)
        backward = findViewById(R.id.backward)
        search_result = findViewById(R.id.search_result)

        search_button.setOnClickListener {
            val search_request = search_input.text.toString()
            var i = 0
            found_characters = search_for_characters(search_request)
            if (found_characters.isEmpty()) {
                search_result.text = "К сожалению, по запросу $search_request не найдено ни одного персонажа"
                search_result.setOnClickListener(null)
            } else {
                search_result.text = found_characters[0].name
                refresh(found_characters[i])

                forward.setOnClickListener{
                    if (i < (found_characters.count() - 1)) {
                        i++
                        refresh(found_characters[i])
                    }
                }
                backward.setOnClickListener{
                    if (i > 0) {
                        i--
                        refresh(found_characters[i])
                    }
                }
            }
        }
    }
}