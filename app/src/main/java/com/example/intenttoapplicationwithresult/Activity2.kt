package com.example.intenttoapplicationwithresult

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class Activity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        val btnSave=findViewById<Button>(R.id.btn_save)
        val txtGivenName=findViewById<EditText>(R.id.txt_given_name)
        val txtSurName=findViewById<EditText>(R.id.txt_surname)

        btnSave.setOnClickListener(){
            intent.putExtra("name","${txtGivenName.text.toString()} ${txtSurName.text.toString()}")
            setResult(Activity.RESULT_OK,intent)
            finish()
        }
    }
}
