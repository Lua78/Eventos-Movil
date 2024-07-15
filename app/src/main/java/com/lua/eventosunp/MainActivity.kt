package com.lua.eventosunp

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.navigation.NavigationView
import com.lua.eventosunp.data.LoginDataSource
import com.lua.eventosunp.data.LoginRepository
import com.lua.eventosunp.databinding.ActivityMainBinding
import com.lua.eventosunp.ui.Repos.AlumnosRepos
import com.lua.eventosunp.ui.Repos.CategoriasRepos
import com.lua.eventosunp.ui.fragments.FragmentAlumnos
import com.lua.eventosunp.ui.fragments.FragmentCategorias
import com.lua.eventosunp.ui.login.LoginActivity
import com.lua.eventosunp.ui.login.LoginViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var drawer: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var toggle: ActionBarDrawerToggle
    private val alumnosRepos = AlumnosRepos()
    private final val categoriasRepos = CategoriasRepos()
    private lateinit var imagen: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar_main)
        setSupportActionBar(toolbar)

        drawer = findViewById(R.id.main)
        navigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        imagen = binding.fondo
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
            R.id.Categorias -> selectedFragment = FragmentCategorias()
            R.id.Departamentos -> selectedFragment = FragmentCategorias()
            R.id.Carreras -> selectedFragment = FragmentAlumnos()
            R.id.logout -> cerrarSesion()
        }
        if (selectedFragment != null) {
            imagen.visibility = ImageView.GONE
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, selectedFragment)
                .commit()
        }


        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    private fun cerrarSesion() {
        val appContext = applicationContext
        val loginRepo = LoginDataSource(appContext)

        CoroutineScope(Dispatchers.Main).launch {
            loginRepo.logout()
            startActivity(Intent(appContext, LoginActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            })

            finish()
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