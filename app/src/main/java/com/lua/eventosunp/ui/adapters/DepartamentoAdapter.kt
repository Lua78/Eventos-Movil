package com.lua.eventosunp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lua.eventosunp.data.DTO.Alumno
import com.lua.eventosunp.ui.viewHolders.AlumnosViewHolder
import com.lua.eventosunp.databinding.UsuarioLayoutBinding


class DepartamentoAdapter(private val alumnos: List<Alumno>) : RecyclerView.Adapter<AlumnosViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlumnosViewHolder {
        val view = UsuarioLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AlumnosViewHolder(view)
    }

    override fun onBindViewHolder(holder: AlumnosViewHolder, position: Int) {
        val item = alumnos[position]
        holder.bind(alumnos[position])
    }

    override fun getItemCount(): Int = alumnos.size


}
