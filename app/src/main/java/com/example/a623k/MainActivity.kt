package com.example.a623k

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.a623k.managers.PrefsManager
import com.example.a623k.models.Member

class MainActivity : AppCompatActivity() {
    private lateinit var save_Button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        save_Button = findViewById(R.id.button_save)
        save_Button.setOnClickListener {
            save()
        }


    }

    private fun save() {
        val fullname: EditText = findViewById(R.id.fullname_id)
        val age: EditText = findViewById(R.id.age_id)


        val getFullname = fullname.text.toString().trim()
        val getAge = age.text.toString().trim()

        val member = Member(getFullname, getAge.toInt())
        PrefsManager.getInstance(this)?.saveDate(member)
    }
}