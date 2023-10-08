package com.example.sandwhiches

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.sandwhiches.databinding.FragmentTypeSandwhichBinding
import com.example.sandwhiches.model.OrderViewModel


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [type_sandwhich.newInstance] factory method to
 * create an instance of this fragment.
 */
class type_sandwhich : Fragment() {
    private  var binding: FragmentTypeSandwhichBinding?=null
    private val sharedViewModel: OrderViewModel by activityViewModels()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       var fragmentbinding=FragmentTypeSandwhichBinding.inflate(inflater,container,false)
        binding=fragmentbinding
        return fragmentbinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            lifecycleOwner=viewLifecycleOwner
            viewModel=sharedViewModel

            nextbtn.setOnClickListener {
                if(sharedViewModel.hasNoFlavourset()){
                    sharedViewModel.setFlavor(getString(R.string.option1))
                }
                findNavController().navigate(R.id.action_type_sandwhich_to_pickup)
            }
        }
    }



}