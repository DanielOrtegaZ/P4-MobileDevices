package a3cv6.escom.ipn.mx.login

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Perfil : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)

        val name : TextView = findViewById<TextView>(R.id.nombre)
        val session = User.instance
        name.text = "Bienvenido " + session.name;
    }

}
