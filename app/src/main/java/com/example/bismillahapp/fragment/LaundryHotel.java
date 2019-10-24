package com.example.bismillahapp.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

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

public class LaundryHotel extends Fragment {
    private Spinner spinner;
    private EditText editText;
    private Button btnAdd, btnSubmit;

    private ArrayList<String> idItem;
    private ArrayList<Integer> item;

    private final String TAG = this.getClass().getSimpleName();

    public LaundryHotel() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_laundry_hotel, container, false);
        item = new ArrayList<>();
        idItem = new ArrayList<>();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        spinner = view.findViewById(R.id.spinner_hotel);
        editText = view.findViewById(R.id.edt_hotel);
        btnAdd = view.findViewById(R.id.btn_add);
        btnSubmit = view.findViewById(R.id.btn_submit);

        getSpinnerCustomer();
        if (getActivity() != null) {
            spinner.setAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, item));
        }

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* TODO add to rv*/
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* inflate fragment */
            }
        });
    }

    private void getSpinnerCustomer() {
        final JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Environment.ITEMS, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject object = response.getJSONObject(i);
                        String id = object.getString("id");
                        String items = object.getString("items");
                        int qty = object.getInt("qty");

                        idItem.add(id);
                        item.add(qty);
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