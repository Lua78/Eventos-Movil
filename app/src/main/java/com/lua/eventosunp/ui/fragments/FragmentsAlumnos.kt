package com.lua.eventosunp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lua.eventosunp.R
import com.lua.eventosunp.data.DTO.Alumno
import com.lua.eventosunp.ui.Repos.AlumnosRepos
import com.lua.eventosunp.ui.adapters.AlumnoAdapter
import com.lua.eventosunp.ui.fragments.CRUDS.AgregarAlumnoDialogFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class FragmentAlumnos : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var repos: AlumnosRepos

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         repos = AlumnosRepos()
        val view = inflater.inflate(R.layout.fragment_alumnos, container, false)
        recyclerView = view.findViewById(R.id.recyclerViewAlumnos)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val btnAgregarAlumno = view.findViewById<Button>(R.id.btnAgregarAlumno)
        btnAgregarAlumno.setOnClickListener {
            mostrarDialogoAgregarAlumno()
        }
        return view
    }


    private fun mostrarDialogoAgregarAlumno() {
        val dialog = AgregarAlumnoDialogFragment()
        dialog.setTargetFragment(this, 0) // Establecer fragmento como objetivo para recibir resultados
        dialog.show(requireActivity().supportFragmentManager, "AgregarAlumnoDialogFragment")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cargarAlumnos()
    }

    private fun cargarAlumnos() {
        CoroutineScope(Dispatchers.Main).launch {
            val alumnos = withContext(Dispatchers.IO) { repos.getAlumnos() }
            recyclerView.adapter = AlumnoAdapter(alumnos)
        }
    }


    private fun eliminarAlumno(alumno: Alumno) {
        CoroutineScope(Dispatchers.Main).launch {
            withContext(Dispatchers.IO) { repos.eliminarAlumno(alumno) }
            cargarAlumnos()
        }
    }

}

