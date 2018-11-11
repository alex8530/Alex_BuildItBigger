package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.androidjokelib.jokeActivity;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    Context context;

    public MainActivityFragment() {
    }

    public boolean testFlag = false;

    public String loadedJoke = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        context = getActivity();


        root.findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


//                new EndpointAsyncTask().execute(MainActivityFragment.this);
                new EndpointAsyncTask().execute(MainActivityFragment.this);

            }
        });
        return root;
    }


    public void launchDisplayJokeActivity() {
        if (!testFlag) {
            Context context = getActivity();
            Intent intent = new Intent(context, jokeActivity.class);
            intent.putExtra("JOKE_KEY", loadedJoke);
            context.startActivity(intent);
        }

    }


}
