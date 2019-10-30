package com.captain.foodblog.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.captain.foodblog.models.BlogResponseModel
import com.captain.foodblog.repository.BlogRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BlogViewModel:ViewModel() {

    private val blogRepository = BlogRepository.getInstance()

    private val getAllBlogs: MutableLiveData<BlogResponseModel> = MutableLiveData()

    fun getAllBlogs(): LiveData<BlogResponseModel>
    {
        return getAllBlogs
    }

    fun getBlogsFromNetwork() = blogRepository.getAllBlogs().enqueue(object:
        Callback<BlogResponseModel> {
        override fun onFailure(call: Call<BlogResponseModel>, t: Throwable) {
            Log.i("Blogs" , t.localizedMessage)
        }

        override fun onResponse(
            call: Call<BlogResponseModel>, response: Response<BlogResponseModel>
        ) {
            if (response.isSuccessful)
            {
                Log.i("Blogs" , response.body()?.data?.card?.size.toString())
                getAllBlogs.postValue(response.body())
            }
            else
            {
                Log.i("Blogs" , response.body()?.data?.card?.size.toString())
                getAllBlogs.postValue(null)
            }
        }
    })


}