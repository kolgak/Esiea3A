package com.example.esiea3a

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class EpisodeListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private val adapter = EpisodeAdapteur(listOf())
    private val layoutManager = LinearLayoutManager(context)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_episodelist, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.episode_recyclerview)
        recyclerView.layoutManager = this@EpisodeListFragment.layoutManager
        recyclerView.adapter = this@EpisodeListFragment.adapter

        val episodeList = arrayListOf<Episode>().apply {
            add(Episode(1,"titre1","url1"))
            add(Episode(2,"titre2","url2"))
            add(Episode(3,"titre3","url3"))

        }
        adapter.updateList(episodeList)
    }
}