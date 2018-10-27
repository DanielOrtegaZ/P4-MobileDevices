package a3cv6.escom.ipn.mx.login

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var user : EditText
    private lateinit var pass : EditText
    private lateinit var session : User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        user = findViewById<EditText>(R.id.user)
        pass = findViewById<EditText>(R.id.password)
        session = User.instance
    }

    fun entrar(view:View?){

        val temp = user.text.toString()+pass.text.toString()

        if(!session.token.equals( temp.sha512())){
            Toast.makeText(this,"Credenciales Incorrectas",Toast.LENGTH_SHORT).show()

        } else {
            var intent = Intent(this,Perfil::class.java)
            startActivityForResult(intent,300)
        }
    }

    fun register(view:View?){

        val intentR = Intent(this,Registro::class.java)
        startActivityForResult(intentR,200)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode==200){

            if(resultCode==Activity.RESULT_OK){
                Toast.makeText(this,"User Created",Toast.LENGTH_SHORT).show()

            } else if(resultCode==Activity.RESULT_CANCELED){
                Toast.makeText(this,"User not Created",Toast.LENGTH_SHORT).show()

            } else{
                Toast.makeText(this,"RequestCode 200. ResultCode: " + resultCode.toString(),Toast.LENGTH_SHORT).show()
            }
        }
        else if(requestCode==300){

            if(resultCode==Activity.RESULT_CANCELED) {
                Toast.makeText(this,"Deleting Session",Toast.LENGTH_SHORT).show()

            } else {
                Toast.makeText(this,"RequestCode 300. ResultCode: " + resultCode.toString(),Toast.LENGTH_SHORT).show()
            }
        }
        else {
            Toast.makeText(this,"Unexpected Behave, RequestCode: " + requestCode.toString(),Toast.LENGTH_SHORT).show()
        }
    }
}