package id.ac.pnm.katalogproduk

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login) // utk menampilkan halaman activity_login
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val editTextEmailAddress: EditText = findViewById<EditText>(R.id.editTextEmailAddress)
        val editTextPassword: EditText = findViewById<EditText>(R.id.editTextPassword)
        val buttonLogin: Button = findViewById<Button>(R.id.buttonLogin)

        //pakai lambda
        buttonLogin.setOnClickListener {
            val email: String = editTextEmailAddress.text.toString().trim()
            //val intentLoginToMain = Intent(this, MainActivity::class.java)
            val password: String = editTextPassword.text.toString().trim()
            //utk memvalidasi email harus diisi
            if (email.isEmpty()) {
                editTextEmailAddress.error = "Email harus diisi"
                Toast.makeText(this, "Email tidak boleh kosong", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            //utk mengecek format email valid
            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                editTextEmailAddress.error = "Format email tidak valid"
                editTextEmailAddress.requestFocus()
                return@setOnClickListener
            }

            //utk validasi password harus diisi
            if (password.isEmpty()) {
                editTextPassword.error = "Password harus diisi"
                Toast.makeText(this, "Password tidak boleh kosong", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this, MainActivity::class.java)
            //intentLoginToMain.putExtra("username", email)
            intent.putExtra(KEY_USERNAME, email)
            startActivity(intent)
            finish()
            //startActivity(intentLoginToMain)
            Toast.makeText(this, "Login Berhasil", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.buttonLogin -> {
                Toast.makeText(this, "Login Berhasil", Toast.LENGTH_SHORT).show()
            }
        }
        TODO("Not yet implemented")
    }

    companion object {
        const val KEY_USERNAME = "Username"
    }
}