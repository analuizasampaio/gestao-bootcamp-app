package br.com.sousaingrid.actres

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.login.*


class MainActivity : DebugActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        imagemLogin.setImageResource(R.drawable.imagem_login)
        mensagemLogin.text = "Nova mensagem de Login"

        botaoLogin.setOnClickListener{

            val valorUsuario = campoUsuario.text.toString()
            val senhaUsuario = campoSenha.text.toString()
            Toast.makeText(this, "Nome do usuário: ${valorUsuario}", Toast.LENGTH_LONG).show()

            val intent = Intent(this, TelaInicialActivity::class.java)
            val params = Bundle()
            params.putString("usuario", valorUsuario)
            params.putInt("n", 10)
            params.putBoolean("bool", true)

            intent.putExtras(params)

            intent.putExtra("nome", "Ingrid Sousa")

            startActivity(intent)
        }
    }
}