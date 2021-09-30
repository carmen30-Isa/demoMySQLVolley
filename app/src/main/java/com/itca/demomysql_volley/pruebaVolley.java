package com.itca.demomysql_volley;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class pruebaVolley extends AppCompatActivity {
    private TextView tvRes;
    private Button btnpeticionHTTP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba_volley);

        tvRes = findViewById(R.id.tvRes);
        btnpeticionHTTP = findViewById(R.id.btnpeticionHTTP);

        btnpeticionHTTP.setOnClickListener();


    }
    private void baseResquest() {
        String URL = "http://192.168.90.10/index.php";
        StringRequest request = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        }) {
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();
                map.put("Content-Type", "aplication/json; charset=utf-8");
                map.put("Accept", "aplication/json");
                map.put("id", "1");
                return map;

            }
        };
        MySingleton.getInstance(getApplicationContext()).addToRequestQueue(request);
    }
    private void pruebaVolley(){
        String url = "http:mjgl.com.sv/pruebaVolley/test.php";

        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.println(response.substring(0,16));
                //tvRes.setText(response.substring(0, 16));
                tvRes.setText(response.toString());
                Toast.makeText(pruebaVolley.this, ""+response.toString(), Toast.LENGTH_SHORT).show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError Error) {

            }
        });
        MySingleton.getInstance(getApplicationContext()).addToRequestQueue(request);

    }
    private void recibirJson(){
        String url1 = "http:mjgl.com.sv/pruebaVolley/test.php";

        StringRequest request = new StringRequest(Request.Method.GET, url1, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
              try {
                  JSONObject respuestaJSON = new JSONObject(response.toString());
                  String var1 =respuestaJSON.getString("id");
                  String var2 =respuestaJSON.getString("nombre");
                  tvRes.setText(response.toString());

                  Toast.makeText(pruebaVolley.this, "ITCA:" + var1 + "\n"+
                          "Nombre", Toast.LENGTH_SHORT).show();

              }
            }
        },new )
    }


}