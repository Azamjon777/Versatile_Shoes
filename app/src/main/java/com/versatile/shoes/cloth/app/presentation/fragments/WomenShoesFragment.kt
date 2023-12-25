package com.versatile.shoes.cloth.app.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.versatile.shoes.cloth.app.R
import com.versatile.shoes.cloth.app.databinding.FragmentWomenShoesBinding
import com.versatile.shoes.cloth.app.presentation.adapter.ShoesItemsAdapter
import com.versatile.shoes.cloth.app.presentation.model.ShoesModel

class WomenShoesFragment : Fragment() {
    private lateinit var binding: FragmentWomenShoesBinding
    private lateinit var shoesItemsAdapter: ShoesItemsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWomenShoesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnBoardingItems()

        val btnNext = binding.btnNext
        val btnPrevious = binding.btnPrevious

        btnNext.setOnClickListener {
            navigateViewPager(1)
        }

        btnPrevious.setOnClickListener {
            navigateViewPager(-1)
        }
    }

    private fun setOnBoardingItems() {
        shoesItemsAdapter = ShoesItemsAdapter(
            listOf(
                ShoesModel(R.drawable.women1, getString(R.string.title_women_1)),
                ShoesModel(R.drawable.women2, getString(R.string.title_women_2)),
                ShoesModel(R.drawable.women1, getString(R.string.title_women_3)),
                ShoesModel(R.drawable.women1, getString(R.string.title_women_4)),
                ShoesModel(R.drawable.women1, getString(R.string.title_women_5)),
                ShoesModel(R.drawable.women1, getString(R.string.title_women_6)),
                ShoesModel(R.drawable.women1, getString(R.string.title_women_7)),
                ShoesModel(R.drawable.women1, getString(R.string.title_women_8)),
                ShoesModel(R.drawable.women9, getString(R.string.title_women_9)),
                ShoesModel(R.drawable.women10, getString(R.string.title_women_10)),
                ShoesModel(R.drawable.women11, getString(R.string.title_women_11)),
                ShoesModel(R.drawable.women12, getString(R.string.title_women_12)),
                ShoesModel(R.drawable.women13, getString(R.string.title_women_13)),
                ShoesModel(R.drawable.women14, getString(R.string.title_women_14)),
                ShoesModel(R.drawable.women15, getString(R.string.title_women_15)),
            )
        )
        val onBoardingViewPager = binding.shoesViewPager
        onBoardingViewPager.adapter = shoesItemsAdapter
        (onBoardingViewPager.getChildAt(0) as RecyclerView).overScrollMode =
            RecyclerView.OVER_SCROLL_IF_CONTENT_SCROLLS
    }

    private fun navigateViewPager(direction: Int) {
        val currentItem = binding.shoesViewPager.currentItem
        val newIndex = currentItem + direction

        if (newIndex in 0 until shoesItemsAdapter.itemCount) {
            binding.shoesViewPager.currentItem = newIndex
        } else if (direction > 0) {
            navigateToHomeActivity()
        }
    }

    private fun navigateToHomeActivity() {
        Toast.makeText(requireActivity(), "This is the entire catalog", Toast.LENGTH_SHORT).show()
    }
}