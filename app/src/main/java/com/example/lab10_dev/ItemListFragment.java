package com.example.lab10_dev;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import androidx.fragment.app.ListFragment;

public class ItemListFragment extends ListFragment {

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Données pour la liste
        String[] dataItems = {
                "Premier élément", "Deuxième élément", "Troisième élément",
                "Quatrième élément", "Cinquième élément", "Sixième élément",
                "Septième élément", "Huitième élément", "Neuvième élément",
                "Dixième élément"
        };

        // Création de l'adaptateur - utilisation de requireActivity() au lieu de getActivity()
        ArrayAdapter<String> itemAdapter = new ArrayAdapter<>(
                requireActivity(),
                android.R.layout.simple_list_item_1,
                dataItems
        );

        // Attachement de l'adaptateur à la liste
        setListAdapter(itemAdapter);
    }
}