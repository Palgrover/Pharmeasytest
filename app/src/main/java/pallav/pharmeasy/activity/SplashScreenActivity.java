package pallav.pharmeasy.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.Serializable;

import pallav.pharmeasy.PharmEasyApp;
import pallav.pharmeasy.R;
import pallav.pharmeasy.model.Medicine;
import pallav.pharmeasy.volley_classes.ResponseListener;

public class SplashScreenActivity extends AppCompatActivity implements Serializable{

    private TextView statusTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        statusTextView = (TextView) findViewById(R.id.status_text);
        Medicine.deleteAll(Medicine.class);
        String url = "https://www.1mg.com/api/v1/search/autocomplete?name=b&pageSize=10000&_=1435404923427";
        fetchData(url);

    }


    public void fetchData(String url) {
        statusTextView.setText("loading");
        ResponseListener<JsonObject> listener = new ResponseListener<JsonObject>() {
            @Override
            public void onResponse(final JsonObject response) {

                JsonArray result = response.getAsJsonArray("result");
                new DbSaveTask(result).execute();
            }

            @Override
            public void onErrorResponse(VolleyError e) {
                Log.e("", "tryLogin " + e.getMessage());
                /*dialog.dismiss();*/
                if (e instanceof TimeoutError || e instanceof NoConnectionError || e instanceof NetworkError) {
                } else {
                }
            }
        };
        PharmEasyApp.getInstance().getPharmEasyApi().loadData(listener,this,url,"test");
    }

    private class DbSaveTask extends AsyncTask<Void, Integer, Void> {

        JsonArray result;
        int i;
        int totalValues;

        public DbSaveTask(JsonArray result) {
            this.result = result;
            i = 0;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            statusTextView.setText("saving");
        }

        @Override
        protected Void doInBackground(Void... params) {
            for(JsonElement x: result){
                JsonObject y = x.getAsJsonObject();
                Medicine m = new Medicine(y.get("name").getAsString(),y.get("id").getAsLong());
                m.save();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Intent i = new Intent(SplashScreenActivity.this,MainActivity.class);
            startActivity(i);
        }
    }


}
