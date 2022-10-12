package com.example.apptravel.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.apptravel.R
import com.example.apptravel.adapter.trip.BookmarkAdapter
import com.example.apptravel.databinding.FragmentBookmarksBinding
import com.example.apptravel.domain.model.AllTravelItem
import com.example.apptravel.viewmodel.BookmarkViewModel


class BookmarksFragment : Fragment() {
    private lateinit var binding: FragmentBookmarksBinding
    private val viewModel: BookmarkViewModel by viewModels()
    private var adapter: BookmarkAdapter = BookmarkAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_bookmarks,
            container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
    }

    private fun init() {
        context?.let {

        }
        getBookmarks()
    }



    private fun getBookmarks() {
        viewModel.getBookmarkData().observe(viewLifecycleOwner) { bookmarksValue ->
            adapter.setBookmarkArrayList(bookmarksValue)
            val gridLayoutManager =
                GridLayoutManager(context, 1, GridLayoutManager.VERTICAL, false)
            binding.recyclerViewHorizantal.layoutManager = gridLayoutManager
            binding.recyclerViewHorizantal.adapter = adapter
        }
    }



}
