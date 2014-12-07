package com.example.roger.volleytut;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;


public class MainActivity extends ActionBarActivity {

    TextView tv;
    NetworkImageView nImgView;
    RequestQueue mRequestQueue;

    public static final String TAG = "MyTag";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.textview);
        nImgView = (NetworkImageView) findViewById(R.id.networkImageView);

       // mRequestQueue = Volley.newRequestQueue(this);
       //
        //String url = "http://chopchopcode.com/android/memberReg.php/?user=calvin";
        String url = "http://echo.jsontest.com/title/ipsum/content/blah";

        final String imgurl = "http://i.imgur.com/7spzG.png";

        GsonRequest<Dummy> gsonRequest = new GsonRequest<>(url,Dummy.class,new Response.Listener<Dummy>() {
            @Override
            public void onResponse(Dummy response) {
//                tv.setText(String.valueOf(response.length));
                tv.setText(String.valueOf(response.toString()));

            }
        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                tv.setText(error.toString());
            }
        });



        StringRequest strRequest = new StringRequest(Request.Method.GET, imgurl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                nImgView.setImageUrl(imgurl, MySingleton.getInstance(getApplicationContext()).getImageLoader());
              //  tv.setText("Respond is "+response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                tv.setText("failed");
            }
        });
        strRequest.setTag(TAG);


        MySingleton.getInstance(this).addToRequestQueue(gsonRequest);
       // MySingleton.getInstance(this).addToRequestQueue(strRequest);



    }

    @Override
    protected void onStop () {
        mRequestQueue = MySingleton.getInstance(getApplicationContext()).getRequestQueue();
        super.onStop();
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(TAG);
        }
    }



}

