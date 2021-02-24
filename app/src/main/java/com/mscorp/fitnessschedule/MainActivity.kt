package com.mscorp.fitnessschedule

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.mscorp.fitnessschedule.adapters.TrainingAdapter
import com.mscorp.fitnessschedule.api.ApiFactory
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = TrainingAdapter()
        RecyclerViewLessons.layoutManager = LinearLayoutManager(this)
        RecyclerViewLessons.adapter = adapter

        val service = ApiFactory.makeRetrofitService()
        CoroutineScope(Dispatchers.IO).launch {
            val response = service.getData()
            withContext(Dispatchers.Main) {
                try {
                    if (response.isSuccessful) {
                        progressBar.visibility = View.INVISIBLE
                        adapter.trainingList = response.body()!!
                    } else {
                        Toast.makeText(applicationContext, "lol", Toast.LENGTH_LONG).show()
                    }
                } catch (e: HttpException) {
                    Toast.makeText(applicationContext, "Exception ${e.message}", Toast.LENGTH_LONG)
                        .show()
                } catch (e: Throwable) {
                    Toast.makeText(applicationContext, "Exception ${e.message}", Toast.LENGTH_LONG)
                        .show()

                }
            }
        }
    }
}

