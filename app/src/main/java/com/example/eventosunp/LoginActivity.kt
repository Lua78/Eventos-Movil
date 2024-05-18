

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.eventosunp.R


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        buttonLogin.setOnClickListener {
            val username = editTextUsername.text.toString()
            val password = editTextPassword.text.toString()

            // Aquí deberías agregar la lógica para autenticar al usuario
            // Puedes utilizar Retrofit para enviar la solicitud de inicio de sesión al servidor

            // Por ahora, simplemente vamos a mostrar un mensaje de éxito
            Toast.makeText(this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show()

            // Después del inicio de sesión exitoso, navega a la actividad principal
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Esto cierra la actividad actual (LoginActivity) para evitar que el usuario regrese
        }
    }
}