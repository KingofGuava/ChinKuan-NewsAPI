package com.example.chinkuanlin_newsapi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.navigation.findNavController
import com.example.chinkuanlin_newsapi.databinding.FragmentHeadlineBinding
import com.example.chinkuanlin_newsapi.Constants.Companion.API_KEY
import com.example.chinkuanlin_newsapi.Constants.Companion.TYPE_HEADLINE


private const val TAG = "HeadlineFragment"


class HeadlineFragment : Fragment() {

    private var _binding: FragmentHeadlineBinding? = null

    private val binding

        get() = checkNotNull(_binding) {
            "Cannot access binding because it is null. Is the view visible?"
        }
    private lateinit var articleListViewModel: ArticleListViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate( savedInstanceState)
        //Log.d(TAG, "Total articles: ${articleListViewModel.articles.size()}")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        articleListViewModel = ViewModelProvider(this).get(ArticleListViewModel::class.java)

        // Inflate the layout for this fragment
        _binding = FragmentHeadlineBinding.inflate(inflater, container, false)
        binding.buttonHeadlineToBusiness.setOnClickListener {
            it.findNavController().navigate(R.id.action_headlineFragment_to_businessFragment)
        }
        binding.buttonHeadlineToSports.setOnClickListener {
            it.findNavController().navigate(R.id.action_headlineFragment_to_sportsFragment)
        }


        binding.articleRecyclerView.layoutManager = LinearLayoutManager(context)

        val  adapter = ArticleListAdapter()
        adapter.setCurrentFragmentType(TYPE_HEADLINE)
        binding.articleRecyclerView.adapter = adapter

        articleListViewModel.articles.observe(viewLifecycleOwner, Observer { articles ->
            adapter.setArticles(articles)
        })

        articleListViewModel.fetchTopHeadlines(API_KEY)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}