package com.droibit.service1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /** {@inheritDoc} */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Intent intent = getIntent();
        if (Intent.ACTION_SEND.equals(intent.getAction())) {
            final StringBuilder sb = new StringBuilder()
                    .append("title: ")
                    .append(intent.getStringExtra(Intent.EXTRA_TITLE))
                    .append("\n")
                    .append("text: ")
                    .append(intent.getStringExtra(Intent.EXTRA_TEXT))
                    .append("\n")
                    .append("id: ")
                    .append(intent.getExtras().getInt(MyChooserService.EXTRA_ID))
                    .append("\n")
                    .append("name: ")
                    .append(intent.getExtras().getString(MyChooserService.EXTRA_NAME));

            ((TextView) findViewById(R.id.text)).setText(sb.toString());
        }
    }

    /** {@inheritDoc} */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /** {@inheritDoc} */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
