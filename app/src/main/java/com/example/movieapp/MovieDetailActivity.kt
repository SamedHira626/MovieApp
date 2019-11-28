package com.example.movieapp

import android.content.Context
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_movie_detail.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MovieDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_movie_detail)
        // RetrofitClient.getMovieApi().getMovieDetail("22")
        //  showUser()

        setContentView(R.layout.activity_movie_detail)
        getMovieDetail("671")
        Toast.makeText(this, "TEST", Toast.LENGTH_SHORT).show()
    }

    private fun getMovieDetail(movieId: String) {
        GlobalScope.launch {
            val movieApi = RetrofitClient.getMovieApi()
            val movieDetail = movieApi.getMovieDetail(movieId)

            runOnUiThread {
                Glide.with(this@MovieDetailActivity).load(movieDetail?.backdropPath).into(image1)
                Glide.with(this@MovieDetailActivity).load(movieDetail?.posterPath).into(image2)
                text1.text = movieDetail?.title
                text2.text = movieDetail?.overview
            }
            //  private fun showUser(){
            //    val preferences = getSharedPreferences("MovieApp", Context.MODE_PRIVATE)
            //     val email = preferences.getString("email","User not found")

            //    Toast.makeText(this,"Email = $email", Toast.LENGTH_SHORT).show()

            // movieNameTextView.text=email

        }
    }
}
