package com.lua.eventosunp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lua.eventosunp.data.DTO.Alumno
import com.lua.eventosunp.data.DTO.Categoria
import com.lua.eventosunp.databinding.CategoriaLayoutBinding
import com.lua.eventosunp.ui.viewHolders.AlumnosViewHolder
import com.lua.eventosunp.databinding.UsuarioLayoutBinding
import com.lua.eventosunp.ui.viewHolders.CategoriasViewHolder


class CategoriaAdapter(private val items: List<Categoria>) : RecyclerView.Adapter<CategoriasViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriasViewHolder {
        val view = CategoriaLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoriasViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoriasViewHolder, position: Int) {
        val item = items[position]
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size


}
