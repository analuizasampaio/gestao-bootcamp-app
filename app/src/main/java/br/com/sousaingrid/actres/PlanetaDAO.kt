package br.com.sousaingrid.actres

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


@Dao
interface PlanetaDAO {

    @Query("SELECT * FROM planetas where id=:id")
    fun getById(id: Long): Planeta?

    @Query("SELECT * FROM planetas" )
    fun findAll(): List<Planeta>

    @Insert
    fun insert(planeta: Planeta)

    @Delete
    fun delete(planeta: Planeta)
}