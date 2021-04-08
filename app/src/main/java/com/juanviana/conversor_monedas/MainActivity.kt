package com.juanviana.conversor_monedas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.juanviana.conversor_monedas.databinding.ActivityMainBinding
import java.util.logging.Logger.global

private lateinit var mainBinding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(R.layout.activity_main)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)



        mainBinding.buttonConvertir.setOnClickListener {
            var moneda = mainBinding.spinnerConversor.selectedItem.toString()
            var cambio = mainBinding.spinnerReceptor.selectedItem.toString()
            var cantida = mainBinding.ingresoEt.text.toString()
            if (cantida.isEmpty()){
                Toast.makeText(this, getString(R.string.sin_valor),Toast.LENGTH_LONG).show()
            }
            else {
                conversor(moneda, cambio, cantida)
            }



        }


    }

    private fun conversor(moneda: String, cambio: String, cantida: String) {
        var car: Double= 1.0
        var cantidad= cantida.toFloat()
        if ((moneda == "Euro" && cambio == "Euro") || (moneda == "Dolar" && cambio == "Dolar")||(moneda == "Yen" && cambio == "Yen")||(moneda == "Libra" && cambio == "Libra")){
            mainBinding.ReceptorLayout.error= getString(R.string.error)
            mainBinding.ReceptorEt.setText(null)
        }
        else {
            mainBinding.ReceptorLayout.error= null
            if (moneda == "Euro" && cambio == "Dolar") {
                car = cantidad * 1.18
            } else if (moneda == "Euro" && cambio == "Yen") {
                car = cantidad * 129.30
            } else if (moneda == "Euro" && cambio == "Libra") {
                car = cantidad * 0.86
            } else if (moneda == "Dolar" && cambio == "Euro") {
                car = cantidad * 0.85
            } else if (moneda == "Dolar" && cambio == "Yen") {
                car = cantidad * 109.64
            } else if (moneda == "Dolar" && cambio == "Libra") {
                car = cantidad * 0.72
            } else if (moneda == "Yen" && cambio == "Dolar") {
                car = cantidad * 0.0091
            } else if (moneda == "Yen" && cambio == "Euro") {
                car = cantidad * 0.0077
            } else if (moneda == "Yen" && cambio == "Libra") {
                car = cantidad * 0.0066
            } else if (moneda == "Libra" && cambio == "Euro") {
                car = cantidad * 1.17
            } else if (moneda == "Libra" && cambio == "Dolar") {
                car = cantidad * 1.38
            } else if (moneda == "Libra" && cambio == "Yen") {
                car = cantidad * 151.20
            }
        }
        mainBinding.ReceptorEt.setText(car.toString())


    }
}