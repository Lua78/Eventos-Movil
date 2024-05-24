package com.lua.eventosunp.data.modelos

data class Metadatos(
    val fieldCount: Int,
    val affectedRows: Int,
    val insertId: Int,
    val info: String,
    val serverStatus: Int,
    val warningStatus: Int,
    val changedRows: Int
)
