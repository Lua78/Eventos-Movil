package com.lua.eventosunp.ui.fragments.CRUDS
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment
import com.lua.eventosunp.R

class EditarAlumnoDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return super.onCreateDialog(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.dialog_alumno, container, false)
        val btnCancelar = view.findViewById<Button>(R.id.btnCancelar)
        val btnAgregarAlumno = view.findViewById<Button>(R.id.btnGuardar)
        btnAgregarAlumno.setOnClickListener {

        }
        btnCancelar.setOnClickListener {

        }


        return view
    }
}
