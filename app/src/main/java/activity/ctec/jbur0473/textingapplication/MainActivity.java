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

public class MainActivity extends AppCompatActivity
{
    private Button btn;
    private TextView txt;
    private TextView nbr;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.sendButton);
        txt = (TextView) findViewById(R.id.messageText);
        nbr = (TextView) findViewById(R.id.phone);

        setupListeners();
    }

    private void setupListeners()
    {
        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View currentView)
            {
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
