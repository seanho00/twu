package com.seanho.helloandroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

public class HelloAndroid extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        TextView hello = new TextView( this );
        hello.setText( "Hello, Android!" );
        setContentView( hello );
        
//        setContentView( R.layout.main );
        
//        final Button clickMe = (Button) findViewById( R.id.clickMe );
//        final EditText message = (EditText) findViewById( R.id.message );
//
//        clickMe.setOnClickListener(new OnClickListener() {
//        	public void onClick(View v) {
//        		message.setText( message.getText() + "\nThanks!" );
//        	}
//        });
    }
}