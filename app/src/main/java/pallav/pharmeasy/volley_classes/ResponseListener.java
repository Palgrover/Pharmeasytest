package pallav.pharmeasy.volley_classes;

import com.android.volley.Response;
import com.android.volley.VolleyError;


public abstract class ResponseListener<T> implements Response.Listener<T>, Response.ErrorListener {

    public abstract void onResponse(T response);

    public abstract void onErrorResponse(VolleyError error);
}
