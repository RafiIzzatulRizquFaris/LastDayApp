package com.example.bismillahapp;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Environment {
    private static final String BASE_URL = "https://testapi.io/api/mgmprpldepok/";
    /* GET */
    public static String ITEMS = BASE_URL + "items";
    public static String EMPLOYEES = BASE_URL + "employees";
    public static String CUSTOMERS = BASE_URL + "customers";
    public static String SERVICES = BASE_URL + "services";

    /* POST */
    public static String LAUNDRY_HOTEL = BASE_URL + "laundry/hotel";
    public static String LAUNDRY_CUSTOMER = BASE_URL + "laundry/customer";
    public static String TOKEN = "?token=e829c2c5dd8a77a99bf80465c716919c076e1d76";

    private void getItems() {
        final JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Environment.ITEMS, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject object = response.getJSONObject(i);
                        String id = object.getString("id");
                        String items = object.getString("items");
                        int qty = object.getInt("qty");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                Log.e(TAG, "onErrorResponse: ", error);
            }
        });
    }

    private void getEmployees() {
        final JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Environment.EMPLOYEES, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject object = response.getJSONObject(i);
                        String id = object.getString("id");
                        String createdAt = object.getString("createdAt");
                        String employee_name = object.getString("employee_name");
                        String avatar = object.getString("avatar");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                Log.e(TAG, "onErrorResponse: ", error);
            }
        });
    }

    private void getCustomers() {
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
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                Log.e(TAG, "onErrorResponse: ", error);
            }
        });
    }

    private void getServices() {
        final JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Environment.ITEMS, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject object = response.getJSONObject(i);
                        String id = object.getString("id");
                        String service_name = object.getString("service_name");
                        String description = object.getString("description");
                        String price = object.getString("price");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                Log.e(TAG, "onErrorResponse: ", error);
            }
        });
    }
}