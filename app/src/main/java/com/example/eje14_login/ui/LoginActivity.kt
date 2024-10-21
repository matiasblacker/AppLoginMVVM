// com/example/eje14_login/ui/LoginActivity.kt
package com.example.eje14_login.ui

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.eje14_login.R
import com.example.eje14_login.databinding.ActivityLoginBinding
import com.example.eje14_login.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.loginResult.observe(this) { result ->
            if (result) {
                /// Si el login es exitoso, se inicia la HomeActivity y se pasa el email
                val email = binding.emailInput.text.toString() // Obtener el email ingresado
                startActivity(Intent(this, HomeActivity::class.java).apply {
                    putExtra("EMAIL", email) // Pasar el email como extra
                })
                finish()
            } else {
                // Si el login falla, se muestra un mensaje
                val toastLayout = layoutInflater.inflate(R.layout.custom_toast, findViewById(R.id.toast_container))
                val toastMessage = toastLayout.findViewById<TextView>(R.id.toast_message)
                toastMessage.text = "La contraseña no coincide"  // Mensaje del Toast

                val toast = Toast(applicationContext)
                toast.duration = Toast.LENGTH_SHORT

                // Cambia la posición del Toast (por ejemplo, en la parte superior)
                toast.setGravity(Gravity.TOP or Gravity.CENTER_HORIZONTAL, 0, 100)  // (gravedad, xOffset, yOffset)
                toast.view = toastLayout
                toast.show()
            }
        }

        binding.loginButton.setOnClickListener {
            val email = binding.emailInput.text.toString()
            val password = binding.passwordInput.text.toString()
            viewModel.validateLogin(email, password)
        }
    }
}
