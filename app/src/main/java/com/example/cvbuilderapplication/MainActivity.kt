package com.example.cvbuilderapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.view.menu.MenuBuilder
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.cvbuilderapplication.ui.login.LoginActivity
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var logged: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Still to implement login, logged flag currently set to true
        if(logged){
            setCurrentFragment(HomeFragment())
        }else {
            startActivity((Intent(this, LoginActivity::class.java)))
        }
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home->setCurrentFragment(HomeFragment())
                R.id.contact->setCurrentFragment(ContactFragment())
                R.id.work->setCurrentFragment(WorkFragment())
                R.id.about->setCurrentFragment(AboutFragment())
            }
            true // return true
        }

    }

    @SuppressLint("RestrictedApi")
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        // Code to get the title and icon on the option overflow
        if (menu is MenuBuilder) {
            menu.setOptionalIconsVisible(true)
        }
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem):Boolean {
        Toast.makeText(
            applicationContext,
            item.title.toString(),
            Toast.LENGTH_LONG).show()
        return super.onOptionsItemSelected(item)
    }

    //For bottom menu
    private fun setCurrentFragment(frag: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment,frag)    //where fragment is the id for your xml fragment in Main.
            commit()
        } }

}