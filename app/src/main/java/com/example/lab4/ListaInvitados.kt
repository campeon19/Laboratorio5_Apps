package com.example.lab4

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.lab4.databinding.FragmentListaInvitadosBinding
import kotlinx.android.synthetic.main.fragment_lista_invitados.view.*

/**
 * A simple [Fragment] subclass.
 */
class ListaInvitados : Fragment() {
    private lateinit var binding: FragmentListaInvitadosBinding
    private lateinit var lista: Lista
    private var invitados = 5
    private var confirmados = 0
    private var interador = 0
    private lateinit var root: View

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.opciones_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.No_buttom -> {
                (activity as MainActivity).invList.get(interador).presente = true
                interador++
                if (interador <= (activity as MainActivity).invList.size - 1) {
                    root.nombre_edit.text = (activity as MainActivity).invList.get(interador).nombre
                    root.telefono_edit.text =
                        (activity as MainActivity).invList.get(interador).telefono
                    root.email_edit.text = (activity as MainActivity).invList.get(interador).email
                    (activity as MainActivity).cambiarTitulo("Registrados" + (interador + 1).toString() + "/" + (activity as MainActivity).invList.size.toString())

                } else {
                    view?.findNavController()?.navigate(R.id.action_listaInvitados2_to_resultados)
                }
            }

            R.id.Si_buttom -> {
                (activity as MainActivity).invList.get(interador).presente = false
                interador++
                if (interador <= (activity as MainActivity).invList.size - 1) {
                    root.nombre_edit.text = (activity as MainActivity).invList.get(interador).nombre
                    root.telefono_edit.text =
                        (activity as MainActivity).invList.get(interador).telefono
                    root.email_edit.text = (activity as MainActivity).invList.get(interador).email
                    (activity as MainActivity).cambiarTitulo("Registrados" + (interador + 1).toString() + "/" + (activity as MainActivity).invList.size.toString())

                } else {
                    view?.findNavController()?.navigate(R.id.action_listaInvitados2_to_resultados)
                }

            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentListaInvitadosBinding>(
            inflater,
            R.layout.fragment_lista_invitados,
            container,
            false
        )

        (activity as MainActivity).invList = listOf<Lista>(
            Lista("Pedro Lopez", "3759-4558", "pedro.lopez25@gmail.com", false),
            Lista("Maria Rodriguez", "6887-9523", "rodriguezmaria38@gmail.com", false),
            Lista("Luisa Gallegos", "4280-2135", "gallegosluisa@gmail.com", false),
            Lista("Edward Paiz", "3862-1544", "edward1985.paiz@outlook.com", false),
            Lista("Jose Luis Perez", "4798-5591", "joseluis95@yopmail.com", false),
            Lista("Alberto Hernandez", "3887-8798", "alberto.hern.1990@gmail.com", false)

        )

        root.nombre_edit.text = (activity as MainActivity).invList.get(interador).nombre
        root.telefono_edit.text = (activity as MainActivity).invList.get(interador).telefono
        root.email_edit.text = (activity as MainActivity).invList.get(interador).email
        (activity as MainActivity).cambiarTitulo("Registrados" + (interador + 1).toString() + "/" + (activity as MainActivity).invList.size.toString())

        return binding.root
    }
}