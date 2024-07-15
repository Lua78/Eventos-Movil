package com.lua.eventosunp.ui.fragments.CRUDS
import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.lifecycleScope
import com.lua.eventosunp.R
import com.lua.eventosunp.data.DTO.Alumno
import com.lua.eventosunp.ui.Repos.AlumnosRepos
import com.lua.eventosunp.ui.fragments.CRUDS.DTOs.AlumnoDto
import kotlinx.coroutines.launch

class AgregarAlumnoDialogFragment : DialogFragment() {
    private lateinit var etNombre: EditText
    private lateinit var etCarne: EditText
    private lateinit var etDireccion: EditText
    private lateinit var etTelefono: EditText
    private lateinit var etFecNac: EditText
    private lateinit var etCorreo: EditText
    private lateinit var etCarrera: EditText
    private lateinit var etIngreso: EditText

    private val alumnosRepos:AlumnosRepos = AlumnosRepos()
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return super.onCreateDialog(savedInstanceState)
    }

    @SuppressLint("CutPasteId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.dialog_alumno, container, false)
        val btnCancelar = view.findViewById<Button>(R.id.btnCancelar)
        val btnAgregarAlumno = view.findViewById<Button>(R.id.btnGuardar)
        etNombre = view.findViewById(R.id.etNombre)
        etCarne = view.findViewById(R.id.etCarne)
        etCorreo = view.findViewById(R.id.etCorreo)
        etDireccion = view.findViewById(R.id.etDireccion)
        etFecNac = view.findViewById(R.id.etFecNac)
        etTelefono = view.findViewById(R.id.etTelefono)
        etIngreso = view.findViewById(R.id.etTelefono)
        etCarrera = view.findViewById(R.id.etTelefono)

        btnAgregarAlumno.setOnClickListener {
            dismiss()
        }
        btnCancelar.setOnClickListener {
            guardarAlumno()
            dismiss()
        }
        return view
    }
    private fun guardarAlumno() {
        val nombre = etNombre.text.toString().trim()
        val carne = etCarne.text.toString().trim()
        val correo = etCorreo.text.toString().trim()
        val direccion = etDireccion.text.toString().trim()
        val fechaNac = etFecNac.text.toString().trim()
        val telefono = etTelefono.text.toString().trim()
        val ingreso = etIngreso.text.toString().trim()
        val carrera = etCarrera.text.toString().trim()

        val alumno = AlumnoDto(carne,fechaNac,nombre, ingreso.toInt(), correo,direccion,carrera.toInt(), telefono)
        lifecycleScope.launch {
            alumnosRepos.agregarAlumno(alumno)
        }


    }
}
