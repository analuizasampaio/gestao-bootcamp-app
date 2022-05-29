package br.com.sousaingrid.actres

import androidx.room.Room

object DatabaseManager {

    private val dbInstance: PLNTDatabase

    init{
        val contexto = PLANETApplication.getInstance().applicationContext

        dbInstance = Room.databaseBuilder(
            contexto,
            PLNTDatabase::class.java,
            "plnt.sqlite"
        ).build()
    }

    fun getPlanetaDAO(): PlanetaDAO {
        return  dbInstance.planenetaDAO()
    }
}