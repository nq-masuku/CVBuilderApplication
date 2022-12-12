package com.example.cvbuilderapplication

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.cvbuilderapplication.ui.login.LoginActivity
import kotlinx.android.synthetic.main.activity_login.*

class NewUser : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_user)
    }

    fun onRegister(view: View) {
        val spf=getSharedPreferences("login", Context.MODE_PRIVATE)
        val spe=spf.edit()
        spe.putString("username", username.text.toString())
        spe.putString("password", password.text.toString())
        spe.apply()
        Toast.makeText(this, "User added successfully!", Toast.LENGTH_LONG).show()
        val intent= Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
}