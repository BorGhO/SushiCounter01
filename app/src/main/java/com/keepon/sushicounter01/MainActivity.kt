package com.keepon.sushicounter01

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.activity.viewModels
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.keepon.sushicounter01.ui.home.HomeFragment
import com.keepon.sushicounter01.ui.notifications.NotificationsFragment
import com.keepon.sushicounter01.ui.ordineFolder.OrdineFragment


class MainActivity : AppCompatActivity() {

    lateinit var textProva : TextView
    private var listaKeyInt = "itemOrdineListInt"
    private var listaKeyBool = "itemOrdineListBool"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val mainConstrView = findViewById<ConstraintLayout>(R.id.containerMainAct)

        val navController = findNavController(R.id.first_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_ordine, R.id.navigation_notifications))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { nc: NavController, nd: NavDestination, bundle: Bundle? ->


            when (nd.id){

                R.id.navigation_ordine -> {
                    Log.e(R.string.app_tag.toString(), "Ordine - ")
                    mainConstrView.setBackgroundColor(ContextCompat.getColor(this, R.color.avocado))
                }
                R.id.navigation_home -> {
                    Log.e(R.string.app_tag.toString(), "Home - ")
                    mainConstrView.setBackgroundColor(ContextCompat.getColor(this, R.color.salmone))
                }
                R.id.navigation_notifications -> {
                    Log.e(R.string.app_tag.toString(), "Notifications - ")
                    mainConstrView.setBackgroundColor(ContextCompat.getColor(this, R.color.tonno))
                }
            }
        }

        textProva = findViewById(R.id.textMainProva)


        val Coso: CoseUtili by viewModels()
        Coso.selectedItem.observe(this, Observer { item ->
        //Coso.selectedItem.observeForever( Observer { item ->
            // Perform an action with the latest item data
            textProva.text = item.toString()
        })
        val isEditing :Boolean = savedInstanceState?.getBoolean(listaKeyBool, false) == true
        val indice : Int = savedInstanceState?.getInt(listaKeyInt, -1) ?: 666
        println("isEditingMain: " + isEditing + " indiceMain:" + indice)

    }//fine onCreate

    fun toSecondAct(view: View){
        startActivity(Intent(this, SecondActivity::class.java ))
        //val currentFragment: Fragment? = supportFragmentManager.fragments[0]

        val currentFragment = supportFragmentManager.findFragmentById(R.id.first_host_fragment)   //questo seleziona l'host xml nel xml dell'activity



        //replaceFragment(currentFragment)                    //R.id.navigation_home))


    }




    fun replaceFragment(fragment: Fragment?) {

        val transaction = supportFragmentManager.beginTransaction()
        // transaction.replace(R.id.second_host_fragment, HomeFragment())

        val noti = NotificationsFragment()

        if (true || noti.isVisible)
            transaction.hide(noti)
        else
            transaction.show(noti)


        transaction.commit()

    }

    private fun replaceFragment2(fragment: Fragment?) {
        val support = supportFragmentManager.beginTransaction()//.apply {


        if (fragment != null) {

            if(fragment.isVisible){
            //if (fragment.isAdded) {
                support.hide(fragment)

            } /*else {
                support.add(R.id.nav_host_fragment, fragment)
            }*/


            if (fragment.isHidden){
                support.show(fragment)
            }

            supportFragmentManager.fragments.forEach {
                if (it != fragment && it.isAdded) {


                }
            }
            //}
            support.commit()
        }
    }

    /*
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        val isEditing :Boolean = savedInstanceState?.getBoolean(listaKeyBool, false) == true
        val indice : Int = savedInstanceState?.getInt(listaKeyInt, -1) ?: 666
        println("isEditingRestore: " + isEditing + " indiceRestore:" + indice)


    }
*/

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)



        outState.putBoolean(listaKeyBool, true)
        outState.putInt(listaKeyInt, 5)
        println("saved nel main" )

    }
}