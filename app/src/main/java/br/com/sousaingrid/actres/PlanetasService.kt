package br.com.sousaingrid.actres

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URL

object PlanetasService {

    val host = "https://apiplanet.ingridpriscila.repl.co"
    val TAG ="WS_PLANETAapp"

    fun getPlanetas(context: Context):List<Planeta> {


        val url = "$host/planetas"
        val json = HttpHelper.get(url)
        Log.d(TAG, json)

        return parserJson<List<Planeta>>(json)
    }

    fun savePlaneta(planeta: Planeta) {
        var url = "$host/planetas"
        HttpHelper.post(url, planeta.toJson())
    }

    inline fun <reified T> parserJson(json: String): T {
        val type = object: TypeToken<T>(){}.type
        return Gson().fromJson<T>(json, type)
    }

}