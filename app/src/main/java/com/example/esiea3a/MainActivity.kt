package com.example.esiea3a

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.ListView

class MainActivity : AppCompatActivity() {


    private lateinit var listView : ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Lien avec le layout activity_main.xml
        setContentView(R.layout.activity_main)

        //Affichage du nom de l'application
        setSupportActionBar(findViewById(R.id.toolbar))

        /* ACTION DU BOUTON BAS GAUCHE (Envelope)
        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "Test", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        */


        //Création de la liste

        val listItems = ArrayList<Livre>()

        listItems.add(Livre("One Piece", 1996, R.drawable.onepiece));

        var test2 = Livre("Naruto", 1997,R.drawable.naruto)
        listItems.add(test2);

        for (i in 2 until 5) {
            listItems.add(Livre("Film $i", 2000+1 , R.drawable.film));
        }

        val adapter = LivreAdapter(this, listItems)
        listView = findViewById(R.id.recipe_list_view)
        listView.adapter = adapter


    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
