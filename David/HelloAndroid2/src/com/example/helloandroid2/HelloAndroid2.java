package com.example.helloandroid2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class HelloAndroid2 extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        TextView txt6 = (TextView) findViewById(R.id.textView6);
        txt6.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ImageView imv = (ImageView) findViewById(R.id.imageView1);
				imv.setImageResource(R.drawable.corneliaeriksson);
			}
		});
        
        TextView txt5 = (TextView) findViewById(R.id.textView5);
        txt5.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ImageView imv = (ImageView) findViewById(R.id.imageView1);
				imv.setImageResource(R.drawable.joakimgusafsson);
			}
		});
        
        
        TextView txt4 = (TextView) findViewById(R.id.textView4);
        txt4.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ImageView imv = (ImageView) findViewById(R.id.imageView1);
				imv.setImageResource(R.drawable.sofiahelin);
			}
		});
        
        
        
        TextView txt3 = (TextView) findViewById(R.id.textView3);
        txt3.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ImageView imv = (ImageView) findViewById(R.id.imageView1);
				imv.setImageResource(R.drawable.martinhallenalmroth);
			}
		});
        
        TextView txt2 = (TextView) findViewById(R.id.TextView2);
        txt2.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ImageView imv = (ImageView) findViewById(R.id.imageView1);
				imv.setImageResource(R.drawable.erikovragard);
				
			}
		});
        
        
        
        TextView txt1 = (TextView) findViewById(R.id.TextView1);
        txt1.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ImageView imv = (ImageView) findViewById(R.id.imageView1);
				imv.setImageResource(R.drawable.jesperthornlund);
			}
		});
        
        
       
        Button btn1 = (Button) findViewById(R.id.button1);
        btn1.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ImageView imv = (ImageView) findViewById(R.id.imageView1);
				imv.setImageResource(R.drawable.davidronnjansson2);
			}
		}); 
        /*
        ImageView img1 = (ImageView) findViewById(R.id.imageView1);
        img1.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ImageView imw = (ImageView) findViewById(R.id.imageView2);
				imw.setImageResource(R.drawable.ic_launcher);
				
			}
		}); */
    }
}