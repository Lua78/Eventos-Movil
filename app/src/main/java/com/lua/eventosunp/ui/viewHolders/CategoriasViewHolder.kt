package com.lua.eventosunp.ui.viewHolders

import androidx.recyclerview.widget.RecyclerView
import com.lua.eventosunp.data.DTO.Categoria
import com.lua.eventosunp.databinding.CategoriaLayoutBinding

class CategoriasViewHolder(private val binding: CategoriaLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Categoria) {
        binding.tvNombre.text = item.Nombre
        binding.tvEstado.text = item.Estado.toString()
    }
}
