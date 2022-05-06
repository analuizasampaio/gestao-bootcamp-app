package br.com.sousaingrid.actres

object PlanetasService {

    fun getPlanetas():List<Planetas> {
        val planetas = mutableListOf<Planetas>()

        for (i in 1..1){
            val m = Planetas()
            m.nome = "Mercurio $i"
            m.ementa = "Mercurio $i"
            m.planeta = "Mercurio $i"
            m.foto = "https://static.mundoeducacao.uol.com.br/mundoeducacao/conteudo_legenda/e8a8426182d5c9d3ce5d4d6e6358b128.jpg"

            planetas.add(m)

            val v = Planetas()
            v.nome = "Venus $i"
            v.ementa = "Venus $i"
            v.planeta = "Venus $i"
            v.foto = "https://static.mundoeducacao.uol.com.br/mundoeducacao/conteudo_legenda/f5c821353c57b50225cda29678232840.jpg"

            planetas.add(v)

            val t = Planetas()
            t.nome = "Terra $i"
            t.ementa = "Terra $i"
            t.planeta = "Terra $i"
            t.foto = "https://static.todamateria.com.br/upload/pl/an/planeta-terra-og.jpg"

            planetas.add(t)

            val ma = Planetas()
            ma.nome = "Marte $i"
            ma.ementa = "Marte $i"
            ma.planeta = "Marte $i"
            ma.foto = "https://s1.static.brasilescola.uol.com.br/be/2021/11/planeta-marte.jpg"

            planetas.add(ma)

            val j = Planetas()
            j.nome = "Jupiter $i"
            j.ementa = "Jupiter $i"
            j.planeta = "Jupiter$i"
            j.foto = "https://www.istoedinheiro.com.br/wp-content/uploads/sites/17/2021/12/jupter.jpg"

            planetas.add(j)

            val s = Planetas()
            s.nome = "Saturno $i"
            s.ementa = "Saturno $i"
            s.planeta = "Saturno $i"
            s.foto = "https://revistapesquisa.fapesp.br/wp-content/uploads/2019/11/285_miniatura9.jpg"

            planetas.add(s)

            val u = Planetas()
            u.nome = "Urano $i"
            u.ementa = "Urano $i"
            u.planeta = "Urano $i"
            u.foto = "https://static.todamateria.com.br/upload/55/2c/552c107117c37-planeta-urano-medium.jpg"

            planetas.add(u)

            val  n = Planetas()
            n.nome = "Netuno $i"
            n.ementa = "Netuno $i"
            n.planeta = "Netuno $i"
            n.foto = "https://static.mundoeducacao.uol.com.br/mundoeducacao/conteudo_legenda/3fbe97289a4a39391468549c02ef37b9.jpg"

            planetas.add(n)

            val  p = Planetas()
            p.nome = "Plutão é planeta sim! $i"
            p.ementa = "Plutão é planeta sim $i"
            p.planeta = "Plutão é planeta sim $i"
            p.foto = "https://tm.ibxk.com.br/2019/09/02/02150335926075.jpg?ims=1200x675"

            planetas.add(p)
        }
        return planetas
    }

}