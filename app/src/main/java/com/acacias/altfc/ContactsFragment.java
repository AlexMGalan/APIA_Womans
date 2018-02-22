package com.acacias.altfc;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContactsFragment extends Fragment {


    public ContactsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_home, container, false);

        View v = inflater.inflate(R.layout.fragment_contact, container, false);
        getActivity().setTitle("Contacts");
        //  FloatingActionButton fab = (FloatingActionButton) v.findViewById(R.id.fab);

        //   FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        //  fab.setOnClickListener(new View.OnClickListener() {
        //      @Override
        //      public void onClick(View view) {
        //          Snackbar.make(view, "Email", Snackbar.LENGTH_LONG)
        //                  .setAction("Action", null).show();


        //   }
        // });

        return v;
    }

}
