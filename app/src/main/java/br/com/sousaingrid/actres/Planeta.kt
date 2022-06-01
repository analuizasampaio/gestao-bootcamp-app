package br.com.sousaingrid.actres

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.GsonBuilder
import java.io.Serializable


@Entity(tableName = "planetas")
class Planeta : Serializable {

        @PrimaryKey
        var id:Long = 0
        var nome = ""
        var infoPlaneta = ""
        var foto = ""
        var planeta = ""

        override fun toString(): String {
            return "Planeta(nome='$nome')"
        }

        fun toJson(): String {
            return GsonBuilder().create().toJson(this)
        }
    }
