package com.example.chinkuanlin_newsapi

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import android.util.Log
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.chinkuanlin_newsapi.databinding.FragmentHcontentBinding
import com.example.chinkuanlin_newsapi.databinding.ListItemArticleBinding
import com.example.chinkuanlin_newsapi.Constants.Companion.TYPE_HEADLINE
import com.example.chinkuanlin_newsapi.Constants.Companion.TYPE_BUSINESS
import com.example.chinkuanlin_newsapi.Constants.Companion.TYPE_SPORTS



class HeadlineArticleHolder(private val binding: ListItemArticleBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(article: Article) {

        Log.d("HOLDER", "Binding article: ${article.title}")
        binding.articleTitle.text = article.title
        binding.articleDate.text = article.publishedAt
        binding.root.setOnClickListener { view ->
            // Navigate using the action defined in the navigation graph

            val action = HeadlineFragmentDirections.actionHeadlineFragmentToHcontentFragment(article.title, article.content)
            view.findNavController().navigate(action)
        }

    }
}

class BusinessArticleHolder(private val binding: ListItemArticleBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(article: Article) {
        binding.articleTitle.text = article.title
        binding.articleDate.text = article.publishedAt

        binding.root.setOnClickListener { view ->
            // Navigate using the action defined in the navigation graph

            val action = BusinessFragmentDirections.actionBusinessFragmentToBcontentFragment(article.title, article.content)
            view.findNavController().navigate(action)
        }
    }
}

class SportsArticleHolder(private val binding: ListItemArticleBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(article: Article) {
        binding.articleTitle.text = article.title
        binding.articleDate.text = article.publishedAt

        binding.root.setOnClickListener { view ->
            // Navigate using the action defined in the navigation graph

            val action = SportsFragmentDirections.actionSportsFragmentToScontentFragment(article.title, article.content)
            view.findNavController().navigate(action)
        }
    }
}


//private val articles: LiveData<List<Article>>
class ArticleListAdapter() :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var list = ArrayList<Article>()
    private var articles: List<Article> = listOf()
    private var currentFragmentType: Int = TYPE_HEADLINE


    fun setArticles(articles: List<Article>) {
        Log.d("ADAPTER", "Updating articles in adapter: ${articles.size}")
        this.articles = articles
        notifyDataSetChanged()
    }
    fun setCurrentFragmentType(type: Int) {
        currentFragmentType = type
        notifyDataSetChanged() // 通知数据变化，重新绑定 ViewHolder
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemArticleBinding.inflate(inflater, parent, false)
        return when (currentFragmentType) {
            TYPE_HEADLINE -> {
                val binding = ListItemArticleBinding.inflate(inflater, parent, false)
                HeadlineArticleHolder(binding)
            }
            TYPE_BUSINESS -> {
                val binding = ListItemArticleBinding.inflate(inflater, parent, false)
                BusinessArticleHolder(binding)
            }
            TYPE_SPORTS -> {
                val binding = ListItemArticleBinding.inflate(inflater, parent, false)
                SportsArticleHolder(binding)
            }
            else -> throw IllegalStateException("Unsupported fragment type")
        }
        //return HeadlineArticleHolder(binding)
//        if(viewType == 1){
//            return HeadlineArticleHolder(binding)
//        }
//        else if(viewType == 2) {
//            return HeadlineArticleHolder(binding)
//            //return BusinessArticleHolder(binding)
//        }
//        else {
//            return SportsArticleHolder(binding)
//        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val article = articles[position]

        if(holder is HeadlineArticleHolder){
            holder.bind(article)
        }
        else if(holder is BusinessArticleHolder){
            holder.bind(article)
        }
        else if(holder is SportsArticleHolder){
            holder.bind(article)
        }

    }

//    override fun getItemViewType(position: Int): Int {
//        return articles[position].viewType
//    }

    override fun getItemCount() = articles.size
}