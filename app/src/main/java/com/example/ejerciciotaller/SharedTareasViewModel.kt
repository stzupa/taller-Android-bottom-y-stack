package com.example.ejerciciotaller

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedTareasViewModel : ViewModel(){

    // Lista de objetos Tarea. LiveData notifica los cambios.
    private val _tareaList = MutableLiveData<MutableList<Tarea>>(mutableListOf())
    val tareasList: LiveData<MutableList<Tarea>> = _tareaList

    // Función que los Fragmentos llaman para añadir una Tarea
    fun addTask(name: String, description: String) {
        val nuevaTarea = Tarea(name, description)

        val listaActual = _tareaList.value ?: mutableListOf()
        listaActual.add(nuevaTarea)
        _tareaList.value = listaActual // Notifica a DashboardFragment que hay un cambio
    }
}