package com.example.ctsvehicle;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CtsVehicleMain extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_vehicle_main);
		initialize();
	}

	@Override
	protected void onDestroy() {
		// TODO 自动生成的方法存根
		super.onDestroy();
	}
	
	private void initialize()
	{
		mRet = (Button) findViewById(R.id.vehicle_ret);
		if (mRet != null) {
			mRet.setOnClickListener(mListener);
		}
		mClose = (Button) findViewById(R.id.vehicle_close);
		if (mClose != null) {
			mClose.setOnClickListener(mListener);
		}
		//id = 1
		mVin = (Button) findViewById(R.id.vehicle_vin);
		if (mVin != null) {
			mVin.setOnClickListener(mListener);
		}
		//id = 2
		mGate = (Button) findViewById(R.id.vehicle_gate);
		if (mGate != null) {
			mGate.setOnClickListener(mListener);
		}
		//id = 3
		mSeftBelt = (Button) findViewById(R.id.vehicle_saftbelt);
		if (mSeftBelt != null) {
			mSeftBelt.setOnClickListener(mListener);
		}
		//id = 4
		mKey = (Button) findViewById(R.id.vehicle_key);
		if (mKey != null) {
			mKey.setOnClickListener(mListener);
		}
		// id = 5
		mWindow = (Button) findViewById(R.id.vehicle_window);
		if (mWindow != null) {
			mWindow.setOnClickListener(mListener);
		}
		// id = 6
		mMirror = (Button) findViewById(R.id.vehicle_mirror);
		if (mMirror != null) {
			mMirror.setOnClickListener(mListener);
		}
		// id = 7
		mLight = (Button) findViewById(R.id.vehicle_light);
		if (mLight != null) {
			mLight.setOnClickListener(mListener);
		}
		//id = 8
		mADAS = (Button) findViewById(R.id.vehicle_adas);
		if (mADAS != null) {
			mADAS.setOnClickListener(mListener);
		}
		//id = 9
		mTeperature = (Button) findViewById(R.id.vehicle_temperature);
		if (mTeperature != null) {
			mTeperature.setOnClickListener(mListener);
		}
		// id = 10
		mAirCondition = (Button) findViewById(R.id.vehicle_aircondition);
		if (mAirCondition != null) {
			mAirCondition.setOnClickListener(mListener);
		}
		// id = 11
		mOil = (Button) findViewById(R.id.vehicle_oil);
		if (mOil != null) {
			mOil.setOnClickListener(mListener);
		}
		// id = 12
		mSaftBag = (Button) findViewById(R.id.vehicle_saftbag);
		if (mSaftBag != null) {
			mSaftBag.setOnClickListener(mListener);
		}
		
	}

	
	private Button mVin, mGate, mSeftBelt, mKey, mWindow, mMirror, mRet, mClose;
	private Button mLight, mADAS, mTeperature, mAirCondition, mOil, mSaftBag;
	private View.OnClickListener mListener = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.vehicle_ret:
				Intent intent = new Intent(CtsVehicleMain.this, MainActivity.class);
				startActivity(intent);
				finish();
				break;
			case R.id.vehicle_close:
				finish();
				break;
			case R.id.vehicle_vin:
				Intent vin = new Intent(CtsVehicleMain.this, CtsVehicleVin.class);
				startActivity(vin);
				finish();
				break;
			case R.id.vehicle_gate:
				Intent gate = new Intent(CtsVehicleMain.this, CtsVehicleGate.class);
				startActivity(gate);
				finish();
				break;
			case R.id.vehicle_saftbelt:
				Intent saftbelt = new Intent(CtsVehicleMain.this, CtsVehicleSeftBelt.class);
				startActivity(saftbelt);
				finish();
				break;
			case R.id.vehicle_key:
				Intent key = new Intent(CtsVehicleMain.this, CtsVehicleKey.class);
				startActivity(key);
				finish();
				break;
			case R.id.vehicle_window:
				Intent window = new Intent(CtsVehicleMain.this, CtsVehicleWindow.class);
				startActivity(window);
				finish();
				break;
			case R.id.vehicle_mirror:
				Intent mirror = new Intent(CtsVehicleMain.this, CtsVehicleMirror.class);
				startActivity(mirror);
				finish();
				break;
			case R.id.vehicle_light:
				Intent light = new Intent(CtsVehicleMain.this, CtsVehicleLight.class);
				startActivity(light);
				finish();
				break;
			case R.id.vehicle_adas:
				Intent adas = new Intent(CtsVehicleMain.this, CtsVehicleADAS.class);
				startActivity(adas);
				finish();
				break;
			case R.id.vehicle_temperature:
				Intent temperature = new Intent(CtsVehicleMain.this, CtsVehicleTemperature.class);
				startActivity(temperature);
				finish();
				break;
			case R.id.vehicle_aircondition:
				Intent aircondition = new Intent(CtsVehicleMain.this, CtsVehicleAirCondition.class);
				startActivity(aircondition);
				finish();
				break;
			case R.id.vehicle_oil:
				Intent oil = new Intent(CtsVehicleMain.this, CtsVehicleOil.class);
				startActivity(oil);
				finish();
				break;
			case R.id.vehicle_saftbag:
				Intent saftbag = new Intent(CtsVehicleMain.this, CtsVehicleSeftBag.class);
				startActivity(saftbag);
				finish();
				break;
			default:
				
				break;
			
			}
		}
	};
}
