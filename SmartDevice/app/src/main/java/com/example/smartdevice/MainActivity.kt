package com.example.smartdevice

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_name.*


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener{

    private lateinit var username : EditText
    private lateinit var password : EditText
    private lateinit var homeFragment: homeFragment
    private lateinit var profileFragment: profileFragment
    private lateinit var settingFragment: settingFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // No title
        try {
            this.supportActionBar!!.hide()
        } catch (e: NullPointerException) {}

        setContentView(R.layout.activity_main)

        setSupportActionBar(toolBar)
        val actionBar = supportActionBar
        actionBar.title = "Navigation Drawer"

        val drawerToggle: ActionBarDrawerToggle = object : ActionBarDrawerToggle (
            this,
            drawerLayout,
            toolBar,
            getString(R.string.textOpen),
            getString(R.string.textClose)
        ) {

        }

        drawerToggle.isDrawerIndicatorEnabled = true
        drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

    }

    fun login(view: View) {
        val intent = Intent(this, Home::class.java)

        username = findViewById(R.id.username)
        password = findViewById(R.id.password)

        val usernameText  = username.text.toString()
        val passwordText  = password.text.toString()

        intent.putExtra("username", usernameText)
        intent.putExtra("password", passwordText)

        startActivity(intent)
    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {

    }

}
