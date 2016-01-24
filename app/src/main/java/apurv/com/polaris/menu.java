package apurv.com.polaris;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Dell on 07-01-2016.
 */
public class menu extends AppCompatActivity {
    private EditText ed;
    private Button bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8;
    String type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        AppController.setLogin(0);
        type="2";

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.actionbar);
        ((TextView)findViewById(R.id.orr)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (AppController.getLogin() == 1) {
                    AppController.setLogin(0);
                    type = "2";
                    ((TextView) findViewById(R.id.orr)).setText("SIGN IN AS ADMIN");
                } else {
                    Intent i = new Intent(menu.this, main.class);
                    //i.putExtra("type", "2");
                    startActivity(i);
                }
            }
        });
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.white)));
        bt1=(Button)findViewById(R.id.button1);
        bt2=(Button)findViewById(R.id.button2);
        bt3=(Button)findViewById(R.id.button3);
        bt4=(Button)findViewById(R.id.button4);
        bt5=(Button)findViewById(R.id.button5);
        bt6=(Button)findViewById(R.id.button6);
        bt7=(Button)findViewById(R.id.button7);

        Intent intent = getIntent();
        type = intent.getStringExtra("type");
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qualifier();
                Intent i = new Intent(menu.this,events.class);
                i.putExtra("type",type);
                i.putExtra("slot","1");
                i.putExtra("title","Code Relay");
                startActivity(i);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {qualifier();
                Intent i = new Intent(menu.this,events.class);
                i.putExtra("type",type);
                i.putExtra("slot","2");
                i.putExtra("title","Crack-Jack");
                startActivity(i);
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qualifier();
                Intent i = new Intent(menu.this,events.class);
                i.putExtra("type",type);
                i.putExtra("slot","3");
                i.putExtra("title","Pro-Jet");
                startActivity(i);
            }
        });
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qualifier();
                Intent i = new Intent(menu.this,events.class);
                i.putExtra("type",type);
                i.putExtra("slot","4");i.putExtra("title","HotHeads");
                startActivity(i);
            }
        });
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qualifier();
                Intent i = new Intent(menu.this,events.class);
                i.putExtra("type",type);
                i.putExtra("slot","5");
                i.putExtra("title","Lord of Stage");
                startActivity(i);
            }
        });
        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qualifier();
                Intent i = new Intent(menu.this,events.class);
                i.putExtra("type",type);
                i.putExtra("slot","6");
                i.putExtra("title","Cloud on Linux");
                startActivity(i);
            }
        });
        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qualifier();
                Intent i = new Intent(menu.this,events.class);
                i.putExtra("type",type);
                i.putExtra("slot","7");
                i.putExtra("title","SalesForce Tech.");
                startActivity(i);
            }
        });
        ((TextView)findViewById(R.id.spon)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qualifier();
                Intent i = new Intent(menu.this, sponsor.class);

                startActivity(i);
            }
        });


    }
    void qualifier(){
        if(AppController.getLogin()==1){
            type="1";
            ((TextView)findViewById(R.id.orr)).setText("logged in as '"+AppController.getLogger()+"' ,click to log out");
        }
        else{
            type="2";
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        qualifier();

    }
}
