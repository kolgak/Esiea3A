package com.example.esiea3a

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.example.esiea3a.api.MangaApi
import com.example.esiea3a.api.MangaResponse
import retrofit2.Callback
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import android.widget.AdapterView;


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
        listItems.add(Manga("L'attaque des Titans", "Hajime ISAYAMA", 2009, R.drawable.titans, "testA"));


        val adapter = MangaAdapter(view.context, listItems)
        listView  = view.findViewById(R.id.manga_list_view)
        listView.adapter = adapter
        /**view.findViewById<Button>(R.id.button_first).setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }*/

        val retrofit = Retrofit.Builder()
            .baseUrl("https://jikan1.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val mangaApi : MangaApi = retrofit.create(MangaApi::class.java)

        Log.d("JSON", "Requte ici")
        mangaApi.getMangaList().enqueue(object: Callback<MangaResponse>{
            override fun onFailure(call: Call<MangaResponse>, t: Throwable) {
                TODO("Not yet implemented")
                Log.d("JSON", "ERREUR Rec")
            }

            override fun onResponse(call: Call<MangaResponse>, response: Response<MangaResponse>) {
                if (response.isSuccessful && response.body() != null){
                    Log.d("JSON","Response = ");
                    val mangaResponse = response.body()!!
                    Log.d("JSON","Response = "+ mangaResponse);
                }
                else {
                    Log.d("JSON","Response = ");
                }
            }

        })


    }

}

