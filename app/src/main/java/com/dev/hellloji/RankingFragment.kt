package com.dev.hellloji // Yahan bhi apna package name likhna

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RankingFragment : Fragment() {

    private lateinit var adapter: LeaderboardAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_ranking, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. Apne saare UI elements ko dhundho
        val rvLeaderboard = view.findViewById<RecyclerView>(R.id.rvLeaderboard)
        val tabBeats = view.findViewById<LinearLayout>(R.id.tabBeats)
        val tabReferrals = view.findViewById<LinearLayout>(R.id.tabReferrals)

        val tvBeats = view.findViewById<TextView>(R.id.tvBeats)
        val lineBeats = view.findViewById<View>(R.id.lineBeats)
        val tvReferrals = view.findViewById<TextView>(R.id.tvReferrals)
        val lineReferrals = view.findViewById<View>(R.id.lineReferrals)

        // 2. Dummy Data (Asli app jaisa feel dene ke liye)
        val beatsList = listOf(
            Player("1", "N", "naved", "9.200", "#E91E63"),
            Player("2", "A", "aieyaan007", "3.900", "#4CAF50"),
            Player("3", "T", "Twitter", "2.200", "#9E9E9E"),
            Player("4", "S", "Sharique", "1.700", "#00BCD4")
        )

        val referralsList = listOf(
            Player("1", "R", "Rahul", "50", "#FF9800"),
            Player("2", "P", "Priya", "42", "#9C27B0"),
            Player("3", "A", "Amit", "15", "#3F51B5")
        )

        // 3. RecyclerView ki machine start karo
        rvLeaderboard.layoutManager = LinearLayoutManager(requireContext())
        adapter = LeaderboardAdapter(beatsList) // Default list 'beats' dikhegi
        rvLeaderboard.adapter = adapter

        // 4. Tab Clicks Logic
        tabBeats.setOnClickListener {
            // Beats ko Active karo
            tvBeats.setTextColor(Color.parseColor("#FFFFFF"))
            lineBeats.setBackgroundColor(Color.parseColor("#00DC6A"))
            lineBeats.layoutParams.height = resources.getDimensionPixelSize(R.dimen.active_line_height_if_needed) ?: 8 // Approx 3dp

            // Referrals ko Inactive karo
            tvReferrals.setTextColor(Color.parseColor("#A0A0A0"))
            lineReferrals.setBackgroundColor(Color.parseColor("#1A3B26"))

            // List update karo
            adapter.updateData(beatsList)
        }

        tabReferrals.setOnClickListener {
            // Referrals ko Active karo
            tvReferrals.setTextColor(Color.parseColor("#FFFFFF"))
            lineReferrals.setBackgroundColor(Color.parseColor("#00DC6A"))

            // Beats ko Inactive karo
            tvBeats.setTextColor(Color.parseColor("#A0A0A0"))
            lineBeats.setBackgroundColor(Color.parseColor("#1A3B26"))

            // List update karo
            adapter.updateData(referralsList)
        }
    }
}