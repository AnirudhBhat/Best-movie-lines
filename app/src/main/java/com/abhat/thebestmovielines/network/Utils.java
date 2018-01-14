package com.abhat.thebestmovielines.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.abhat.thebestmovielines.App;

/**
 * Created by Anirudh Uppunda on 13/1/18.
 */

public class Utils {
    public static boolean isOnline() {
        ConnectivityManager cm =
                (ConnectivityManager) App.Companion.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }


}
