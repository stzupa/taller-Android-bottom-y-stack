package com.example.ejerciciotaller.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ejerciciotaller.SharedTareasViewModel
import com.example.ejerciciotaller.TareasAdapter
import com.example.ejerciciotaller.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var sharedViewModel: SharedTareasViewModel
    private lateinit var tareasAdapter: TareasAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // 1. INICIALIZACIÓN DEL VIEWMODEL COMPARTIDO (CLAVE)
        sharedViewModel = ViewModelProvider(requireActivity()).get(SharedTareasViewModel::class.java)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 2. CONFIGURACIÓN DEL RECYCLERVIEW Y EL ADAPTADOR
        tareasAdapter = TareasAdapter(emptyList())

        binding.recyclerViewTareas.apply { // <-- EL ID ESTÁ EN fragment_home.xml
            layoutManager = LinearLayoutManager(context)
            adapter = tareasAdapter
        }

        // 3. OBSERVACIÓN DE DATOS (ESTO HACE QUE APAREZCA EN LA LISTA)
        sharedViewModel.tareasList.observe(viewLifecycleOwner) { listaDeTareas ->
            // Cuando hay un cambio en la lista, actualizamos el adaptador
            tareasAdapter.updateTareas(listaDeTareas)

            // Lógica para mostrar/ocultar el mensaje de lista vacía
            binding.textViewEmptyList.visibility = if (listaDeTareas.isEmpty()) View.VISIBLE else View.GONE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}