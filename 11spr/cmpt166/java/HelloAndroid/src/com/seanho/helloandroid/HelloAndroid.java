package com.seanho.helloandroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HelloAndroid extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//         TextView hello = new TextView( this );
//         hello.setText( "Hello, CMPT166!" );
//         setContentView( hello );

        setContentView(R.layout.main);

        final Button clickMe = (Button) findViewById(R.id.clickMe);
        final EditText message = (EditText) findViewById(R.id.message);

        clickMe.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View v) {
                message.setText(message.getText() + "\nThanks!");
            }
        });
    }
}
