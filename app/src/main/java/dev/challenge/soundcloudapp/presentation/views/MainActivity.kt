package dev.challenge.soundcloudapp.presentation.views

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import dev.challenge.soundcloudapp.R

class MainActivity : DaggerAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setting the app theme when the activity is created, when the app starts, it starts with splash theme
        setTheme(R.style.Theme_SoundCloudApp)
        setContentView(R.layout.activity_main)

        //Hosts the PlayListFragment.
    }


}