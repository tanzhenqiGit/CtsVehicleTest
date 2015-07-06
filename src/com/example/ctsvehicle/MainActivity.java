package com.example.ctsvehicle;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.vehicle.bat.BatManager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    private void initialize()
    {
    	mBat = (Button) findViewById(R.id.main_batttery);
    	if (mBat != null) {
    		mBat.setOnClickListener(mListener);
    	}
    	mCode = (Button) findViewById(R.id.main_code);
    	if (mCode != null) {
    		mCode.setOnClickListener(mListener);
    	}
    	mVehicle = (Button) findViewById(R.id.main_vehicle);
    	if (mVehicle != null) {
    		mVehicle.setOnClickListener(mListener);
    	}
    	mClose = (Button) findViewById(R.id.main_close);
    	if (mClose != null) {
    		mClose.setOnClickListener(mListener);
    	}
    	mKill = (Button)findViewById(R.id.main_kill);
    	if (mKill != null) {
    		mKill.setOnClickListener(mListener);
    	}
    }
    private Button mBat, mCode, mVehicle, mClose, mKill;
    private View.OnClickListener mListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.main_batttery:
				Intent bat = new Intent(MainActivity.this, CtsBattery.class);
				startActivity(bat);
				finish();
				break;
			case R.id.main_close:
				finish();
				break;
			case R.id.main_code:
				Intent code = new Intent(MainActivity.this, CtsCode.class);
				startActivity(code);
				finish();
				break;
			case R.id.main_vehicle:
				Intent vehicle = new Intent(MainActivity.this, CtsVehicleMain.class);
				startActivity(vehicle);
				finish();
				break;
			case R.id.main_kill:
				BatManager b = null;
				b.addBatListener(null);
				break;
			default: break;
			}
			
		}
	};
}
