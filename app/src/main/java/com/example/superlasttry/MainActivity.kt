package com.example.superlasttry

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle
    lateinit var drawerLayout: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawerLayout)
        val navView : NavigationView = findViewById(R.id.navigationView)
        toggle = ActionBarDrawerToggle(this, drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {

            it.isChecked = true

            when(it.itemId) {
                R.id.RubContr -> replaseFragment(RubControl(), it.title.toString())
                R.id.MarkPract -> Toast.makeText(applicationContext,"Выполняется переход",Toast.LENGTH_SHORT).show()
                R.id.MarkSess -> replaseFragment(SessionMarks(), it.title.toString())
                R.id.MarkPract -> Toast.makeText(applicationContext,"Выполняется переход",Toast.LENGTH_SHORT).show()
                R.id.StudentStudyPlan -> Toast.makeText(applicationContext,"Выполняется переход",Toast.LENGTH_SHORT).show()
                R.id.UMKD -> Toast.makeText(applicationContext,"Выполняется переход",Toast.LENGTH_SHORT).show()
                R.id.Recomend_lit -> Toast.makeText(applicationContext,"Выполняется переход",Toast.LENGTH_SHORT).show()
                R.id.schedule -> Toast.makeText(applicationContext,"Выполняется переход",Toast.LENGTH_SHORT).show()
                R.id.News -> Toast.makeText(applicationContext,"Выполняется переход",Toast.LENGTH_SHORT).show()
                R.id.Online_maps -> Toast.makeText(applicationContext,"Выполняется переход",Toast.LENGTH_SHORT).show()
            }
            true
        }
    }

    private fun replaseFragment(fragment: Fragment,title : String){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout,fragment)
        fragmentTransaction.commit()
        drawerLayout.closeDrawers()
        setTitle(title)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }

        return super.onOptionsItemSelected(item)
    }


    fun openCloseNavigationDrawer(view: View) {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            drawerLayout.openDrawer(GravityCompat.START)
        }
    }

}