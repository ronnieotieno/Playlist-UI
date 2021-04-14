package dev.challenge.soundcloudapp.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.challenge.soundcloudapp.data.model.PlayListResponse
import dev.challenge.soundcloudapp.data.repositories.PlayListRepository
import dev.challenge.soundcloudapp.utils.NetworkResource
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * A [ViewModel] that prepares data for the PlayListFragment
 *
 * Exposes the livedata that get observed by the fragment
 */
class PlayListViewModel @Inject constructor(private val playListRepository: PlayListRepository) :
    ViewModel() {
    private val _response: MutableLiveData<NetworkResource<PlayListResponse>> =
        MutableLiveData()
    val response: LiveData<NetworkResource<PlayListResponse>> get() = _response

    fun getPlayList() = viewModelScope.launch {
        _response.value = NetworkResource.Loading
        _response.value = playListRepository.getPlayList()
    }
}