package apurv.com.polaris;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.parse.ParseObject;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Dell on 07-01-2016.
 */
public class form extends Activity implements View.OnClickListener {
    private EditText name,coll,phone,email,note;
    private Button bt, bt2, bt3, bt4, bt5, bt6;
    private ProgressDialog pDialog;
    private String jsonResponse;
    CheckBox ch1,ch2,ch3,ch4,ch5,ch6,ch7;
    int eight[];
    private static String TAG = "formclass";
    private TextView sum;
    
    private String url="http://polaris2k16.in/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form);

       // Arrays.fill(eight, 0);
        name=(EditText)findViewById(R.id.name);
        coll =(EditText)findViewById(R.id.college);
        phone=(EditText)findViewById(R.id.phone);
        email=(EditText)findViewById(R.id.email);
        note=(EditText)findViewById(R.id.note);
        sum=(TextView)findViewById(R.id.sum);

        ch1=(CheckBox)findViewById(R.id.checkBox);
        ch2=(CheckBox)findViewById(R.id.checkBox2);
        ch3=(CheckBox)findViewById(R.id.checkBox3);
        ch4=(CheckBox)findViewById(R.id.checkBox4);
        ch5=(CheckBox)findViewById(R.id.checkBox5);
        ch6=(CheckBox)findViewById(R.id.checkBox6);
        ch7=(CheckBox)findViewById(R.id.checkBox7);
        ch1.setOnClickListener(this);
        ch2.setOnClickListener(this);
        ch3.setOnClickListener(this);
        ch4.setOnClickListener(this);
        ch5.setOnClickListener(this);
        ch6.setOnClickListener(this);
        ch7.setOnClickListener(this);



        bt=(Button)findViewById(R.id.button);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isEmpty(name)&&!isEmpty(coll)&&!isEmpty(phone)&&!isEmpty(email)&&sums>0&&phone.getText().toString().length()==10&&android.util.Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches()) {
                    
                        makeJsonObjectRequest();

                }
                else{
                    if(sums>0)
                    Toast.makeText(getApplicationContext(), "Please fill the form", Toast.LENGTH_LONG).show();
                    else if(phone.getText().toString().length()!=10){
                        Toast.makeText(getApplicationContext(), "Enter 10 digit phone number", Toast.LENGTH_LONG).show();
                    }
                    else if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches()){
                        Toast.makeText(getApplicationContext(), "Enter valid Email", Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Choose at least one event", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
       // makeJsonObjectRequest();
    }
    private boolean isEmpty(EditText etText) {
        return etText.getText().toString().trim().length() == 0;
    }
    private String getEightBits(){
        String eight="";
        if(ch1.isChecked())eight+="1";else eight+="0";
        if(ch2.isChecked())eight+="1";else eight+="0";
        if(ch3.isChecked())eight+="1";else eight+="0";
        if(ch4.isChecked())eight+="1";else eight+="0";
        if(ch5.isChecked())eight+="1";else eight+="0";
        if(ch6.isChecked())eight+="1";else eight+="0";
        if(ch7.isChecked())eight+="1";else eight+="0";
        eight+="0";
        return eight;

    }
    private void generatestring(){

        //url=
    }
    private void makeJsonObjectRequest() {
        //Toast.makeText(getApplicationContext(), url, Toast.LENGTH_LONG).show();

        showpDialog();

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                url, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, response.toString());

                try {
                    // Parsing json object response
                    // response will be a json object
                    String val = response.getString("success");
                    if(val.equals("1")){
                        Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_SHORT).show();
                        finish();
                    }
                    else
                        Toast.makeText(getApplicationContext(),"Failed, Something is Wrong",Toast.LENGTH_SHORT).show();

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
                        "No Internet Connection"+ "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
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
    int sums;
    @Override
    public void onClick(View view) {
        int ar[]={150,200,500,200,100,400,400,200};
        String tmp=getEightBits();
        sums=0;
        for(int i=0;i<8;i++){
            sums+=ar[i]*Integer.parseInt(String.valueOf(tmp.charAt(i)));
        }
        sum.setText("TOTAL  ₹"+String.valueOf(sums));
    }
}