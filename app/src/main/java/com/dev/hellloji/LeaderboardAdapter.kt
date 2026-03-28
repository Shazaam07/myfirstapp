package com.dev.hellloji

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// 2. Adapter Class (Jo XML mein data bharega)
class LeaderboardAdapter(private var playerList: List<Player>) :
    RecyclerView.Adapter<LeaderboardAdapter.PlayerViewHolder>() {

    class PlayerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvRank: TextView = itemView.findViewById(R.id.tvRank)
        val tvAvatar: TextView = itemView.findViewById(R.id.tvAvatar)
        val tvName: TextView = itemView.findViewById(R.id.tvName)
        val tvScore: TextView = itemView.findViewById(R.id.tvScore)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_leaderboard_row, parent, false)
        return PlayerViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        val player = playerList[position]
        holder.tvRank.text = player.rank
        holder.tvAvatar.text = player.initial
        holder.tvName.text = player.name
        holder.tvScore.text = player.score

        // Avatar ka color change karna
        holder.tvAvatar.backgroundTintList = ColorStateList.valueOf(Color.parseColor(player.color))
    }

    override fun getItemCount(): Int {
        return playerList.size
    }

    fun updateData(newList: List<Player>) {
        playerList = newList
        notifyDataSetChanged() // Machine ko refresh karne ka signal
    }
}
