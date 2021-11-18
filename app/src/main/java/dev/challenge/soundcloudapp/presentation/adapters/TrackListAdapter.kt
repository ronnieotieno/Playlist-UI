package dev.challenge.soundcloudapp.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.challenge.soundcloudapp.data.model.Track
import dev.challenge.soundcloudapp.databinding.TrackItemBinding
import dev.challenge.soundcloudapp.presentation.adapters.TrackListAdapter.ViewHolder

/**
 * A simple [RecyclerView.Adapter] that loads the list of [Track] to the Recyclerview
 * [onClick] a higher order function that gets triggered when the [ViewHolder.binding] root is clicked passing [Track] at the position
 * to the calling Fragment/Activity
 */
class TrackListAdapter(private val onClick: (Track) -> Unit) :
    RecyclerView.Adapter<TrackListAdapter.ViewHolder>() {

    private val list = ArrayList<Track>()

    //sets the list with new data
    fun setList(list: List<Track>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            TrackItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val track = list[position]

        holder.bind(track)
    }

    override fun getItemCount() = list.size


    inner class ViewHolder(private val binding: TrackItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        /**
         * Binds [track] to [TrackItemBinding.setTrack]  and calculate time which is binded to [TrackItemBinding.setTime]
         */
        fun bind(track: Track) {

            binding.track = track

            //Calculation the duration in minutes and second
            val minutes = track.duration / 1000 / 60
            val seconds = track.duration / 1000 % 60

            binding.time = "$minutes:$seconds"


            binding.root.setOnClickListener {
                onClick.invoke(track)
            }

        }
    }

}