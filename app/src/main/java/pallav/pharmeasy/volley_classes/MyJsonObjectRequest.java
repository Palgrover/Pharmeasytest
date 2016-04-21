package pallav.pharmeasy.volley_classes;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.JsonObject;

import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.util.Map;

import pallav.pharmeasy.util.JsonHelper;


public class MyJsonObjectRequest extends Request<String> {
    private WeakReference<Activity> activityWeakReference = null;
    private WeakReference<Fragment> fragmentWeakReference = null;
    Map<String, String> postParams;
    Response.Listener<JsonObject> jsonObjListener;
    String postRequestBody;
    Response.Listener<String> stringListener = new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            JsonObject result = JsonHelper.StringToJsonObject(response);
            jsonObjListener.onResponse(result);
        }
    };

    boolean initiatedInBg = false;

    protected static final String PROTOCOL_CHARSET = "utf-8";

    public MyJsonObjectRequest(Activity activity, int method, String url, ResponseListener<JsonObject> listener) {
        super(method, url, listener);
        jsonObjListener = listener;
        activityWeakReference = new WeakReference<Activity>(activity);
        this.setRetryPolicy(VolleyHelper.generateDefaultRetryPolicy());
    }

    @Override
    protected void deliverResponse(String response) {
        if (!initiatedInBg) {
            if (activityWeakReference.get() != null && !activityWeakReference.get().isFinishing()
                    && activityWeakReference.get().getWindow() != null) {
                if (fragmentWeakReference != null && fragmentWeakReference.get() != null && fragmentWeakReference.get().isAdded()) {
                    stringListener.onResponse(response);
                    //complete the callback - was from fragment
                } else if (fragmentWeakReference == null) {
                    stringListener.onResponse(response);
                    //complete the callback - was from activity
                }
            }
        }
        else {
            stringListener.onResponse(response);
        }
    }

    @Override
    public void deliverError(VolleyError error) {
        if (!initiatedInBg) {
            if (activityWeakReference.get() != null && !activityWeakReference.get().isFinishing()
                    && activityWeakReference.get().getWindow() != null) {
                if (fragmentWeakReference != null && fragmentWeakReference.get() != null && fragmentWeakReference.get().isAdded()) {
                    super.deliverError(error);
                    //complete the callback - was from fragment
                } else if (fragmentWeakReference == null) {
                    super.deliverError(error);
                    //complete the callback - was from activity
                }
            }
        }else {
            super.deliverError(error);
        }
    }

    @Override
    protected Response<String> parseNetworkResponse(NetworkResponse response) {
        String parsed;
        try {
            parsed = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
        } catch (UnsupportedEncodingException e) {
            parsed = new String(response.data);
        }
        return Response.success(parsed, HttpHeaderParser.parseCacheHeaders(response));
    }

    @Override
    protected Map<String, String> getParams() {
        return postParams;
    }

    public String getBodyContentType() {
        return "application/x-www-form-urlencoded; charset=" + getParamsEncoding();
    }

    @Override
    public byte[] getBody() throws AuthFailureError {
        if (postRequestBody != null) {
            try {
                return postRequestBody.getBytes(PROTOCOL_CHARSET);
            } catch (UnsupportedEncodingException uee) {
                VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s",
                        postRequestBody, PROTOCOL_CHARSET);
                return null;
            }
        }
        else {
            return super.getBody();
        }
    }
}
