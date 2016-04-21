package pallav.pharmeasy;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.orm.SugarApp;

import java.net.CookieHandler;
import java.net.CookieManager;

import pallav.pharmeasy.api.JsonApi;
import pallav.pharmeasy.util.LruBitmapCache;


public class PharmEasyApp extends SugarApp {

    public static final String TAG = PharmEasyApp.class.getSimpleName();

    private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;
    private JsonApi mockJsonApi;

    private static PharmEasyApp mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public static synchronized PharmEasyApp getInstance() {
        return mInstance;
    }


    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            CookieManager cookieManager = new CookieManager();
            CookieHandler.setDefault(cookieManager);
            mRequestQueue = Volley.newRequestQueue(this);
        }
        return mRequestQueue;
    }

    public JsonApi getPharmEasyApi() {
        if (mockJsonApi == null) {
            mockJsonApi = new JsonApi(this);
        }
        return mockJsonApi;
    }
    public ImageLoader getImageLoader() {
        getRequestQueue();
        if (mImageLoader == null) {
            mImageLoader = new ImageLoader(this.mRequestQueue,
                    new LruBitmapCache());
        }
        return this.mImageLoader;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

}