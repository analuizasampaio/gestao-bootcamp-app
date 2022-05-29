package br.com.sousaingrid.actres

import android.app.Application
import java.lang.IllegalStateException

class PLANETApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        appInstance = this
    }

    companion object {
        private var appInstance: PLANETApplication? = null

        fun getInstance(): PLANETApplication {
            if (appInstance == null){
                throw IllegalStateException("Configurar application")
            }
            return appInstance!!
        }
    }

}