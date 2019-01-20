package com.example.dan.googlemap.models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.dan.googlemap.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

public class CustomInfoWindowAdapter implements GoogleMap.InfoWindowAdapter{

    private final View mWindow;
    private Context mContext;

    public CustomInfoWindowAdapter(Context context) {
        mContext = context;

     mWindow = LayoutInflater.from(context).inflate(R.layout.customer_info_marker, null);

    }

    private void rendowWindowText(Marker marker, View view)
    {
//TITLE
        String title = marker.getTitle();
        TextView TextTitle = (TextView)view.findViewById(R.id.title);

        if(!title.equals(""))
        {
            TextTitle.setText(title);
        }
//SNIPPET
        String snippet = marker.getTitle();
        TextView TextSnippet = (TextView)view.findViewById(R.id.snippet);

        if(!snippet.equals(""))
        {
            TextSnippet.setText(snippet);
        }

    }

    @Override
    public View getInfoWindow(Marker marker) {
        rendowWindowText(marker,mWindow);

        return mWindow;
    }

    @Override
    public View getInfoContents(Marker marker) {
        rendowWindowText(marker,mWindow);
        return mWindow;
    }
}


