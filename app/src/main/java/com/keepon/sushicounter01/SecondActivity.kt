package com.keepon.sushicounter01


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.keepon.sushicounter01.ui.home.HomeFragment
import com.keepon.sushicounter01.ui.ordineFolder.OrdineFragment


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

        val currentFragment = supportFragmentManager.findFragmentById(R.id.second_host_fragment)!!



//supportFragmentManager.getFragment()



        if (currentFragment.tag != "homeFrag") {    //TODO dio cane che modo del cazzo. Devo trovare come aggiungere il tag direttamente nell'xml
            transaction.replace(R.id.second_host_fragment, HomeFragment(), "homeFrag")

        }else {




            transaction.replace(R.id.second_host_fragment, OrdineFragment(), "ordineFrag")


            //transaction.addToBackStack("home")
        }

        //transaction.hide(NotificationsFragment())
        transaction.commit()

    }

    fun hideHost(view: View){

        val currentFragment = supportFragmentManager.findFragmentById(R.id.second_host_fragment)
        val transaction = supportFragmentManager.beginTransaction()

        if (currentFragment != null)
            if (currentFragment.isVisible)
                transaction.hide(currentFragment)
            else
                transaction.show(currentFragment)


        transaction.commit()
    }

    override fun onAttachFragment(fragment: Fragment) {
        println("id: "+fragment.id+" tag: "+fragment.tag)
        super.onAttachFragment(fragment)
    }


    fun removeButtListener(view: View){

        val frammenti = supportFragmentManager.fragments
        //frammenti.remove(OrdineFragment())

        val transaction = supportFragmentManager.beginTransaction()
       // transaction.addToBackStack("coso")





        transaction.commit()
    }

    fun toMainAct(view: View){
        startActivity(Intent(this, MainActivity::class.java ))
    }
}