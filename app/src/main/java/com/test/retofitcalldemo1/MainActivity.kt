package com.test.retofitcalldemo1

import androidx.appcompat.app.AppCompatActivity


import android.os.Bundle

import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager

import com.test.retofitcalldemo1.adapters.PostAdapter
import com.test.retofitcalldemo1.model.Data
import com.test.retofitcalldemo1.network.RetrofitFactory
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.toast
import retrofit2.HttpException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt_add_user.onClick { addData() }
        loadData()
    }

    private fun initRecyclerView(list: List<Data>) {
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = PostAdapter(list, this)
    }

    private fun loadData() {
        val service = RetrofitFactory.makeRetrofitService()
        CoroutineScope(Dispatchers.IO).launch {
            val response = service.getPosts()
            try {
                withContext(Dispatchers.Main) {
                    if (response.isSuccessful) {
                        val listData:List<Data> = response.body()!!.data
                        Log.i("AA_", listData.toString())

                        response.body()?.let { initRecyclerView(listData) }


                    } else {
                        toast("Error network operation failed with ${response.code()}")
                    }
                }
            } catch (e: HttpException) {
                Log.e("REQUEST", "Exception ${e.message}")
            } catch (e: Throwable) {
                Log.e("REQUEST", "Ooops: Something else went wrong")
            }
        }
    }

    private fun addData() {
        val service = RetrofitFactory.makeRetrofitService()
        CoroutineScope(Dispatchers.IO).launch {
            val response = service.addUsers("TEst","TEST2")
            try {
                withContext(Dispatchers.Main) {
                    if (response.isSuccessful) {
//                        val listData:List<Data> = response.body()!!.data
//                        Log.i("AA_", listData.toString())
//
//                        response.body()?.let { initRecyclerView(listData) }


                    } else {
                        toast("Error network operation failed with ${response.code()}")
                    }
                }
            } catch (e: HttpException) {
                Log.e("REQUEST", "Exception ${e.message}")
            } catch (e: Throwable) {
                Log.e("REQUEST", "Ooops: Something else went wrong")
            }
        }
    }
}
