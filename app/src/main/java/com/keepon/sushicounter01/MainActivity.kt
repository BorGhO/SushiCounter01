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
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController

class MainActivity : AppCompatActivity() {

    lateinit var textProva : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val mainConstrView = findViewById<ConstraintLayout>(R.id.containerMainAct)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_ordine, R.id.navigation_notifications))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { nc: NavController, nd: NavDestination, bundle: Bundle? ->
            /* if(nd.id == nc.graph.startDestination){

                Log.i("SushiCounter", "then")

            }else{
                Log.i("SushiCounter", "else")

            }*/

            when (nd.id){

                R.id.navigation_ordine -> {
                    Log.i(R.string.app_tag.toString(), "Ordine")
                    mainConstrView.setBackgroundColor(ContextCompat.getColor(this, R.color.avocado))
                }
                R.id.navigation_home -> {
                    Log.i(R.string.app_tag.toString(), "Home")
                    mainConstrView.setBackgroundColor(ContextCompat.getColor(this, R.color.salmone))
                }
                R.id.navigation_notifications -> {
                    Log.i(R.string.app_tag.toString(), "Notifications")
                    mainConstrView.setBackgroundColor(ContextCompat.getColor(this, R.color.tonno))
                }
            }


        }

                /*, destination, _ ->
            if(destination.id == R.id.full_screen_destination) {
                toolbar.visibility = View.GONE
                bottomNavigationView.visibility = View.GONE
            } else {
                toolbar.visibility = View.VISIBLE
                bottomNavigationView.visibility = View.VISIBLE
            }
        }*/

        textProva = findViewById(R.id.textMainProva)
        //textProva.text = CoseUtili.textToPass ?: "porco"

        val Coso: CoseUtili by viewModels()
        Coso.selectedItem.observe(this, Observer { item ->
            // Perform an action with the latest item data
            textProva.text = item.toString()
        })
    }

        fun toSecondAct(view: View){
                startActivity(Intent(this, SecondActivity::class.java ))
        }
}