package br.com.sousaingrid.actres

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.login.*


class MainActivity : DebugActivity() {

    private val context: Context get() = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)


        var nomeUsuario = Prefs.getString("nome")
        campoUsuario.setText(Prefs.getString("nome"))
        campoSenha.setText(Prefs.getString("senha"))
        lembrarSenha.isChecked = Prefs.getBoolean("lembrar")!!

        texto_usuario.text ="Olá $nomeUsuario"


            botaoLogin.setOnClickListener{onClickLogin() }


    }

    fun onClickLogin() {
        val valorUsuario = campoUsuario.text.toString()
        val valorSenha =  campoSenha.text.toString()

        if (lembrarSenha.isChecked) {
            Prefs.setString("nome", valorUsuario)
            Prefs.setString("senha", valorSenha)
        } else {
            Prefs.setString("nome", "")
            Prefs.setString("senha", "")
        }

        Prefs.setBoolean("lembrar", lembrarSenha.isChecked)

        val intent = Intent(context, TelaInicialActivity::class.java)
        val params = Bundle()
        params.putString("nome", "Ingrid Sousa")
        intent.putExtras(params)

        intent.putExtra("numero", 10)



        startActivityForResult(intent, 1)

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val result = data?.getStringExtra("result")
        Toast.makeText(context, "$result", Toast.LENGTH_LONG).show()
    }
    }
