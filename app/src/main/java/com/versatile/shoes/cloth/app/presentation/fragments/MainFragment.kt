package com.versatile.shoes.cloth.app.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.versatile.shoes.cloth.app.R
import com.versatile.shoes.cloth.app.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnMenShoes.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_menShoesFragment)
        }
        binding.btnWomenShoes.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_womenShoesFragment)
        }
        binding.exit.setOnClickListener {
            requireActivity().finish()
        }
    }
}