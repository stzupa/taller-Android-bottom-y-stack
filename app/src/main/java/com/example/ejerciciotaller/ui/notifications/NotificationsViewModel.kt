package com.example.ejerciciotaller.ui.notifications

import android.R
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NotificationsViewModel : ViewModel() {

    /*private val _text = MutableLiveData<String>().apply {
        value = "Esta es la sección de Ajustes"
    }
    val text: LiveData<String> = _text*/

    private val _camaraText = MutableLiveData<String>().apply {
        value = "PARA USAR LA CÁMARA, DIRIGIRSE A AJUSTES DE CÁMARA"
    }

    val camaraText : LiveData<String> = _camaraText

    private val _microfonoText = MutableLiveData<String>().apply {
        value = "PARA USAR EL MICRÓFONO, DIRIGIRSE A AJUSTES DE MICRÓFONO"
    }

    val microfonoText : LiveData<String> = _microfonoText

    private val _ayudaText = MutableLiveData<String>().apply {
        value = "PARA AYUDA PRESIONA AYUDA"
    }

    val ayudaText : LiveData<String> = _ayudaText
}