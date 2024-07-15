package com.lua.eventosunp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lua.eventosunp.R
import com.lua.eventosunp.ui.Repos.AlumnosRepos
import com.lua.eventosunp.ui.Repos.CategoriasRepos
import com.lua.eventosunp.ui.adapters.AlumnoAdapter
import com.lua.eventosunp.ui.adapters.CategoriaAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class FragmentCategorias : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var repos: CategoriasRepos

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         repos = CategoriasRepos()
        val view = inflater.inflate(R.layout.fragment_categorias, container, false)
        recyclerView = view.findViewById(R.id.recyclerViewCategorias)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cargarCategorias()
    }

    private fun cargarCategorias() {
        CoroutineScope(Dispatchers.Main).launch {
            val categorias = withContext(Dispatchers.IO) { repos.getCategorias() }
            recyclerView.adapter = CategoriaAdapter(categorias)
        }
    }

}

