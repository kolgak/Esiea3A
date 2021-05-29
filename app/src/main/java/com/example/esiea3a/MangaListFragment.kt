package com.example.esiea3a

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */

class MangaListFragment : Fragment() {


    private lateinit var listView : ListView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mangalist, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Création de la liste

        val listItems = ArrayList<Manga>()

        listItems.add(Manga("One Piece", "Eichiro ODA" ,1996, R.drawable.onepiece, "testO"));
        listItems.add(Manga("Naruto", "Masashi KISHIMOTO", 1999, R.drawable.naruto, "testN"));
        listItems.add(Manga("Dragon Ball Z", "Akira TORIYAMA", 1989, R.drawable.dbz, "testD"));
        listItems.add(Manga("Fullmetal Alchemist", "Hiromu ARAKAWA", 2001, R.drawable.fma, "testF"));
        listItems.add(Manga("L'attaque des Titans", "Hajime ISAYAMA", 2009, R.drawable.titans, "testF"));


        val adapter = MangaAdapter(view.context, listItems)
        listView  = view.findViewById(R.id.manga_list_view)
        listView.adapter = adapter
        /**view.findViewById<Button>(R.id.button_first).setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }*/
    }

}

