package com.coder178.todayheadlines

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class NewsAdapter(val context:Context,val articles:List<Article>,private val listner:newsItemClciked):RecyclerView.Adapter<NewsAdapter.ArticleViewHolder>(){

    class ArticleViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var newsImage = itemView.findViewById<ImageView>(R.id.newsImage)
        var newsTitle = itemView.findViewById<TextView>(R.id.newsTitle)
        var newsDescription = itemView.findViewById<TextView>(R.id.newsDescription)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false)
        val viewHolder = ArticleViewHolder(view)
        view.setOnClickListener {
            listner.onItemClicked(articles[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {

        val article :Article = articles[position]
        holder.newsTitle.text = article.title
        holder.newsDescription.text = article.description
        Glide.with(context).load(article.urlToImage).into(holder.newsImage)

    }

    override fun getItemCount(): Int {
        return articles.size
    }

}

interface newsItemClciked{
    fun onItemClicked(item: Article)
}