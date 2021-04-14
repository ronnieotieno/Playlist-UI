package dev.challenge.soundcloudapp.presentation.views

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.snackbar.Snackbar
import dagger.android.support.DaggerFragment
import dev.challenge.soundcloudapp.R
import dev.challenge.soundcloudapp.data.model.Track
import dev.challenge.soundcloudapp.databinding.FragmentPlayListBinding
import dev.challenge.soundcloudapp.presentation.adapters.TrackListAdapter
import dev.challenge.soundcloudapp.presentation.viewmodels.PlayListViewModel
import dev.challenge.soundcloudapp.utils.NetworkResource
import dev.challenge.soundcloudapp.utils.addDivider
import javax.inject.Inject
import kotlin.math.abs

/**
 * The Main and Only fragment, perfoms all the view works, gets data from [PlayListViewModel]
 */
class PlayListFragment : DaggerFragment(R.layout.fragment_play_list) {

    private lateinit var binding: FragmentPlayListBinding
    private val adapter = TrackListAdapter { track -> selectedTrack(track) }
    private var snackBar: Snackbar? = null

    //Injected by Dagger2
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: PlayListViewModel by viewModels {
        viewModelFactory
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentPlayListBinding.bind(view)


        setAdapter()
        startObservingResponse()

        //call api
        viewModel.getPlayList()
        makeSnackBar()
    }

    /**
     * Observes [PlayListViewModel.response] and react to changes, sets data to adapter when successfull
     */

    private fun startObservingResponse() {

        viewModel.response.observe(viewLifecycleOwner, { response ->

            //show progress only when the data is being loaded
            binding.loadingProgress.isVisible = response is NetworkResource.Loading
            binding.title.isVisible = response is NetworkResource.Success

            when (response) {
                is NetworkResource.Loading -> {

                }
                is NetworkResource.Failure -> {
                    //sets snackbar if the loading failed
                    snackBar?.show()

                }
                is NetworkResource.Success -> {

                    //sets the playslist tracks to Adapter
                    adapter.setList(response.value.tracks)

                    //sets playlist to the binding
                    binding.playList = response.value

                }
            }


        })

    }

    private fun setAdapter() {
        binding.trackList.adapter = adapter
        binding.trackList.addDivider() //adds the divider

        //Listens to changes in the appbar visibility and change the toolbar title
        binding.appbar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { collapsingToolbar, verticalOffset ->

            when {
                abs(verticalOffset) - collapsingToolbar.totalScrollRange == 0 -> {
                    binding.toolbar.title = "PlayList"
                }
                verticalOffset == 0 -> {
                    binding.toolbar.title = ""
                }
            }

        })

    }

    private fun makeSnackBar() {
        val parentLayout = requireActivity().findViewById<View>(android.R.id.content)
        snackBar = Snackbar.make(
            parentLayout,
            "There was an error loading the playlist, please check your internet and try again",
            Snackbar.LENGTH_INDEFINITE
        )

    }

    private fun selectedTrack(track: Track) {
        val parentLayout = requireActivity().findViewById<View>(android.R.id.content)
        Snackbar.make(
            parentLayout,
            track.title,
            Snackbar.LENGTH_SHORT
        ).show()
    }
}