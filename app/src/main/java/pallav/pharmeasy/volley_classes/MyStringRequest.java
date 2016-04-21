package pallav.pharmeasy.volley_classes;

import android.app.Activity;

import java.util.Map;


public class MyStringRequest extends BaseRequest<String> {

    public String convertStringResponseToRequiredFormat(String response){
        return response;
    }

    public MyStringRequest(Activity activity, String url, Map<String, String> params, ResponseListener<String> listener) {
        super(activity, url, params, listener);
    }

}
