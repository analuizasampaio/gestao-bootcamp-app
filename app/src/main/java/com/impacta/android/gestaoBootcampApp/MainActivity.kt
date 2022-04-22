package com.impacta.android.gestaoBootcampApp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlinx.android.synthetic.main.login.*

class MainActivity : AppCompatActivity() {
    private val context: Context get() = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        campo_imagem.setImageResource(R.drawable.reprograma)
        texto_login.text = getString(R.string.mensagem_login)
        botao_login.setOnClickListener {onClickLogin() }
    }

    fun onClickLogin(){
        val valorUsuario = campo_usuario.text.toString()
        val valorSenha = campo_senha.text.toString()

        val intent = Intent(context, TelaInicialActivity::class.java)

        val params = Bundle()
        params.putString("nome", "Analu")
        intent.putExtras(params)


        intent.putExtra("numero", 10)

        startActivityForResult(intent, 1)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 1) {
            val result = data?.getStringExtra("result")
            Toast.makeText(context, "$result", Toast.LENGTH_LONG).show()
        }
    }
}