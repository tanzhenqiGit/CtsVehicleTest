package com.example.ctsvehicle;

import java.util.ArrayList;

import data.adapter.DataAdapter;
import data.adapter.Element;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.vehicle.bat.BatListener;
import android.vehicle.bat.BatManager;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class CtsCode extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_code);
		initialize();
	}

	@Override
	protected void onDestroy() {
		// TODO 自动生成的方法存根
		super.onDestroy();
		if (mBatMgr != null) {
			mBatMgr.removeBatListener(mBatListener);
		}
	}
	
	private void initialize()
	{
		mBatMgr = (BatManager) getSystemService(BAT_SERVICE);
		if (mBatMgr != null) {
			mBatMgr.addBatListener(mBatListener);
		}
		mAdapter = new DataAdapter(this);
		initializeData();
		mAdapter.setListNameData(mArrayList);
		mRet = (Button) findViewById(R.id.code_return);
		if (mRet != null) {
			mRet.setOnClickListener(mListener);
		}
		
		mGet = (Button) findViewById(R.id.code_get);
		if (mGet != null) {
			mGet.setOnClickListener(mListener);
		}
		
		mList = (ListView) findViewById(R.id.code_list);
		if (mList != null) {
			mList.setAdapter(mAdapter);
		}
	}
	
	private void initializeData()
	{
		if (mBatMgr == null) {
			Log.d(TAG, "initializeDataAdapter mBatMgr == null do nothing.");
			return;
		}
		Element e;
		// id = 1
		e = new Element("车身电机温度", "" + mBatMgr.getBatteryMotorTemperatureSts());
		mArrayList.add(e);
		// id = 2
		e = new Element("电机控制器温度", "" + mBatMgr.getBatteryMotorControllerTempteraureSts());
		mArrayList.add(e);
		// id = 3
		e = new Element("电机控制器", "" + mBatMgr.getBatteryMotorControllerSts());
		mArrayList.add(e);
		// id = 4
		e = new Element("模式电机", "" + mBatMgr.getBatteryMotorModeSts());
		mArrayList.add(e);
		// id = 5
		e = new Element("空调温度电机", "" + mBatMgr.getBatteryAirConditionTemperatureSts());
		mArrayList.add(e);
		// id = 6
		e = new Element("蒸发器传感器", "" + mBatMgr.getBatteryEvapopatorSensorSts());
		mArrayList.add(e);
		// id = 7
		e = new Element("回风温度传感器", "" + mBatMgr.getBatteryWindSensorSts());
		mArrayList.add(e);
		// id = 8
		e = new Element("BMS故障码", "" + mBatMgr.getBatteryBMSFaultCode());
		mArrayList.add(e);
		// id = 9
		e = new Element("BMC故障等级", "" + mBatMgr.getBatteryBCMFaultGrade());
		mArrayList.add(e);
		// id = 10
		e = new Element("转向灯故障状态", "" + mBatMgr.getBatterySteeringLightSts());
		mArrayList.add(e);
		// id = 11
		e = new Element("绝缘超低", "" + mBatMgr.getBatteryMotorInsulationUltralowSts());
		mArrayList.add(e);
		
	}
	
	private void adapterNotify()
	{
		if (mAdapter != null) {
			mAdapter.notifyDataSetChanged();
		}
	}
	
	private Button mRet, mGet;
	private ListView mList;
	private DataAdapter mAdapter;
	private ArrayList<Element> mArrayList = new ArrayList<Element>();
	private final String TAG = "cts";
	private View.OnClickListener mListener = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.code_get:
				mArrayList.clear();
				if (mBatMgr != null) {
					mBatMgr.syncBatteryData();
				}
				initializeData();
				adapterNotify();
				break;
			case R.id.code_return:
				Intent intent = new Intent(CtsCode.this, MainActivity.class);
				startActivity(intent);
				finish();
				break;
			default:
				
				break;
			}
			
		}
	};
	
	private BatManager mBatMgr;
	private BatListener mBatListener = new BatListener()
	{
		/**
		 * id = 1
		 */
		@Override
		public void onMotorTemperatureStsChenged(BatManager.BatteryFaultStatus sts)
	    {
	      	Log.d(TAG, "onMotorTemperatureStsChenged sts = " + sts );
			Element e = mArrayList.get(0);
			e.setmValue(sts+"");
			adapterNotify();
	    }
	   
		/**
		 * id = 2
		 */
		@Override
	    public void onMotorContorllerTemperatureStsChanged(BatManager.BatteryFaultStatus sts)
	    {
	    	Log.d(TAG, "onMotorContorllerTemperatureStsChanged sts = " + sts );
	    	Element e = mArrayList.get(1);
			e.setmValue(sts+"");
			adapterNotify();
	    }
	   

	    /**
	     * id = 3
	     */
	    @Override
	    public void onMotorControllerStsChanged(BatManager.BatteryFaultStatus sts)
	    {
	    	Log.d(TAG, "onMotorControllerStsChanged sts = " + sts );
	    	Element e = mArrayList.get(2);
			e.setmValue(sts+"");
			adapterNotify();
	    }
	    /**
	     * id = 4
	     */
	    @Override
	    public void onMotorModeStsChanged(BatManager.BatteryFaultStatus sts)
	    {
	    	Log.d(TAG, "onMotorModeStsChanged sts = " + sts );
	    	Element e = mArrayList.get(3);
			e.setmValue(sts+"");
			adapterNotify();
	    } 
	  
	    /**
	     * id = 5
	     */
	    @Override
	    public void onAirConditionTemperatureStsChanged(BatManager.BatteryFaultStatus sts)
	    {
	      	Log.d(TAG, "onAirConditionTemperatureStsChanged sts = " + sts );
	    	Element e = mArrayList.get(4);
			e.setmValue(sts+"");
			adapterNotify();
	    }
	  
	    /**
	     * id = 6
	     */
	    @Override
	    public void onEvapopatorSensorStsChanged(BatManager.BatteryFaultStatus sts)
	    {
	    	Log.d(TAG, "onEvapopatorSensorStsChanged sts = " + sts );
	    	Element e = mArrayList.get(5);
			e.setmValue(sts+"");
			adapterNotify();
	    }
	  
	    /**
	     * id = 7
	     */
	    @Override
	    public void onReturnWindSensorStsChanged(BatManager.BatteryFaultStatus sts)
	    {
	    	Log.d(TAG, "onReturnWindSensorStsChanged sts = " + sts );
	    	Element e = mArrayList.get(6);
			e.setmValue(sts+"");
			adapterNotify();
	    }
	    /**
	     * id = 8
	     */
	    @Override
	    public void onBMSFaultCodeChanged(int code)
	    {
	    	Log.d(TAG, "onBMSFaultCodeChanged code = " + code );
	    	Element e = mArrayList.get(7);
			e.setmValue(code+"");
			adapterNotify();
	    }
	  
	    /**
	     * id = 9
	     */
	    @Override
	    public void onBatFaultBMCFaultGradeChanged(BatManager.BatteryBCMFaultGrade sts)
	    {
	    	Log.d(TAG, "onBatFaultBMCFaultGradeChanged sts = " + sts );
	    	Element e = mArrayList.get(8);
			e.setmValue(sts+"");
			adapterNotify();
	    }

	    /**
	     * id = 10
	     */
	    @Override
	    public void onSteeringLightStsChanged(BatManager.BatterySteeringLightSts sts)
	    {
	    	Log.d(TAG, "onSteeringLightStsChanged sts = " + sts );
	    	Element e = mArrayList.get(9);
			e.setmValue(sts+"");
			adapterNotify();
	    }
	  
	    /**
	     * id = 11
	     */
	    @Override
	    public void onInsulationUltralowStsChanged(BatManager.BatteryFaultStatus sts)
	    {
	     	Log.d(TAG, "onInsulationUltralowStsChanged sts = " + sts );
	    	Element e = mArrayList.get(10);
			e.setmValue(sts+"");
			adapterNotify();
	    }
	};

}
