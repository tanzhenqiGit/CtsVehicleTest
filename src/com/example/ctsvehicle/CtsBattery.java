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
import android.vehicle.bat.BatManager.SensorTemperatureIndex;
import android.vehicle.bat.BatManager.SingleVoltageIndex;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class CtsBattery extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO �Զ����ɵķ������
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bat);
		initialize();
	}

	@Override
	protected void onDestroy() {
		// TODO �Զ����ɵķ������
		super.onDestroy();
		if (mBatMgr != null) {
			mBatMgr.removeBatListener(mBatListener);
		}
	}
	
	
	private void initialize()
	{
		mBatMgr = (BatManager) getSystemService(BAT_SERVICE);
		mAdapter  = new DataAdapter(this);
		mRet = (Button) findViewById(R.id.bat_return);
		if (mRet != null) {
			mRet.setOnClickListener(mListner);
		}
		mGet = (Button) findViewById(R.id.bat_get);
		if (mGet != null) {
			mGet.setOnClickListener(mListner);
		}
		
		mList = (ListView) findViewById(R.id.bat_list);
		if (mList != null) {
			initializeDataAdapter();
			if (mAdapter != null) {
				mAdapter.setListNameData(mArrayList);
				mList.setAdapter(mAdapter);
			}
		
		}
		
		if (mBatMgr != null) {
			mBatMgr.addBatListener(mBatListener);
		}
	}
	
	private void initializeDataAdapter()
	{
		if (mBatMgr == null) {
			Log.d(TAG, "initializeDataAdapter mBatMgr == null do nothing.");
			return;
		}
		Element e;
		// id = 1 index = 0
		e = new Element("��ѹ", "" + mBatMgr.getBatVoltage() + "V");
		mArrayList.add(e);
		// id = 2 index = 1
		e = new Element("����", "" + mBatMgr.getBatAmpere() + "A");
		mArrayList.add(e);
		// id = 3 index = 2
		e = new Element("�ٶ�", "" + mBatMgr.getSpeed() + "Km/h");
		mArrayList.add(e);
		// id = 4 index = 3
		e = new Element("̽ͷ�¶�1", "" + mBatMgr.getSensorTemperatureByIndex(SensorTemperatureIndex.Index1) + "��C");
		mArrayList.add(e);		
		// id = 5 index = 4
		e = new Element("̽ͷ�¶�2", "" + mBatMgr.getSensorTemperatureByIndex(SensorTemperatureIndex.Index2) + "��C");
		mArrayList.add(e);
		// id = 6 index = 5
		e = new Element("̽ͷ�¶�3", "" + mBatMgr.getSensorTemperatureByIndex(SensorTemperatureIndex.Index3) + "��C");
		mArrayList.add(e);
		// id = 7 index = 6
		e = new Element("̽ͷ�¶�4", "" + mBatMgr.getSensorTemperatureByIndex(SensorTemperatureIndex.Index4) + "��C");
		mArrayList.add(e);
		// id = 8 index = 7
		e = new Element("̽ͷ�¶�5", "" + mBatMgr.getSensorTemperatureByIndex(SensorTemperatureIndex.Index5) + "��C");
		mArrayList.add(e);
		// id = 9 index = 8
		e = new Element("̽ͷ�¶�6", "" + mBatMgr.getSensorTemperatureByIndex(SensorTemperatureIndex.Index6) + "��C");
		mArrayList.add(e);
		// id = 10 index = 9
		e = new Element("̽ͷ�¶�7", "" + mBatMgr.getSensorTemperatureByIndex(SensorTemperatureIndex.Index7) + "��C");
		mArrayList.add(e);
		// id = 11 index = 10
		e = new Element("̽ͷ�¶�8", "" + mBatMgr.getSensorTemperatureByIndex(SensorTemperatureIndex.Index8) + "��C");
		mArrayList.add(e);
		// id = 12 index = 11
		e = new Element("̽ͷ�¶�9", "" + mBatMgr.getSensorTemperatureByIndex(SensorTemperatureIndex.Index9) + "��C");
		mArrayList.add(e);		
		// id = 13 index = 12
		e = new Element("̽ͷ�¶�10", "" + mBatMgr.getSensorTemperatureByIndex(SensorTemperatureIndex.Index10) + "��C");
		mArrayList.add(e);
		// id = 14 index = 13
		e = new Element("̽ͷ�¶�11", "" + mBatMgr.getSensorTemperatureByIndex(SensorTemperatureIndex.Index11) + "��C");
		mArrayList.add(e);
		// id = 15 index = 14
		e = new Element("̽ͷ�¶�12", "" + mBatMgr.getSensorTemperatureByIndex(SensorTemperatureIndex.Index12) + "��C");
		mArrayList.add(e);
		// id = 16 index = 15
		e = new Element("���ϵͳ�¶�", "" + mBatMgr.getMotorSystemTemperature() + "��C");
		mArrayList.add(e);
		// id = 17 index = 16
		e = new Element("�����ص�ѹ 1", "" + mBatMgr.getSingleBatVoltageByIndex(SingleVoltageIndex.index1) + "V");
		mArrayList.add(e);
		// id = 18 index = 17
		e = new Element("�����ص�ѹ 2", "" + mBatMgr.getSingleBatVoltageByIndex(SingleVoltageIndex.index2) + "V");
		mArrayList.add(e);
		// id = 19 index = 18
		e = new Element("�����ص�ѹ 3", "" + mBatMgr.getSingleBatVoltageByIndex(SingleVoltageIndex.index3) + "V");
		mArrayList.add(e);
		// id = 20 index = 19
		e = new Element("�����ص�ѹ 4", "" + mBatMgr.getSingleBatVoltageByIndex(SingleVoltageIndex.index4) + "V");
		mArrayList.add(e);
		// id = 21 index = 20
		e = new Element("�����ص�ѹ 5", "" + mBatMgr.getSingleBatVoltageByIndex(SingleVoltageIndex.index5) + "V");
		mArrayList.add(e);
		// id = 22 index = 21
		e = new Element("�����ص�ѹ 6", "" + mBatMgr.getSingleBatVoltageByIndex(SingleVoltageIndex.index6) + "V");
		mArrayList.add(e);
		// id = 23 index = 22
		e = new Element("�����ص�ѹ 7", "" + mBatMgr.getSingleBatVoltageByIndex(SingleVoltageIndex.index7) + "V");
		mArrayList.add(e);
		// id = 24 index = 23
		e = new Element("�����ص�ѹ 8", "" + mBatMgr.getSingleBatVoltageByIndex(SingleVoltageIndex.index8) + "V");
		mArrayList.add(e);
		// id = 25 index = 24
		e = new Element("�����ص�ѹ 9", "" + mBatMgr.getSingleBatVoltageByIndex(SingleVoltageIndex.index9) + "V");
		mArrayList.add(e);
		// id = 26 index = 25
		e = new Element("�����ص�ѹ 10", "" + mBatMgr.getSingleBatVoltageByIndex(SingleVoltageIndex.index10) + "V");
		mArrayList.add(e);
		// id = 27 index = 26
		e = new Element("�����ص�ѹ 11", "" + mBatMgr.getSingleBatVoltageByIndex(SingleVoltageIndex.index11) + "V");
		mArrayList.add(e);
		// id = 28 index = 27
		e = new Element("�����ص�ѹ 12", "" + mBatMgr.getSingleBatVoltageByIndex(SingleVoltageIndex.index12) + "V");
		mArrayList.add(e);
		// id = 29 index = 28
		e = new Element("�����ص�ѹ 13", "" + mBatMgr.getSingleBatVoltageByIndex(SingleVoltageIndex.index13) + "V");
		mArrayList.add(e);
		// id = 30 index = 29
		e = new Element("�����ص�ѹ 14", "" + mBatMgr.getSingleBatVoltageByIndex(SingleVoltageIndex.index14) + "V");
		mArrayList.add(e);
		// id = 31 index = 30
		e = new Element("�����ص�ѹ 15", "" + mBatMgr.getSingleBatVoltageByIndex(SingleVoltageIndex.index15) + "V");
		mArrayList.add(e);
		// id = 32 index = 31
		e = new Element("�����ص�ѹ 16", "" + mBatMgr.getSingleBatVoltageByIndex(SingleVoltageIndex.index16) + "V");
		mArrayList.add(e);
		// id = 33 index = 32
		e = new Element("�����ص�ѹ 17", "" + mBatMgr.getSingleBatVoltageByIndex(SingleVoltageIndex.index17) + "V");
		mArrayList.add(e);
		// id = 34 index = 33
		e = new Element("�����ص�ѹ 18", "" + mBatMgr.getSingleBatVoltageByIndex(SingleVoltageIndex.index18) + "V");
		mArrayList.add(e);
		// id = 35 index = 34
		e = new Element("�����ص�ѹ 19", "" + mBatMgr.getSingleBatVoltageByIndex(SingleVoltageIndex.index19) + "V");
		mArrayList.add(e);
		// id = 36 index = 35
		e = new Element("�����ص�ѹ 20", "" + mBatMgr.getSingleBatVoltageByIndex(SingleVoltageIndex.index20) + "V");
		mArrayList.add(e);
		// id = 37 index = 36
		e = new Element("�����ص�ѹ 21", "" + mBatMgr.getSingleBatVoltageByIndex(SingleVoltageIndex.index21) + "V");
		mArrayList.add(e);
		// id = 38 index = 37
		e = new Element("�����ص�ѹ 22", "" + mBatMgr.getSingleBatVoltageByIndex(SingleVoltageIndex.index22) + "V");
		mArrayList.add(e);
		// id = 39 index = 38
		e = new Element("�����ص�ѹ 23", "" + mBatMgr.getSingleBatVoltageByIndex(SingleVoltageIndex.index23) + "V");
		mArrayList.add(e);
		// id = 40 index = 39
		e = new Element("�����ص�ѹ 24", "" + mBatMgr.getSingleBatVoltageByIndex(SingleVoltageIndex.index24) + "V");
		mArrayList.add(e);
		// id = 41 index = 40
		e = new Element("���ֱ��ĸ��ѹ", "" + mBatMgr.getVoltageOfMotorBusbar() + "V");
		mArrayList.add(e);
		// id = 42 index = 41
		e = new Element("12V���ص�ѹ", "" + mBatMgr.getVoltageOf12StorageBattery() + "V");
		mArrayList.add(e);
		// id = 43 index = 42
		e = new Element("������ʻ���", "" + mBatMgr.getTravelMileageRecorder() + "Km");
		mArrayList.add(e);
		
		// id = 150 index = 43
		e = new Element("����̤�忪��", "" + mBatMgr.getAccPedalPercent() + "%");
		mArrayList.add(e);
		// id = 151 index = 44
		e = new Element("ʣ�����", "" + mBatMgr.getRemaindEnergy() + "%");
		mArrayList.add(e);
		// id = 152 index = 45
		e = new Element("����鵱ǰ��SOC", "" + mBatMgr.getCurrentBatteryGrpSOC() + "%");
		mArrayList.add(e);
		// id = 153 index = 46
		e = new Element("��λ��Ϣ", "" + mBatMgr.getCarGearsInfo());
		mArrayList.add(e);
		// id = 154 index = 47
		e = new Element("�ƶ�̤���Ƿ����", "" + mBatMgr.getBreakPedalIsDownInfo());
		mArrayList.add(e);
		// id = 155 index = 48
		e = new Element("��ɲ�Ƿ�����", "" + mBatMgr.getHandBreakInfo());
		mArrayList.add(e);
		// id = 156 index = 49
		e = new Element("�����ǰ״̬", "" + mBatMgr.getCurrentMotorTotateSts());
		mArrayList.add(e);
		// id = 157 index = 50
		e = new Element("�����ͨѶ״̬", "" + mBatMgr.getBMSAndChargerConnectSts());
		mArrayList.add(e);
		// id = 158 index = 51
		e = new Element("��ذ�����״̬", "" + mBatMgr.getBatteryPkgBalanceSts());
		mArrayList.add(e);
		// id = 159 index = 52
		e = new Element("����鵱ǰ״̬", "" + mBatMgr.getCurrentBatteryGrpSts());
		mArrayList.add(e);
		// id = 160 index = 53
		e = new Element("��ӳ��������״̬", "" + mBatMgr.getExternalChargeLineConnectSts());
		mArrayList.add(e);
		// id = 161 index = 54
		e = new Element("�ܸ��Ӵ���KS״̬", "" + mBatMgr.getKSConactorSts());
		mArrayList.add(e);
		// id = 162 index = 55
		e = new Element("12V��Դ��λ", "" + mBatMgr.getGearsFor12VPowerSource());
		mArrayList.add(e);
		// id = 163 index = 56
		e = new Element("��������ͨ�Ͽ���", "" + mBatMgr.getConnecStsOfCarDriveCtl());
		mArrayList.add(e);
		// id = 164 index = 57
		e = new Element("BCM_GENѭ��������", "" + mBatMgr.getBcmGenLoopCount());
		mArrayList.add(e);
		// id = 165 index = 58
		e = new Element("BCM_SYSѭ��������", "" + mBatMgr.getBcmSysLoopCount());
		mArrayList.add(e);
	}
	
	private DataAdapter mAdapter;
	private ArrayList<Element> mArrayList = new ArrayList<Element>();
	
	private BatManager mBatMgr;
	
	private Button mRet, mGet;
	private ListView mList;
	
	private final String TAG = "cts";
	
	
	private View.OnClickListener mListner = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.bat_get:
				mArrayList.clear();
				if (mBatMgr != null) {
					mBatMgr.syncBatteryData();
				}
				initializeDataAdapter();
				notifyAdapter();
				break;
			case R.id.bat_return:
				Intent ret = new Intent(CtsBattery.this, MainActivity.class);
				startActivity(ret);
				finish();
				break;
			default: break;
			}
			
		}
	};
	
	private void notifyAdapter()
	{
		if (mAdapter != null) {
			mAdapter.notifyDataSetChanged();
		}
	}
	private BatListener mBatListener = new BatListener() {

		/**
		 * id = 1
		 */
		@Override
	    public void onBatVoltageChanged(float voltage)
	    {
			Log.d("BatProvider", "onBatVoltageChaned in BatListener : voltage=" + voltage);
		   	Element e = mArrayList.get(0);
			e.setmValue(voltage+"");
			notifyAdapter();
	    }
	   
		/**
		 * id = 2
		 */
		@Override
	    public void onBatAmpereChanged(float ampere)
	    {
	      	Log.d(TAG, "onBatAmpereChanged ampere = " + ampere );
		   	Element e = mArrayList.get(1);
			e.setmValue(ampere+"");
			notifyAdapter();
	    }
	   
	    /**
	     * id = 3
	     */
		@Override
	    public void onSpeedChanged(float speed)
	    {
		   Log.d("BatProvider", "onSpeedChanged in BatListener : speed=" + speed);
		   	Element e = mArrayList.get(2);
			e.setmValue(speed+"");
			notifyAdapter();
	    }
	   
	   /**
	    * id = 4 ~ 15
	    */
		@Override
	    public void onSensorTemperatureChanged(BatManager.SensorTemperatureIndex index, float temperature)
	    {
	       	Log.d(TAG, "onSensorTemperatureChanged index = " + index + ",temperature =" + temperature );
		   	Element e;
		   	switch(index.getValue()) {
		   	case 0: e = mArrayList.get(3); e.setmValue(temperature+"");break;
		   	case 1: e = mArrayList.get(4); e.setmValue(temperature+"");break;
		   	case 2: e = mArrayList.get(5); e.setmValue(temperature+"");break;
		   	case 3: e = mArrayList.get(6); e.setmValue(temperature+"");break;
		   	case 4: e = mArrayList.get(7); e.setmValue(temperature+"");break;
		   	case 5: e = mArrayList.get(8); e.setmValue(temperature+"");break;
		   	case 6: e = mArrayList.get(9); e.setmValue(temperature+"");break;
		   	case 7: e = mArrayList.get(10); e.setmValue(temperature+"");break;
		   	case 8: e = mArrayList.get(11); e.setmValue(temperature+"");break;
		   	case 9: e = mArrayList.get(12); e.setmValue(temperature+"");break;
		   	case 10: e = mArrayList.get(13); e.setmValue(temperature+"");break;
		   	case 11: e = mArrayList.get(14); e.setmValue(temperature+"");break;
		   	default:
		   	}
			notifyAdapter();
	    }
	   
	    /**
	     * id = 16
	     */
		@Override
	    public void onMotorSystemTemperatureChanged(float tempeature)
	    {
	    	Log.d(TAG, "onMotorSystemTemperatureChanged tempeature =" + tempeature );
		   	Element e = mArrayList.get(15);
			e.setmValue(tempeature+"");
			notifyAdapter();
	    }
	   
	   /**
	     * id = 17 ~ id = 40
	     */
		@Override
	    public void onSingleBatVoltageChanged(BatManager.SingleVoltageIndex index, float voltage)
	    {
	    	Log.d(TAG, "onSingleBatVoltageChanged index =" + index + ",voltage = " + voltage);
		   	Element e; 
		   	switch (index.getValue()) {
		   	case 0: e = mArrayList.get(16);e.setmValue(voltage+""); break;
		   	case 1: e = mArrayList.get(17);e.setmValue(voltage+""); break;
		   	case 2: e = mArrayList.get(18);e.setmValue(voltage+""); break;
		   	case 3: e = mArrayList.get(19);e.setmValue(voltage+""); break;
		   	case 4: e = mArrayList.get(20);e.setmValue(voltage+""); break;
		   	case 5: e = mArrayList.get(21);e.setmValue(voltage+""); break;
		   	case 6: e = mArrayList.get(22);e.setmValue(voltage+""); break;
		   	case 7: e = mArrayList.get(23);e.setmValue(voltage+""); break;
		   	case 8: e = mArrayList.get(24);e.setmValue(voltage+""); break;
		   	case 9: e = mArrayList.get(25);e.setmValue(voltage+""); break;
		   	case 10: e = mArrayList.get(26);e.setmValue(voltage+""); break;
		   	case 11: e = mArrayList.get(27);e.setmValue(voltage+""); break;
		   	case 12: e = mArrayList.get(28);e.setmValue(voltage+""); break;
		   	case 13: e = mArrayList.get(29);e.setmValue(voltage+""); break;
		   	case 14: e = mArrayList.get(30);e.setmValue(voltage+""); break;
		   	case 15: e = mArrayList.get(31);e.setmValue(voltage+""); break;
		   	case 16: e = mArrayList.get(32);e.setmValue(voltage+""); break;
		   	case 17: e = mArrayList.get(33);e.setmValue(voltage+""); break;
		   	case 18: e = mArrayList.get(34);e.setmValue(voltage+""); break;
		   	case 19: e = mArrayList.get(35);e.setmValue(voltage+""); break;
		   	case 20: e = mArrayList.get(36);e.setmValue(voltage+""); break;
		   	case 21: e = mArrayList.get(37);e.setmValue(voltage+""); break;
		   	case 22: e = mArrayList.get(38);e.setmValue(voltage+""); break;
		   	case 23: e = mArrayList.get(39);e.setmValue(voltage+""); break;
		   	default:break;
		   	}
			
			notifyAdapter();
	    }
	   
	   /**
	     * id = 41
	     */
		@Override
	    public void onVoltageOfMotorBusbarChanged(float voltage)
	    {
	    	Log.d(TAG, "onVoltageOfMotorBusbarChanged voltage = " + voltage);
		   	Element e = mArrayList.get(40);
			e.setmValue(voltage+"");
			notifyAdapter();
	    }
	   
	   /** 
	     * id = 42
	     */
		@Override
	    public void onVoltageOf12VStorageBatteryChanged(float voltage)
	    {
	     	Log.d(TAG, "onVoltageOf12VStorageBatteryChanged mileage = " + voltage);
		   	Element e = mArrayList.get(41);
			e.setmValue(voltage+"");
			notifyAdapter();
	    }

	  /**
	    * id = 43
	    */
		@Override
	    public void onTravelMileageRecorderChanged(float mileage){
	     	Log.d(TAG, "onTravelMileageRecorderChanged mileage = " + mileage);
		   	Element e = mArrayList.get(42);
			e.setmValue(mileage+"");
			notifyAdapter();
	    }
	  
	   /**
	     * id = 150 index = 43
	     */
		@Override
	    public void onAccPedalPercentChanged(int percent)
	    {
	     	Log.d(TAG, "onAccPedalPercentChanged percent = " + percent);
		   	Element e = mArrayList.get(43);
			e.setmValue(percent+"");
			notifyAdapter();
	    }
	   
	   /**
	     * id = 151 index = 44
	     */
		@Override
	    public void onRemaindEnergyChanged(int percent)
	    {
	     	Log.d(TAG, "onRemaindEnergyChanged percent = " + percent);
		   	Element e = mArrayList.get(44);
			e.setmValue(percent+"");
			notifyAdapter();
	    }
	   
	   /**
	     * id = 152 index = 45
	     */
		@Override
	    public void onCurrentBatteryGrpSOCChanged(int percent)
	    {
	      	Log.d(TAG, "onCarGearsInfoChanged percent = " + percent);
		   	Element e = mArrayList.get(45);
			e.setmValue(percent+"");
			notifyAdapter();
	    }
	   
	   /**
	     * id = 153 index = 46
	     */
		@Override
	    public void onCarGearsInfoChanged(BatManager.CarGearsInfo info)
	    {
	      	Log.d(TAG, "onCarGearsInfoChanged info = " + info);
		   	Element e = mArrayList.get(46);
			e.setmValue(info+"");
			notifyAdapter();
	    }
	   
	   /**
	     * id = 154 index = 47
	     */
		@Override
	    public void onBreakPedalInfoChanged(BatManager.BreakInfo info)
	    {
	      	Log.d(TAG, "onBreakPedalInfoChanged info = " + info);
		   	Element e = mArrayList.get(47);
			e.setmValue(info+"");
			notifyAdapter();
	    }
	   
	   /**
	     * id = 155 index = 48
	     */
		@Override
	    public void onHandBreakInfoChanged(BatManager.BreakInfo info)
	    {
	      	Log.d(TAG, "onHandBreakInfoChanged info = " + info);
		   	Element e = mArrayList.get(48);
			e.setmValue(info+"");
			notifyAdapter();
	    }
	   
	   /**
	     * id = 156 index = 49
	     */
		@Override
	    public void onCurrentMotorTotateStsChanged(BatManager.MotorTotateSts sts)
	    {
	    	Log.d(TAG, "onCurrentMotorTotateStsChanged sts = " + sts);
		   	Element e = mArrayList.get(49);
			e.setmValue(sts+"");
			notifyAdapter();
	    }
	   
	   /**
	     * id = 157 index = 50
	     */
		@Override
	    public void onBMSAndChargerConnectStsChanged(BatManager.ConnectInfo info)
	    {
	    	Log.d(TAG, "onBMSAndChargerConnectStsChanged info = " + info);
		   	Element e = mArrayList.get(50);
			e.setmValue(info+"");
			notifyAdapter();
	    }
	   
	   /**
	     * id = 158 index = 51
	     */
		@Override
	    public void onBatteryPkgBalanceStsChanged(BatManager.BatteryPkgBalanceSts sts)
	    {    	
	    	Log.d(TAG, "onBatteryPkgBalanceStsChanged sts = " + sts);
		   	Element e = mArrayList.get(51);
			e.setmValue(sts+"");
			notifyAdapter();
	    }
	   
	   /**
	     * id = 159  index = 52
	     */
		@Override
	    public void onCurrentBatteryGrpStsChanged(BatManager.BatteryGrpSts sts)
	    {
	    	Log.d(TAG, "onCurrentBatteryGrpStsChanged sts = " + sts);
		   	Element e = mArrayList.get(52);
			e.setmValue(sts+"");
			notifyAdapter();
	    }
	   
	   /**
	     * id = 160  index = 53
	     */
		@Override
	    public void onExternalChargeLineConnectStsChanged(BatManager.ConnectInfo info)
	    {
	    	Log.d(TAG, "onExternalChargeLineConnectStsChanged info = " + info);
		   	Element e = mArrayList.get(53);
			e.setmValue(info+"");
			notifyAdapter();
	    }
	   
	   /**
	     * id = 161 index = 54
	     */
		@Override
	    public void onKSConactorStsChanged(BatManager.KSConactorSts sts)
	    {
	    	Log.d(TAG, "onKSConactorStsChanged sts = " + sts);
		   	Element e = mArrayList.get(54);
			e.setmValue(sts+"");
			notifyAdapter();
	    }
	   
	   /**
	     * id = 162 index = 55
	     */
		@Override
	    public void onGearsOf12VPowerSource(BatManager.GearsFor12VPowerSource gears)
	    {
	    	Log.d(TAG, "onGearsOf12VPowerSource gears = " + gears);
		   	Element e = mArrayList.get(55);
			e.setmValue(gears+"");
			notifyAdapter();
	    }
	   
	   /**
	     * id = 163 index = 56
	     */
		@Override
	    public void onConnecStsOfCarDriveCtl(BatManager.ConnectInfo info)
	    {
	    	Log.d(TAG, "onConnecStsOfCarDriveCtl info = " + info);
		   	Element e = mArrayList.get(56);
			e.setmValue(info+"");
			notifyAdapter();
	    }
	   
	   /**
	     * id = 164  index = 57
	     */
		@Override
	    public void onBcmGenLoopCountChanged(int value)
	    {
	    	Log.d(TAG, "onBcmGenLoopCountChanged value = " + value);
		   	Element e = mArrayList.get(57);
			e.setmValue(value+"");
			notifyAdapter();
	    }
	   
	   /**
	     * id = 165  index = 58
	     */
		@Override
	    public void onBcmSysLoopCountChanged(int value)
	    {
	    	Log.d(TAG, "onBcmSysLoopCountChanged value = " + value);
		   	Element e = mArrayList.get(58);
			e.setmValue(value+"");
			notifyAdapter();
	    }
		
	};

}
