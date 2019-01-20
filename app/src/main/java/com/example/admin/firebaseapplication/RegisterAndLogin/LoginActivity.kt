package com.example.admin.firebaseapplication.RegisterAndLogin

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.admin.firebaseapplication.Messages.LatestMessagesActivity
import com.example.admin.firebaseapplication.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar?.title = ""



        login_button_login.setOnClickListener {
            val email = email_login_page.text.toString()
            val password = password_login_page.text.toString()

            FirebaseAuth.getInstance().signInWithEmailAndPassword(email,password)
                .addOnCompleteListener{
                    val intent = Intent(this, LatestMessagesActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(intent)

                    if (!it.isSuccessful) return@addOnCompleteListener
                    Toast.makeText(this, "Success!", Toast.LENGTH_SHORT).show()
                    startActivity(intent)


                }
                .addOnFailureListener{
                    Toast.makeText(this, "Email or Password is incorrect!", Toast.LENGTH_SHORT).show()
                }
        }

        back_to_register_page.setOnClickListener {
            finish()
        }

    }

}