package com.coder178.todayheadlines

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.util.Log
import android.widget.TextView
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.LinearLayoutManager
import com.coder178.todayheadlines.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Response


class MainActivity : AppCompatActivity(),newsItemClciked {
    lateinit var adapter: NewsAdapter
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getNews()

        binding.topHeadline.setOnClickListener {
            getTopHeadlineNews()
        }
        binding.sports.setOnClickListener {
            getsportNews()
        }
        binding.business.setOnClickListener {
            getBusinessNews()
        }
        binding.entertainment.setOnClickListener {
            getEntertainmentNews()
        }
        binding.health.setOnClickListener {
            getHealthNews()
        }
        binding.science.setOnClickListener {
            getScienceNews()
        }
        binding.technology.setOnClickListener {
            getTechnologyNews()
        }
    }

    private fun getNews() {
        val news: retrofit2.Call<News> = NewsService.newsInstance.getHeadlines("in", 1)
        news.enqueue(object : retrofit2.Callback<News>, newsItemClciked {
            override fun onResponse(call: retrofit2.Call<News>, response: Response<News>) {
                val news: News? = response.body()
                if (news != null) {
                    Log.d("cheezycode", news.toString())
                    adapter = NewsAdapter(this@MainActivity, news.articles,this)
                    newsList.adapter = adapter
                    newsList.layoutManager = LinearLayoutManager(this@MainActivity)
                }
            }

            override fun onFailure(call: retrofit2.Call<News>, t: Throwable) {
                Log.d("cheezycode", "Error in fetching news")
            }

            override fun onItemClicked(item: Article) {

                val builder = CustomTabsIntent.Builder()
                val customTabIntent = builder.build()
                customTabIntent.launchUrl(this@MainActivity, Uri.parse(item.url))
            }
        })
    }


    private fun getTopHeadlineNews() {

        val news: retrofit2.Call<News> = NewsService.newsInstance.getHeadlines("in", 1)
        news.enqueue(object : retrofit2.Callback<News>, newsItemClciked {
            override fun onResponse(call: retrofit2.Call<News>, response: Response<News>) {
                val news: News? = response.body()
                if (news != null) {
                    Log.d("cheezycode", news.toString())
                    adapter = NewsAdapter(this@MainActivity, news.articles,this)
                    newsList.adapter = adapter
                    newsList.layoutManager = LinearLayoutManager(this@MainActivity)
                }
            }

            override fun onFailure(call: retrofit2.Call<News>, t: Throwable) {
                Log.d("cheezycode", "Error in fetching news")
            }

            override fun onItemClicked(item: Article) {

                val builder = CustomTabsIntent.Builder()
                val customTabIntent = builder.build()
                customTabIntent.launchUrl(this@MainActivity, Uri.parse(item.url))
            }
        })
    }

    private fun getsportNews() {

        val news: retrofit2.Call<News> = NewsService.newsInstance.getSports("in", "sports", 1)
        news.enqueue(object : retrofit2.Callback<News>, newsItemClciked {
            override fun onResponse(call: retrofit2.Call<News>, response: Response<News>) {
                val news: News? = response.body()
                if (news != null) {
                    Log.d("sports", news.toString())
                    adapter = NewsAdapter(this@MainActivity, news.articles,this)
                    newsList.adapter = adapter
                    newsList.layoutManager = LinearLayoutManager(this@MainActivity)
                }
            }

            override fun onFailure(call: retrofit2.Call<News>, t: Throwable) {
                Log.d("sports", "Error in fetching news")
            }

            override fun onItemClicked(item: Article) {

                val builder = CustomTabsIntent.Builder()
                val customTabIntent = builder.build()
                customTabIntent.launchUrl(this@MainActivity, Uri.parse(item.url))
            }
        })
    }


    private fun getTechnologyNews() {

        val news: retrofit2.Call<News> = NewsService.newsInstance.getSports("in", "technology", 1)
        news.enqueue(object : retrofit2.Callback<News>, newsItemClciked {
            override fun onResponse(call: retrofit2.Call<News>, response: Response<News>) {
                val news: News? = response.body()
                if (news != null) {
                    Log.d("sports", news.toString())
                    adapter = NewsAdapter(this@MainActivity, news.articles,this)
                    newsList.adapter = adapter
                    newsList.layoutManager = LinearLayoutManager(this@MainActivity)
                }
            }

            override fun onFailure(call: retrofit2.Call<News>, t: Throwable) {
                Log.d("sports", "Error in fetching news")
            }

            override fun onItemClicked(item: Article) {

                val builder = CustomTabsIntent.Builder()
                val customTabIntent = builder.build()
                customTabIntent.launchUrl(this@MainActivity, Uri.parse(item.url))
            }
        })
    }

    private fun getScienceNews() {

        val news: retrofit2.Call<News> = NewsService.newsInstance.getSports("in", "science", 1)
        news.enqueue(object : retrofit2.Callback<News>, newsItemClciked {
            override fun onResponse(call: retrofit2.Call<News>, response: Response<News>) {
                val news: News? = response.body()
                if (news != null) {
                    Log.d("sports", news.toString())
                    adapter = NewsAdapter(this@MainActivity, news.articles,this)
                    newsList.adapter = adapter
                    newsList.layoutManager = LinearLayoutManager(this@MainActivity)
                }
            }

            override fun onFailure(call: retrofit2.Call<News>, t: Throwable) {
                Log.d("sports", "Error in fetching news")
            }

            override fun onItemClicked(item: Article) {

                val builder = CustomTabsIntent.Builder()
                val customTabIntent = builder.build()
                customTabIntent.launchUrl(this@MainActivity, Uri.parse(item.url))
            }
        })
    }

    private fun getHealthNews() {

        val news: retrofit2.Call<News> = NewsService.newsInstance.getSports("in", "health", 1)
        news.enqueue(object : retrofit2.Callback<News>, newsItemClciked {
            override fun onResponse(call: retrofit2.Call<News>, response: Response<News>) {
                val news: News? = response.body()
                if (news != null) {
                    Log.d("sports", news.toString())
                    adapter = NewsAdapter(this@MainActivity, news.articles,this)
                    newsList.adapter = adapter
                    newsList.layoutManager = LinearLayoutManager(this@MainActivity)
                }
            }

            override fun onFailure(call: retrofit2.Call<News>, t: Throwable) {
                Log.d("sports", "Error in fetching news")
            }

            override fun onItemClicked(item: Article) {

                val builder = CustomTabsIntent.Builder()
                val customTabIntent = builder.build()
                customTabIntent.launchUrl(this@MainActivity, Uri.parse(item.url))
            }
        })
    }

    private fun getEntertainmentNews() {

        val news: retrofit2.Call<News> = NewsService.newsInstance.getSports("in", "entertainment", 1)
        news.enqueue(object : retrofit2.Callback<News>, newsItemClciked {
            override fun onResponse(call: retrofit2.Call<News>, response: Response<News>) {
                val news: News? = response.body()
                if (news != null) {
                    Log.d("sports", news.toString())
                    adapter = NewsAdapter(this@MainActivity, news.articles,this)
                    newsList.adapter = adapter
                    newsList.layoutManager = LinearLayoutManager(this@MainActivity)
                }
            }

            override fun onFailure(call: retrofit2.Call<News>, t: Throwable) {
                Log.d("sports", "Error in fetching news")
            }

            override fun onItemClicked(item: Article) {

                val builder = CustomTabsIntent.Builder()
                val customTabIntent = builder.build()
                customTabIntent.launchUrl(this@MainActivity, Uri.parse(item.url))
            }
        })
    }

    private fun getBusinessNews() {

        val news: retrofit2.Call<News> = NewsService.newsInstance.getSports("in", "business", 1)
        news.enqueue(object : retrofit2.Callback<News>, newsItemClciked {
            override fun onResponse(call: retrofit2.Call<News>, response: Response<News>) {
                val news: News? = response.body()
                if (news != null) {
                    Log.d("sports", news.toString())
                    adapter = NewsAdapter(this@MainActivity, news.articles,this)
                    newsList.adapter = adapter
                    newsList.layoutManager = LinearLayoutManager(this@MainActivity)
                }
            }

            override fun onFailure(call: retrofit2.Call<News>, t: Throwable) {
                Log.d("sports", "Error in fetching news")
            }

            override fun onItemClicked(item: Article) {

                val builder = CustomTabsIntent.Builder()
                val customTabIntent = builder.build()
                customTabIntent.launchUrl(this@MainActivity, Uri.parse(item.url))
            }
        })
    }

    override fun onItemClicked(item: Article) {

        val builder = CustomTabsIntent.Builder()
        val customTabIntent = builder.build()
        customTabIntent.launchUrl(this, Uri.parse(item.url))
    }


}
