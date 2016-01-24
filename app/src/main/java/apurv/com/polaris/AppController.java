package apurv.com.polaris;

/**
 * Created by Dell on 28-05-2015.
 */

import android.app.Application;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.parse.Parse;
import com.parse.ParseInstallation;

public class AppController extends Application {


    public static int login;
    public static String logger;

    public static String getLogger() {
        return logger;
    }

    public static void setLogger(String logger) {
        AppController.logger = logger;
    }

    public static String getTAG() {

        return TAG;
    }

    public static int getLogin() {
        return login;
    }

    public static void setLogin(int loginn) {
        login = loginn;
    }

    @Override
    public void onCreate() {
        
        super.onCreate();
        mInstance = this;


    }
    public static final String TAG = AppController.class.getSimpleName();

    private RequestQueue mRequestQueue;

    private static AppController mInstance;



    public static synchronized AppController getInstance() {
        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req, String tag) {
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }

    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }

}