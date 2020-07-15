package com.example.intenttoapplicationwithresult

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnInfo=findViewById<Button>(R.id.btn_info)

        btnInfo.setOnClickListener{
            var mIntent=Intent(this, Activity2::class.java)
            startActivity(mIntent)
            startActivityForResult(Intent(this,Activity2::class.java),1)
        }
        Toast.makeText(this,"This message only only shows up  at first time we open the app.",Toast.LENGTH_LONG).show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val tvHello = findViewById<TextView>(R.id.tv_hello)

        when (requestCode) {
            1 -> {
                when (resultCode) {
                    Activity.RESULT_OK -> tvHello.text = "Hello ${data?.getStringExtra("name").toString()}"
                    Activity.RESULT_CANCELED -> tvHello.text = "Hello mate!"
                }
            }
            2 -> {
                when (resultCode) {
                    Activity.RESULT_OK -> tvHello.text = ""
                    Activity.RESULT_CANCELED -> tvHello.text = ""
                }
            }
        }
    }
}
