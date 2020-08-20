package com.example.onsitetask2;


import android.content.Context;
import android.graphics.Path;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment implements customView.onCanvasTouch{
    private Fragment1Listener listener;
    customView customView;


    @Override
    public void onTouch(Path path) {
        listener.onInput1Sent(path);

    }


    public interface Fragment1Listener{
        void onInput1Sent(Path path);
    }


    public Fragment1() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_fragment1, container, false);
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
        if(context instanceof Fragment1Listener){
            listener = (Fragment1Listener) context;
        }else{
            throw new RuntimeException(context.toString()+"must implement Fragment1Listener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}
