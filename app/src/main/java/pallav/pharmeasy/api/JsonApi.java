package pallav.pharmeasy.api;

import android.app.Activity;

import com.android.volley.Request;
import com.google.gson.JsonObject;

import pallav.pharmeasy.PharmEasyApp;
import pallav.pharmeasy.volley_classes.MyJsonObjectRequest;
import pallav.pharmeasy.volley_classes.ResponseListener;


public class JsonApi {
    PharmEasyApp application;


    public JsonApi(PharmEasyApp app){
        this.application = app;

    }

    public void loadData(ResponseListener<JsonObject> responseListener, Activity activity, String myUrl, String tag){
        MyJsonObjectRequest request = new MyJsonObjectRequest(activity, Request.Method.GET, myUrl, responseListener) ;
        request.setTag(tag);
        application.getRequestQueue().add(request);
    }
    public void cancelAll(String tag) {
        application.getRequestQueue().cancelAll(tag);
    }
}
