package com.example.sandwhiches

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.sandwhiches.databinding.FragmentSandwhichBinding
import com.example.sandwhiches.model.OrderViewModel


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SandwhichFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SandwhichFragment : Fragment() {
    private var binding: FragmentSandwhichBinding? = null
    private val sharedViewModel:OrderViewModel by activityViewModels()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var FragmentBinding = FragmentSandwhichBinding.inflate(inflater, container, false)
        binding = FragmentBinding
        return FragmentBinding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            lifecycleOwner=viewLifecycleOwner
            button1.setOnClickListener {
                findNavController().navigate(R.id.action_sandwhich_to_type_sandwhich)

            }
            button2.setOnClickListener {
                findNavController().navigate(R.id.action_sandwhich_to_nonveg)
            }
        }
    }


}





