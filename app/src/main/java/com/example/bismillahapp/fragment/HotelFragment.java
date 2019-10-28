package com.example.bismillahapp.fragment;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.bismillahapp.Environment;
import com.example.bismillahapp.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class HotelFragment extends DialogFragment {
    private Spinner spinnerRoom, spinnerHouseKeeper;
    private Button btnCancel, btnSubmit;

    private ArrayList<String> listRoomNumber, listHouseKeeper;

    private final String TAG = this.getClass().getSimpleName();

    public HotelFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hotel, container, false);
        listRoomNumber = new ArrayList<>();
        listHouseKeeper = new ArrayList<>();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        spinnerRoom = view.findViewById(R.id.spinner_room_number);
        spinnerHouseKeeper = view.findViewById(R.id.spinner_house_keeper);
        btnCancel = view.findViewById(R.id.btn_cancel);
        btnSubmit= view.findViewById(R.id.btn_submit);

        getSpinnerCustomers();

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* TODO SUMBIT DATA */
            }
        });
    }

    private void getSpinnerCustomers() {
        final JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Environment.CUSTOMERS, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject object = response.getJSONObject(i);
                        String id = object.getString("id");
                        String createdAt = object.getString("createdAt");
                        String name = object.getString("name");
                        String avatar = object.getString("avatar");

                        listRoomNumber.add(id);
                        listHouseKeeper.add(name);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "onErrorResponse: ", error);
            }
        });

        if (getActivity() != null) {
            RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
            requestQueue.add(jsonArrayRequest);
        }
    }
}