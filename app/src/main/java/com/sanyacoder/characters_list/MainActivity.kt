package com.sanyacoder.characters_list

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

data class Character(val name: String, val species: String, val gender: String, val status: String, val motherland: String, val hamon: Boolean, val image: String)


val characters = listOf(
    Character(
        name = "Джонатан Джостар",
        species = "Человек",
        gender = "Мужской",
        status = "Мёртв",
        motherland = "Англия",
        hamon = true,
        image = "jonathan"
    ),
    Character(
        name = "Дио Брандо",
        species = "Человек, позже вампир",
        gender = "Мужской",
        status = "Жив (признан мёртвым)",
        motherland = "Англия",
        hamon = false,
        image = "dio"
    ),
    Character(
        name = "Джордж Джостар I",
        species = "Человек",
        gender = "Мужской",
        status = "Мёртв",
        motherland = "Англия",
        hamon = false,
        image = "george"
    ),
    Character(
        name = "Дарио Брадно",
        species = "Человек",
        gender = "Мужской",
        status = "Мёртв",
        motherland = "Англия",
        hamon = false,
        image = "dario"
    ),
    Character(
        name = "Эрина Пендлтон/Джостар",
        species = "Человек",
        gender = "Женский",
        status = "Жива",
        motherland = "Англия",
        hamon = false,
        image = "erina"
    ),
    Character(
        name = "Дэнни",
        species = "Собака",
        gender = "Мужской",
        status = "Мёртв",
        motherland = "Англия",
        hamon = false,
        image = "danny"
    ),
    Character(
        name = "Роберт Э.О. Спидвагон",
        species = "Человек",
        gender = "Мужской",
        status = "Жив",
        motherland = "Англия",
        hamon = false,
        image = "speedwagon"
    ),
    Character(
        name = "Джэк - потрошитель",
        species = "Человек, позже зомби",
        gender = "Мужской",
        status = "Мёртв",
        motherland = "Англия",
        hamon = false,
        image = "jack"
    ),
    Character(
        name = "Уилл А. Цеппели",
        species = "Человек",
        gender = "Мужской",
        status = "Мёртв",
        motherland = "Англия",
        hamon = true,
        image = "ceppeli"
    ),
    Character(
        name = "Тонпетти",
        species = "Человек",
        gender = "Мужской",
        status = "Неизвестен",
        motherland = "Тибет",
        hamon = true,
        image = "tonpetti"
    ),
    Character(
        name = "Стрейтс",
        species = "Человек",
        gender = "Мужской",
        status = "Жив",
        motherland = "Тибет",
        hamon = true,
        image = "straits"
    ),
    Character(
        name = "Дайр",
        species = "Человек",
        gender = "Мужской",
        status = "Мёртв",
        motherland = "Тибет",
        hamon = true,
        image = "dire"
    ),
    Character(
        name = "Ван Чен",
        species = "Человек, позже зомби",
        gender = "Мужской",
        status = "Жив",
        motherland = "Китай",
        hamon = false,
        image = "wang_chang"
    ),
    Character(
        name = "Поко",
        species = "Человек",
        gender = "Мужской",
        status = "Жив",
        motherland = "Англия",
        hamon = false,
        image = "poco"
    ),
    Character(
        name = "Бруфорд",
        species = "Человек, позже зомби, позже снова человек",
        gender = "Мужской",
        status = "Мёртв",
        motherland = "Англия",
        hamon = false,
        image = "bruford"
    ),
    Character(
        name = "Таркус",
        species = "Человек, позже зомби",
        gender = "Мужской",
        status = "Мёртв",
        motherland = "Англия",
        hamon = false,
        image = "tarkus"
    ),
    Character(
        name = "Сестра Поко",
        species = "Человек",
        gender = "Женский",
        status = "Жива",
        motherland = "Англия",
        hamon = false,
        image = "poco_sister"
    ),
    Character(
        name = "Неизвестный ребёнок (позже Лиза Лиза)",
        species = "Человек",
        gender = "Женский",
        status = "Жива",
        motherland = "Англия",
        hamon = false,
        image = "lisalisa"
    ),
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
            intent.putExtra("motherland", found_character.motherland)
            intent.putExtra("hamon", found_character.hamon)
            intent.putExtra("image", found_character.image)
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