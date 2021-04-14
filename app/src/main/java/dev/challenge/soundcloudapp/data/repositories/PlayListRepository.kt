package dev.challenge.soundcloudapp.data.repositories

import dev.challenge.soundcloudapp.api.PlayListService
import javax.inject.Inject

/**
 * The app repository receiving the data from network, extends [BaseRepository] with generic class to handle exceptions while loading data
 * calls the service function [PlayListService.getPlayList] to load the data from the api.
 * The service [PlayListService] is injected by [Dagger 2](https://dagger.dev/dev-guide)
 */
class PlayListRepository @Inject constructor(private val playListService: PlayListService) :
    BaseRepository() {

    //Calls the api to get the playlist
    suspend fun getPlayList() = safeApiCall {
        playListService.getPlayList()
    }

}