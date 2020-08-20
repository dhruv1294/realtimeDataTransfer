package com.example.onsitetask2;


import android.content.Context;
import android.graphics.Path;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment2 extends Fragment implements customView.onCanvasTouch{
    private Fragment2Listener listener;
    customView customView;

    @Override
    public void onTouch(Path path) {
        listener.onInput2Sent(path);

    }

    public interface Fragment2Listener{
        void onInput2Sent(Path path);
    }

    public Fragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_fragment2, container, false);
        customView = v.findViewById(R.id.customview);
        customView.setmCallBack(this);




        return v;
    }
    public void updatePath(Path path){
        customView.setPath(path);

    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof Fragment2Listener){
            listener = (Fragment2Listener) context;
        }else{
            throw new RuntimeException(context.toString()+"must implement Fragment2Listener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

}
