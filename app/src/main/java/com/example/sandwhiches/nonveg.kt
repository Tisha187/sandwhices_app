package com.example.sandwhiches

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.sandwhiches.databinding.FragmentNonvegBinding
import com.example.sandwhiches.model.OrderViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class nonveg : Fragment() {
    // TODO: Rename and change types of parameters
   private var binding:FragmentNonvegBinding?=null
    private val sharedViewModel: OrderViewModel by activityViewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var Fragmentbinding=FragmentNonvegBinding.inflate(inflater,container,false)
        binding= Fragmentbinding
        return Fragmentbinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            lifecycleOwner=viewLifecycleOwner
            viewModel=sharedViewModel
            nextbtn.setOnClickListener { orderSandwhiches()}
        }
    }

    fun orderSandwhiches(){
        findNavController().navigate(R.id.action_nonveg_to_pickup)

    }



}