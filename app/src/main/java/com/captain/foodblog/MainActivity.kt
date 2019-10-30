package com.captain.foodblog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.captain.foodblog.view.DashboardRecyclerAdapter
import com.captain.foodblog.viewModels.BlogViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProviders.of(this).get(BlogViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        window.statusBarColor = resources.getColor(R.color.white)

        val mAdapter = DashboardRecyclerAdapter(this)
        dashboardRecyclerView.adapter = mAdapter


        viewModel.getAllBlogs().observe(this, Observer {

            if (it!=null) {
                Log.i("Check", it.data.card_details.city)
                title_textView.text = it.data.card_details.title
                city_textView.text = it.data.card_details.city

                mAdapter.showAllBlogs(it.data.card)
            }


        })

        viewModel.getBlogsFromNetwork()




    }
}
