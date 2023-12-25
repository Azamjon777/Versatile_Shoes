package com.versatile.shoes.cloth.app.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.versatile.shoes.cloth.app.R
import com.versatile.shoes.cloth.app.databinding.FragmentMenShoesBinding
import com.versatile.shoes.cloth.app.presentation.adapter.ShoesItemsAdapter
import com.versatile.shoes.cloth.app.presentation.model.ShoesModel

class MenShoesFragment : Fragment() {
    private lateinit var binding: FragmentMenShoesBinding
    private lateinit var shoesItemsAdapter: ShoesItemsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMenShoesBinding.inflate(inflater, container, false)
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
                ShoesModel(R.drawable.men1, getString(R.string.title1)),
                ShoesModel(R.drawable.men2, getString(R.string.title2)),
                ShoesModel(R.drawable.men3, getString(R.string.title3)),
                ShoesModel(R.drawable.men4, getString(R.string.title4)),
                ShoesModel(R.drawable.men5, getString(R.string.title5)),
                ShoesModel(R.drawable.men6, getString(R.string.title6)),
                ShoesModel(R.drawable.men7, getString(R.string.title7)),
                ShoesModel(R.drawable.men8, getString(R.string.title8)),
                ShoesModel(R.drawable.men9, getString(R.string.title9)),
                ShoesModel(R.drawable.men10, getString(R.string.title10)),
                ShoesModel(R.drawable.men11, getString(R.string.title11)),
                ShoesModel(R.drawable.men12, getString(R.string.title12)),
                ShoesModel(R.drawable.men13, getString(R.string.title13)),
                ShoesModel(R.drawable.men14, getString(R.string.title14)),
                ShoesModel(R.drawable.men15, getString(R.string.title15)),
                ShoesModel(R.drawable.men16, getString(R.string.title16)),
                ShoesModel(R.drawable.men17, getString(R.string.title17)),
                ShoesModel(R.drawable.men18, getString(R.string.title18))
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