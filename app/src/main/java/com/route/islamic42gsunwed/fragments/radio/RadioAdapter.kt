package com.route.islamic42gsunwed.fragments.radio

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.route.islamic42gsunwed.R
import com.route.islamic42gsunwed.databinding.ChannelItemRadioBinding
import com.route.islamic42gsunwed.fragments.radio.api.model.RadiosItem

class RadioAdapter(val radiosItems: List<RadiosItem>) :
    RecyclerView.Adapter<RadioAdapter.RadioViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RadioViewHolder {
        val binding =
            ChannelItemRadioBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RadioViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: RadioViewHolder,
        position: Int
    ) {
        val item = radiosItems[position]
        var isPlayed = false
        var isMuted = false

        holder.bind(item)
        holder.binding.PlayImage.setOnClickListener {
            if(isPlayed){
                holder.binding.channelBackground.setBackgroundResource(R.drawable.radio_channel_bg)
                holder.binding.PlayImage.setImageResource(R.drawable.ic_play)
                isPlayed = false
            }
            else{
                holder.binding.channelBackground.setBackgroundResource(R.drawable.radio_playing_bg)
                holder.binding.PlayImage.setImageResource(R.drawable.ic_pause)
                isPlayed = true
            }
        }

        holder.binding.AudioImage.setOnClickListener {
            if(isMuted){
                holder.binding.AudioImage.setImageResource(R.drawable.ic_high_volume)
                isMuted = false
            }
            else{
                holder.binding.AudioImage.setImageResource(R.drawable.ic_muted)
                isMuted = true
            }
        }
    }

    override fun getItemCount(): Int {
        return radiosItems.size
    }

    class RadioViewHolder(val binding: ChannelItemRadioBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: RadiosItem) {
            binding.readerName.text = data.name
        }
    }
}