package com.example.osdevlab.simpletutorial;


import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

/**
 * Created by osdevlab on 12/29/14.
 */
public class FragmentOne extends Fragment {
    static final int SOLAR_NOON = 1;
    static final int CURRENT_TIME = 2;


    Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout with fragment_one.xml
        View view = inflater.inflate(R.layout.fragment_one, container, false);

        //create TextView 'textViewPress' and link with texView id from fragment_one.xml
        final TextView textViewPress = (TextView) view.findViewById(R.id.textView);


        //returns the Activity the Fragment is currently associated with
        //In Fragment, this step requires to pass context to other class.
        context = getActivity();

        //create Switch 'switchTime' and link with Switch id from fragment_one.xml
        final Switch switchTime = (Switch) view.findViewById(R.id.switchTime);
        //default set as true;
        switchTime.setChecked(true);
        //set Text inside switch toggle name
        switchTime.setTextOn("Solar Noon Time");
        switchTime.setTextOff("Current Time");
        //set Text for switch name
        switchTime.setText("Time");

        switchTime.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            //need to pass context to JsonHelperClass
            JsonHelperClass jsonHelperClass = new JsonHelperClass(context);
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    //get solar noon time for today and display on textView
                    textViewPress.setText(jsonHelperClass.getResult(SOLAR_NOON));

                } else {
                    //get current time and display on textView
                    textViewPress.setText(jsonHelperClass.getResult(CURRENT_TIME));
                }
            }
        });
        return view;
    }
}
