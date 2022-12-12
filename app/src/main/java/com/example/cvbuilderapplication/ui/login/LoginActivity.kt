package com.example.cvbuilderapplication.ui.login

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.view.menu.MenuBuilder
import com.example.cvbuilderapplication.MainActivity
import com.example.cvbuilderapplication.NewUser
import com.example.cvbuilderapplication.R
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

    }

    fun onLogin(view: View){
        var username = username.text.toString()
        var password = password.text.toString()

        val spf=getSharedPreferences("login", Context.MODE_PRIVATE)
        val user = spf.getString("username","null")
        val pass = spf.getString("password","null")
        if(username.equals(user, ignoreCase = true) && password.equals(pass, ignoreCase = true)){
            val spf=getSharedPreferences("login", Context.MODE_PRIVATE)
            val spe=spf.edit()
            spe.putBoolean("logged", true)
            spe.apply()

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }else{
            Toast.makeText(this, "Invalid credentials, please try again", Toast.LENGTH_LONG).show()
        }

    }

    fun onRegister(view: View) {
        val intent=Intent(this, NewUser::class.java)
        startActivity(intent)
    }

}