package com.lua.eventosunp

import android.content.res.Configuration
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import com.lua.eventosunp.databinding.ActivityMainBinding
import com.lua.eventosunp.ui.Repos.AlumnosRepos
import com.lua.eventosunp.ui.fragments.FragmentAlumnos
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var bindinn: ActivityMainBinding
    private lateinit var drawer: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var toggle: ActionBarDrawerToggle
    private val alumnosRepos = AlumnosRepos()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar_main)
        setSupportActionBar(toolbar)

        drawer = findViewById(R.id.main)
        navigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        toggle = ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer.addDrawerListener(toggle)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        var selectedFragment: Fragment? = null
        when (item.itemId) {
            R.id.Eventos -> Toast.makeText(this, "boton eventos", Toast.LENGTH_SHORT).show()
            R.id.Usuarios -> Toast.makeText(this, "boton agregar", Toast.LENGTH_SHORT).show()
            R.id.Estudiantes -> selectedFragment = FragmentAlumnos()
            R.id.Categorias -> cargarAlumnos()
            R.id.Departamentos -> cargarAlumnos()
            R.id.Carreras -> cargarAlumnos()
        }
        if (selectedFragment != null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, selectedFragment)
                .commit()
        }


        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    private fun cargarAlumnos() {
        CoroutineScope(Dispatchers.Main).launch {
            val alumnos = withContext(Dispatchers.IO) { alumnosRepos.getAlumnos() }
            if (alumnos.isNotEmpty()) {
                Toast.makeText(this@MainActivity, "Alumnos recibidos: ${alumnos.size}", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@MainActivity, "No se recibieron alumnos.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        toggle.syncState()
    }


    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        toggle.onConfigurationChanged(newConfig)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onContextItemSelected(item)
    }
}