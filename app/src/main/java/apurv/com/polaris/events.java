package apurv.com.polaris;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class events extends AppCompatActivity {
    String type,title;
    String slot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.collapse);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        ImageView im=(ImageView)findViewById(R.id.llogo);
        TextView text=(TextView)findViewById(R.id.info);
        TextView textm=(TextView)findViewById(R.id.title);

        type = intent.getStringExtra("type");
        title = intent.getStringExtra("title");
        slot = intent.getStringExtra("slot");
        int number=Integer.parseInt(slot);
        textm.setText(title);
        if(number==1){
            im.setImageResource(R.drawable.coderelay);
            text.setText("Paired up in two, one races around the code and the other does the brainstroming. The event is held in association with the Computer Society of India.\n" +
                    "Competition will be conducted in 2 rounds.\n" +
                    "Round 1(Elimination) –\n\n" +

                    "Round will proceed under two legs.\n" +
                    "1st Leg: 1st participant becomes the coder and the other participant writes the test ; 2nd leg : It’s the palindrome of the 1st Leg\n" +
                    "\nRound 2 (Final)–\n" +
                    "One of the participants is given a Problem statement and has to solve as much as possible in the specified time. As the time limit ends, the partner in waiting comes in to complete the incomplete code. Simultaneously, the 1st  participant who forwarded the 1st question, gets another question to code, again in a specified time. When the 2nd participant completes the 1st question, he is forwarded the second question to complete. Whosever completes both the questions soon wins the relay!\n" +
                    "\nRules –\n" +
                    "    1.\tThe Team can consist of maximum 2 participants.\n" +
                    "    2.\tProblem statement will given only at the time of the event.\n" +
                    "\nTime:\n" +
                    "Entry fees: Rs. 150/- per team\n" +
                    "Prizes worth Rs. 6000/-\n" +
                    "Email: info@polaris2k16.in \n" +
                    "Contact: Shivang Gupta (8698074444)");
        }
        else if(number==2){
            im.setImageResource(R.drawable.crackjack);
            text.setText("Teams of 4 who will get to showcase their logic deducing skills. The event comprises of 4 levels. One team member for each level. The event is held in association with the Computer Society of India.\n" +
                    "\nLevel  1 – Question will be given to decrypt. The result to be used to open a .rar file.\n" +
                    "\nLevel  2 – The .rar file opened will contain images. These images are to be decrypted giving multiple passwords. Find the correct password to proceed to Level 3.\n" +
                    "\nLevel  3 – Use the password obtained in previous Level to open the next .rar file. This will contain a Problem statement for C Language.\n" +
                    "\nLevel  4 – Surprise!!!!!\n\n" +
                    "Rules –\n" +
                    "       1.\tProblem statement will given only at the time of the event.\n" +
                    "       2.\tInternet available on all levels (Not sure yet).\n" +
                    "\nTime:\n" +
                    "Entry fees: Rs. 200/- per team\n" +
                    "Prizes worth Rs. 4000/-\n" +
                    "Email: info@polaris2k16.in \n" +
                    "Contact: Shivang Gupta (8698074444)");
        }
        else if(number==3){
            im.setImageResource(R.drawable.projet);
            text.setText("Certification and prize by Global Logic and Computer Society of India.\n" +
                    "About – Hardware and Software\n" +
                    "\nDetails –\n" +
                    "   1.\tApplication and Project details to be sent 5 days prior to the event through mail.\n"+
                    "   2.\tAn acceptance letter will be issued.\n" +
                    "   3.\tProject has to be in executable form.\n" +
                    "   4.\tStall will be provided along with a plug point.\n" +
                    "   5.\tParticipants have to bring their own equipments.\n" +
                    "\nTime:  29th January 2016\n" +
                    "Entry fees: Rs. 500/-\n" +
                    "Prizes worth Rs. 15000/-\n" +
                    "Email: info@polaris2k16.in \n" +
                    "Contact: Shivang Gupta (8698074444)");
        }
        else if(number==4){
            im.setImageResource(R.drawable.hotheads);
            text.setText("Prizes worth 5000\n" +
                    "A team centred series of rounds to check your physical and mental abilities.\n" +
                    "Game comprises of 5 rounds, one who dares makes it to final.\n" +
                    "Team of 4 with atleast one girl or one boy.\n" +
                    "   Entry fees: 200(team of 4)\n" +
                    "   January 29\n" +
                    "   IT parking\n" +
                    "   10am onwards\n" +
                    "Email: info@polaris2k16.in \n" +
                    "Shubham Murarka\n" +
                    "+91 8087870490\n" +
                    "Rajat Maheshwari\n" +
                    "+ 91 8237455797");
        }
        else if(number==5){
            im.setImageResource(R.drawable.lordsofstage);
            text.setText("Prizes worth 4000 Event to test and improve your speaking skills. Participate as a team(of 2) or individual. 3 rounds comprising of competitions to test your verbal skills and confidence. \n Entry fees: 100 per team(of two) 50 per student \n January 30\n Room no 207 \n 10am to 3pm");
        }
        else if(number==6){
            im.setImageResource(R.drawable.linux);
            text.setText("\"If you want to travel around the world and be invited to speak at a lot of different places, just write a Unix operating system.\" (By Linus Torvalds)\n" +
                    "One OS to rule them all,\n" +
                    "One OS to find them.\n" +
                    "One OS to call them all,\n" +
                    "And in salvation bind them.\n" +
                    "In the bright land of Linux,\n" +
                    "Where the hackers play.\n" +
                    "- J. Scott Thayer\n" +
                    "\n" +
                    "What is LINUX?\n" +
                    "Linux is a free and open source software Unix-like operating system for computers.\n" +
                    "The development of Linux is one of the most prominent examples of free and open-source software collaboration.\n" +
                    "\n" +
                    "Why LINUX?\n" +
                    "A very common item found in programming job descriptions is familiarity with Linux. Adoption of Linux is on an upward trend, and there are no signs to show that will change anytime soon.\n" +
                    "It's a different OS, with different design-philosophies, a different structure, different goals - even if you never look at its source-code, you could still find inspiration in how all the famous and countless other tools magically work together (the UNIX philosophy of \"do one thing, well\").\n" +
                    "\n" +
                    "About the Workshop – \n" +
                    "Learn Programming on Linux like never before!\n" +
                    "\n" +
                    "Time: Timing 9am Onwards\n" +


                    "Entry Fee - 400/- \n " +
                    "Email: info@polaris2k16.in \n" +
                    "Venue - CSE Lab 1 \n" +
                    "Date - 28th January 2016 \n" );
        }
        else if(number==7){
            im.setImageResource(R.drawable.salesforce);

            text.setText("What is Sales Force?\n" +
                            "Salesforce is a Customer Relationship Management (CRM) system that runs in the cloud. CRM software makes it easy to pull together all of your communications and information for your customers.\n" +
                            "\n" +
                            "Why Sales force?\n" +
                            "It's flexible and can integrate with other cloud based systems like accounting systems and email so that you don't end up with data in separate, disconnected silos.\n" +
                            "\n" +
                            "It is the most demanded Cloud Computing software out there right now and is used by plenty MNCs!\n" +
                            "\n" +
                            "What do YOU learn?\n" +
                            "You learn what is out there trending in the IT world right now!\n" +
                            "Gain lead over others and be benifited.\n" +
                            "\n" +
                            "About the Workshop – \n" +
                            "Participants will be taught how to work on the Sales Force Cloud Computing software, right from the installation to the mastery of Cloud Computing\n" +
                            "\n" +
                            "Time: Timing 9am Onwards \n" +
                            "Entry fees: Rs. 400/- per team\n" +
                            "Email: info@polaris2k16.in\n" +
                            "Contact: Shivang Gupta (8698074444)\n"+
                            "Venue - CSE Lab 2 \n" +
                            "Date - 27th January 2016 \n"
            );
        }

        getSupportActionBar().setTitle(title);

        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab);

        if(type.equals("2")){
            CoordinatorLayout.LayoutParams p = (CoordinatorLayout.LayoutParams) fab.getLayoutParams();
            p.setAnchorId(View.NO_ID);
            fab.setLayoutParams(p);
            fab.setVisibility(View.GONE);
        }
        else {
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    //      .setAction("Action", null).show();
                    Intent i = new Intent(events.this, form.class);
                    startActivity(i);
                }
            });
        }

    }



}
