package activity.ctec.jbur0473.textingapplication;

/**Group 2 Texting project
 * Jordan Burnett jabur1210@gmail.com
 * Billy Konesavanh billykonesavanh17@gmail.com
 * korman Willeitner korman.willeitner@yahoo.com
 * Luke Barrowes luke.barrowes@gmail.com
 * Deigen Villalobos deig83@gmail.com
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.telephony.SmsManager;
import java.util.ArrayList;

/**
 * @author Jordan Burnett - Helped OH so much.
 */

public class MainActivity extends AppCompatActivity
{
    private Button btn;
    private TextView txt;
    private TextView nbr;
    private ArrayList<String> randomMessage;
    private ArrayList<String> randomNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.sendButton);
        txt = (TextView) findViewById(R.id.messageText);
        nbr = (TextView) findViewById(R.id.phone);
        this.randomMessage = new ArrayList<String>();
        this.randomNumber = new ArrayList<String>();
        setupListeners();
        makeRandom();
    }

    public void makeRandom()
    {
        this.randomMessage.add("The vacuum bag sure is hot today!");
        this.randomMessage.add("What would you say if I was right outside your bedroom window right now?  (Go look).");
        this.randomMessage.add("Knowing that one day the mouse might find a way to heat up the spaghetti fills you with determination.");
        this.randomMessage.add("How do you feel right now? Remember, this is for prosperity, so be honest.");
        this.randomMessage.add("Knowing people die if they are killed fills you with determination!");
        this.randomMessage.add("One of these days you're going to wake up dead.");
        this.randomMessage.add("Not the bees! Not the bees!");
        this.randomMessage.add("Hey, listen!");
        this.randomMessage.add("The probability of Princess Zelda being in this area is 85%.");
        this.randomMessage.add("It's time to kick butt and chew bubble gum. And I'm fresh out of bubble gum.");
        this.randomMessage.add("Never, under any circumstance, take a sleeping pill and a laxative on the same night.");
        this.randomMessage.add("The shinbone is a device for finding furniture in a dark room.");
        this.randomMessage.add("Politicians and diapers have one thing in common. They should both be changed regularly, and for the same reason.");
        this.randomMessage.add("Vote for nobody, because nobody cares.");
        this.randomMessage.add("Don't worry about what people think, because they don't do it very often.");
        this.randomMessage.add("Heroism is the only way to be famous when we have no talent.");
        this.randomMessage.add("The enemy is stupid: he believes that the enemy is us, even though it's him!");
        this.randomMessage.add("Everything happens for a reason. But sometimes the reason is that you're stupid and you make bad decisions.");

        this.randomNumber.add("8015603218");
        this.randomNumber.add("8018217021");
    }

    private String getRandomPhrase()
    {
        String randomPhrase = "";

        int randomSpot = (int) (Math.random() * randomMessage.size());
        randomPhrase = randomMessage.get(randomSpot);

        return randomPhrase;
    }

    private String getBlankNumber()
    {
        String blankNumber = "";

        int randomNumberSpot = (int) (Math.random() * randomNumber.size());
        blankNumber = randomNumber.get(randomNumberSpot);

        return blankNumber;
    }

    private void setupListeners()
    {
        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View currentView)
            {
                if(nbr.getText().toString()== "")
                {
                    nbr.setText(getBlankNumber());
                }

                if(txt.getText().toString()== "")
                {
                    txt.setText(getRandomPhrase());
                }

                try
                {
                    String contact = nbr.getText().toString();
                    String message = txt.getText().toString();
                    sendSMS(contact, message);

                    Toast.makeText(currentView.getContext(), "message was sent", Toast.LENGTH_SHORT).show();
                }
                catch(Exception currentException)
                {
                    Toast.makeText(currentView.getContext(), "message was not sent", Toast.LENGTH_LONG).show();
                    Toast.makeText(currentView.getContext(), currentException.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    /**
     * Sends a text based SMS to a specified number.
     * @param messageAddress The number this app sends a text to.
     * @param messageContent The message being sent.
     */

    private void sendSMS(String messageAddress, String messageContent)
    {
        SmsManager mySMSManager = SmsManager.getDefault();
        mySMSManager.sendTextMessage(messageAddress, null, messageContent, null, null);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
