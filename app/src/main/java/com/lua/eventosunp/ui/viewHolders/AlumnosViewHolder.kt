package com.lua.eventosunp.ui.viewHolders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.lua.eventosunp.data.modelos.Alumno
import com.lua.eventosunp.databinding.UsuarioLayoutBinding

class AlumnosViewHolder(private val binding: UsuarioLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(alumno: Alumno) {
        binding.tvNombre.text = alumno.Nombre
        binding.tvCarne.text = alumno.Carne
        binding.tvCorreo.text = alumno.correo
        binding.tvTelefono.text = alumno.telefono
        binding.tvDireccion.text = alumno.direccion
    }
}
