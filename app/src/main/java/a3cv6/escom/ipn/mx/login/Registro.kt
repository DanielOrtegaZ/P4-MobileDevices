package a3cv6.escom.ipn.mx.login

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import java.security.MessageDigest

class Registro : AppCompatActivity() {

    private lateinit var userR : EditText
    private lateinit var nameR : EditText
    private lateinit var passR : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        userR = findViewById<EditText>(R.id.userR)
        nameR = findViewById<EditText>(R.id.nameR)
        passR = findViewById<EditText>(R.id.passR)
    }

    fun aceptar(view: View?){

        var user = User.instance
        user.token = (userR.text.toString()+passR.text.toString()).sha512()
        user.name = nameR.text.toString()

        setResult(Activity.RESULT_OK)
        finish()
    }

    fun cancel(view:View?){
        setResult(Activity.RESULT_CANCELED)
        finish()
    }
}