package br.com.sousaingrid.actres

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_planeta.*
import kotlinx.android.synthetic.main.toolbar.*

class PlanetaActivity : DebugActivity() {
    private val context: Context get() = this
    var planeta: Planeta? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planeta)

        planeta = intent.getSerializableExtra("planeta") as Planeta

        setSupportActionBar(toolbar)

        supportActionBar?.title = planeta?.nome

        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        nomePlaneta.text = planeta?.nome
        Picasso.with(this).load(planeta?.foto).fit().into(imagemPlaneta,
            object: com.squareup.picasso.Callback{
                override fun onSuccess() {}

                override fun onError() { }
            })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu_main_planeta, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val id = item?.itemId

        if  (id == R.id.action_remover) {

            AlertDialog.Builder(this)
                .setTitle(R.string.app_name)
                .setMessage("Deseja excluir a disciplina?")
                .setPositiveButton("Sim") {
                        dialog, which ->
                    dialog.dismiss()
                    taskExcluir()
                }.setNegativeButton("Não") {
                        dialog, which -> dialog.dismiss()
                }.create().show()
        }

        else if (id == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun taskExcluir() {
        if (this.planeta != null && this.planeta is Planeta) {

            Thread {
                PlanetasService.delete(this.planeta as Planeta)
                runOnUiThread {

                    finish()
                }
            }.start()
        }
    }

}