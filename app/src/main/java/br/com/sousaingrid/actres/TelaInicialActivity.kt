package br.com.sousaingrid.actres

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.ferfalk.simplesearchview.SimpleSearchView
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_tela_inicial.*
import kotlinx.android.synthetic.main.toolbar.*
import android.view.MenuItem as MenuItem


class TelaInicialActivity : DebugActivity(),
    NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)

        val args = intent.extras
        val nome = args?.getString("nome")
        val usuario = args?.getString("usuario")
        val n = args?.getString("n",)
        Toast.makeText(this, "Nome do usuário: $usuario; n: $n", Toast.LENGTH_LONG).show()

        setSupportActionBar(toolbar)

        supportActionBar?.title = "Página Inicial"

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        configuraMenuLateral()
        recyclerPlanetas?.layoutManager = LinearLayoutManager(this)
        recyclerPlanetas?.itemAnimator = DefaultItemAnimator()
        recyclerPlanetas?.setHasFixedSize(true)
    }

    fun taskPlanetas(){
        Thread {
            planetas = PlanetasService.getPlanetas(this)

            runOnUiThread{
                recyclerPlanetas?.adapter = PlanetaAdapter(planetas) {
                    onClickPlaneta(it)
                }
            }
        }.start()
    }

    private var planetas = listOf<Planeta>()
    override fun onResume() {
        super.onResume()
        taskPlanetas()
    }

    fun onClickPlaneta(planeta: Planeta) {
        Toast.makeText(this, "Clicou na ${planeta.nome}", Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)

        (menu?.findItem(R.id.action_buscar)?.actionView as SearchView?)?.setOnQueryTextListener(
            object : SearchView.OnQueryTextListener {
                override fun onQueryTextChange(p0: String?): Boolean {
                    return false
                }

                override fun onQueryTextSubmit(p0: String?): Boolean {
                    return false
                }
            })
        return true
    }




    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == R.id.action_buscar) {
            Toast.makeText(this,
                "Buscar",
                Toast.LENGTH_SHORT
            ).show()
        } else if (id == R.id.action_atualizar){
            Toast.makeText(this,
                "Atualizar",
                Toast.LENGTH_SHORT).show()
        } else if (id == R.id.action_config){
            Toast.makeText(this,
                "Configuração",
                Toast.LENGTH_SHORT).show()

            val intent = Intent(this,ConfiguracoesActivity::class.java)
            startActivity(intent)
        }else if (id==R.id.action_adicionar) {
            val intent = Intent(this, PlanetaCadastroActivity::class.java)
            startActivity(intent)

        }

        else if (id == android.R.id.home){
            finish()
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.nav_mercurio ->{
                Toast.makeText(this, "Mercurio",
                    Toast.LENGTH_SHORT).show()
            }
            R.id.nav_venus -> {
                Toast.makeText(this, "Venus",
                    Toast.LENGTH_SHORT).show()
            }
            R.id.nav_terra -> {
                Toast.makeText(this, "Terra",
                    Toast.LENGTH_SHORT).show()
            }
            R.id.nav_marte -> {
                Toast.makeText(this, "Marte",
                    Toast.LENGTH_SHORT).show()
            }
            R.id.nav_jupiter -> {
                Toast.makeText(this, "Jupiter",
                    Toast.LENGTH_SHORT).show()
            }
            R.id.nav_saturno -> {
                Toast.makeText(this, "Saturno",
                    Toast.LENGTH_SHORT).show()
            }
            R.id.nav_urano -> {
                Toast.makeText(this, "Urano",
                    Toast.LENGTH_SHORT).show()
            }
            R.id.nav_netuno -> {
                Toast.makeText(this, "Netuno",
                    Toast.LENGTH_SHORT).show()
            }
            R.id.nav_plutao -> {
                Toast.makeText(this, "Plutão",
                    Toast.LENGTH_SHORT).show()
            }
            R.id.nav_localizacao ->{
                Toast.makeText(this, "Localização",
                    Toast.LENGTH_SHORT).show()
            }
        }
        return true
    }
    private fun configuraMenuLateral(){
        var toogle = ActionBarDrawerToggle(
            this,
            layoutMenuLateral,
            toolbar,
            R.string.open,
            R.string.close
        )
        layoutMenuLateral.addDrawerListener(toogle)
        toogle.syncState()

        menu_lateral.setNavigationItemSelectedListener(this)
    }
}

private fun SimpleSearchView.setMenuItem(menuItem: List<Planeta>) {

}