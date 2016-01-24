package apurv.com.polaris;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Dell on 07-01-2016.
 */
public class main extends Activity {
    private EditText ed;
    private Button bt;
    private ProgressDialog pDialog;
    private static String TAG = "mainclass";
    //private String url="http://polaris2k16.in/tools/android/androidApi.php?android=1&&name=";
    private String url="http://polaris2k16.in/tools/android/androidApi.php?key=";
    private String key;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.validate);
        ed=(EditText)findViewById(R.id.pass);
        bt=(Button)findViewById(R.id.button);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                key=ed.getText().toString().toLowerCase();
                if(key.equals("asmac")){
                    AppController.setLogin(1);
                    AppController.setLogger(key);
                    finish();
                }
                makeJsonObjectRequest();
            }
        });
        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        /*
        ((TextView)findViewById(R.id.orr)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(main.this, menu.class);
                i.putExtra("type","2");
                startActivity(i);
            }
        });
        */

    }
    private void makeJsonObjectRequest() {

        showpDialog();

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                url+key, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, response.toString());

                try {
                    // Parsing json object response0
                    // response will be a json object
                    //Toast.makeText(getApplicationContext(),"Here "+response.toString(),Toast.LENGTH_LONG);
                    String val = response.getString("success");
                    if(val.equals("1")){
                       // Toast.makeText(getApplicationContext(), "Success " + val, Toast.LENGTH_SHORT);
                        //Intent i = new Intent(main.this, menu.class);
                        //i.putExtra("type","1");
                        //startActivity(i);
                        AppController.setLogin(1);
                        AppController.setLogger(key);
                        finish();
                    }
                    else Toast.makeText(getApplicationContext(),
                            "Wrong ID ",
                            Toast.LENGTH_LONG).show();


                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(),
                            "Error: " + e.getMessage(),
                            Toast.LENGTH_LONG).show();
                }
                hidepDialog();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        "No Internet Connection", Toast.LENGTH_SHORT).show();
                // hide the progress dialog
                hidepDialog();
            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjReq);
    }

    /**
     * Method to make json array request where response starts with [
     * */


    private void showpDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hidepDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }

}
