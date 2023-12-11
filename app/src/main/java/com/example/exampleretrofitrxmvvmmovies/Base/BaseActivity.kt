package com.example.exampleretrofitrxmvvmmovies.Base

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

@SuppressLint("Registered")
open class BaseActivity: AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.mContext = this
    }

    // Método para reemplazar el fragmento actual con otro
    fun showFragment(fragment: Fragment, rutaContenedor:Int) {
        supportFragmentManager.beginTransaction()
            .replace(rutaContenedor, fragment)
            .commit()
    }

    fun navigationEntreFragment(rutaContenedor:Int, etiqueta:String? = null, fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(rutaContenedor, fragment)
            .addToBackStack(etiqueta)
            .commit()
    }
}