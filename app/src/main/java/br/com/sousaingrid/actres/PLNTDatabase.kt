package br.com.sousaingrid.actres

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = arrayOf(Planeta::class), version = 1)

abstract class PLNTDatabase:RoomDatabase() {
    abstract fun planenetaDAO() : PlanetaDAO

}