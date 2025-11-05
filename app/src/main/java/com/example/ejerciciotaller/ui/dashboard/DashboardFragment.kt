package com.example.ejerciciotaller.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.ejerciciotaller.SharedTareasViewModel
import com.example.ejerciciotaller.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var sharedViewModel: SharedTareasViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        sharedViewModel = ViewModelProvider(requireActivity()).get(SharedTareasViewModel::class.java)
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 2. CONEXIÓN DEL BOTÓN
        binding.btnAgregarTarea.setOnClickListener {

            // a. Obtener los valores de los EditText
            val taskName = binding.inputTextNombreTarea.text.toString().trim()
            val taskDescription = binding.inputTextDescrpcionTarea.text.toString().trim()

            if (taskName.isNotEmpty()) {

                // b. ENVIAR LOS DATOS al ViewModel COMPARTIDO
                sharedViewModel.addTask(taskName, taskDescription)

                // c. Feedback y limpieza de campos
                Toast.makeText(context, "Tarea '$taskName' guardada!", Toast.LENGTH_SHORT).show()
                binding.inputTextNombreTarea.setText("")
                binding.inputTextDescrpcionTarea.setText("")

            } else {
                Toast.makeText(context, "Por favor, escribe un nombre de tarea.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    /*override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        /*val textView: TextView = binding.textDashboard
        dashboardViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }*/
        return root
    */

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}