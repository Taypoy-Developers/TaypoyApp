package Fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.taypoyapp.FragMain;
import com.example.taypoyapp.MainActivity;
import com.example.taypoyapp.R;
import com.example.taypoyapp.SendMessage;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class HomeFragment extends Fragment {
    //SendMessage sendMessage;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    //private String vid_almuerzo ="https://firebasestorage.googleapis.com/v0/b/taypoy-a6ce0.appspot.com/o/ADOBO%20DE%20CHANCHO%20%20RECETA%20PERUANA%20%20Sazn%20y%20Corazn.mp4?alt=media&token=3a1ed70d-1a6b-4253-b99c-3f7849ea1c3e";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        /*Activity activity = getActivity();
        sendMessage = (SendMessage) activity;*/
        return inflater.inflate(R.layout.fragment_home, container, false);
    }



    /*public void enviarcomida(View view) {

        sendMessage.sendData(vid_almuerzo);
    }

    @Override
    public void onAttach(@NonNull Activity activity) {
        super.onAttach(activity);
        sendMessage = (SendMessage) activity;
    }*/
}