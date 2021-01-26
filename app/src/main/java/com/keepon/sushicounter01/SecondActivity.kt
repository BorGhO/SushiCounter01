package com.keepon.sushicounter01


import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.keepon.sushicounter01.ui.dashboard.DashboardFragment
import com.keepon.sushicounter01.ui.home.HomeFragment

class SecondActivity : AppCompatActivity() {

    lateinit var fragView : Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

       // fragView = findViewById(R.id.second_host_fragment)

        //val manager: FragmentManager = FragmentManager
    }

    fun cambiaFrag(view: View) {

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.second_host_fragment, HomeFragment())
        transaction.commit()

    }

    fun toMainAct(view: View){
        startActivity(Intent(this, MainActivity::class.java ))
    }
}