package com.example.ejerciciotaller

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ejerciciotaller.databinding.ItemTareaBinding

// El Adaptador ahora maneja una lista de objetos Tarea
class TareasAdapter(private var tareas : List<Tarea>): RecyclerView.Adapter<TareasAdapter.TareaViewHolder>() {

    // El ViewHolder es el contenedor de las vistas de una fila
    inner class TareaViewHolder(val binding: ItemTareaBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TareaViewHolder {
        val binding = ItemTareaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TareaViewHolder(binding)
    }

    override fun getItemCount(): Int = tareas.size

    // Esta es la función CLAVE: asigna los datos de la Tarea al Layout
    override fun onBindViewHolder(holder: TareaViewHolder, position: Int) {
        val currentTarea = tareas[position]

        // Conexión: data.propiedad -> layout.TextView
        holder.binding.textTareaName.text = currentTarea.nombre_tarea
        holder.binding.textTareaDescription.text = currentTarea.descrpcion_tarea
    }

    // Función para que el Fragmento actualice la lista cuando cambia el ViewModel
    fun updateTareas(newTareas: List<Tarea>) {
        tareas = newTareas
        notifyDataSetChanged() // Refresca la lista
    }

}