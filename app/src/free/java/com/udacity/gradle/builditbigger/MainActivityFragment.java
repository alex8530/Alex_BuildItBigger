package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.androidjokelib.jokeActivity;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    Context context;

    public MainActivityFragment() {
    }

    public boolean testFlag = false;

    public String loadedJoke = null;
    private static MyApi myApiService = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        context = getActivity();
        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);

        root.findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//        MyJoke myJoke= new MyJoke();
//        Toast.makeText(this, myJoke.getJoke(), Toast.LENGTH_LONG).show();
//        // for step 2
//        Intent intent= new Intent(this,jokeActivity.class);
//
//       intent.putExtra(JOKE_KEY,myJoke.getJoke());
//        startActivity(intent);


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
