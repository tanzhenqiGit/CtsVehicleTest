package com.example.ctsvehicle;

import data.adapter.CommonActivity;
import data.adapter.Element;
import android.util.Log;
import android.vehicle.vehicle.VehicleListener;
import android.vehicle.vehicle.VehicleManager;

public class CtsVehicleAirCondition extends CommonActivity {

	@Override
	public void initializeData() {
		/**
		 * id = 0
		 */
		mArrayList.add(new Element("空调使能" , "" + mVehicleMgr.getPowerSwitchSts()));
		/**
		 * id = 1
		 */
		mArrayList.add(new Element("循环模式" , "" + mVehicleMgr.getCycleMode()));
		/**
		 * id = 2
		 */
		mArrayList.add(new Element("除霜" , "" + mVehicleMgr.getForstMode()));

		/**
		 * id = 3
		 */
		mArrayList.add(new Element("信号" , "" + mVehicleMgr.getSigleType()));
		/**
		 * id = 4
		 */
		mArrayList.add(new Element("设置模式" , "" + mVehicleMgr.getAirConditionSettingMode()));
		/**
		 * id = 5
		 */
		mArrayList.add(new Element("风向" , "" + mVehicleMgr.getWindDirection()));
		/**
		 * id = 6
		 */
		mArrayList.add(new Element("风量最大值" , "" + mVehicleMgr.getWindVolumeMax()));
		/**
		 * id = 7
		 */
		mArrayList.add(new Element("风量最小值" , "" + mVehicleMgr.getWindVolumeMin()));
		/**
		 * id = 8
		 */
		mArrayList.add(new Element("当前风量值" , "" + mVehicleMgr.getWindCurVolume()));
		/**
		 * id = 9
		 */
		mArrayList.add(new Element("温度最大值/冷热度最大值" , "" + mVehicleMgr.getTemperatureOrHeatMax()));
		/**
		 * id = 10
		 */
		mArrayList.add(new Element("温度最小值/冷热度最小值" , "" + mVehicleMgr.getTemperatureOrHeatMin()));
		/**
		 * id = 11
		 */
		mArrayList.add(new Element("实际温度/冷热度" , "" + mVehicleMgr.getCurTemperatureOrHeat()));
		/**
		 * id = 12
		 */
		mArrayList.add(new Element("设定温度" , "" + mVehicleMgr.getCurSettingTemperature()));
		/**
		 * id = 13
		 */
		mArrayList.add(new Element("功率" , "" + mVehicleMgr.getAirConditionPower()));

	}

	@Override
	public VehicleListener getListener() {
		// TODO 自动生成的方法存根
		return mListener;
	}
	
	private final String TAG = "cts";
	
	private VehicleListener mListener = new VehicleListener()
	{
		
		public void onAirConditionPowerStsChanged(VehicleManager.PowerSwitchSts sts)
	    {
	        Log.d(TAG, "in vehicle Listener onAirConditionPowerStsChanged sts = " + sts);
	        Element e = mArrayList.get(0);
	        e.setmValue("" + sts);
	        notifyAdapter();
	    }

	    /**
	      * called when vehicle aircondition cycle mode changed.
	      *
	      * @param mode InSideMode,  OutSideMode,  Unkknow
	      * reminder (type = 12, id = 10)
	      */
	    public void onAirConditionCycleModeChanged(VehicleManager.CycleMode mode)
	    {
	        Log.d(TAG, "in vehicle Listener onAirConditionCycleModeChanged mode=" + mode);
	        Element e = mArrayList.get(1);
	        e.setmValue("" + mode);
	        notifyAdapter();
	    }
	    
	    /**
	      * called when vehicle aircondition forst mode changed.
	      *
	      * @param mode Deforst, Forst, UnKnow
	      * reminder (type = 12, id = 10)
	      */
	    public void onAirConditionForstModeChanged(VehicleManager.ForstMode mode)
	    {
	        Log.d(TAG, "in vehicle Listener onAirConditionForstModeChanged mode = " + mode);
	        Element e = mArrayList.get(2);
	        e.setmValue("" + mode);
	        notifyAdapter();
	    }
	    
	    /**
	      * called when vehicle aircondition signal type changed.
	      *
	      * @param type Analog, Digit, UnKnow
	      * reminder (type = 12, id = 10)
	      */
	    public void onAirConditionSignalTypeChanged(VehicleManager.SigleType type)
	    {
	        Log.d(TAG, "in vehicle Listener onAirConditionSignalTypeChanged type =" + type);
	        Element e = mArrayList.get(3);
	        e.setmValue("" + type);
	        notifyAdapter();
	    }
	    
	    /**
	      * called when vehicle aircondition setting mode changed.
	      *
	      * @param mode Cooling(0), Heating(1),  Auto(2),  Ventilate(3),  Economy(4), UnKnow(5)
	      * reminder (type = 12, id = 10)
	      */
	    public void onAirConditionSettingModeChanged(VehicleManager.AirConditionSettingMode mode)
	    {
	        Log.d(TAG, "in vehicle Listener onAirConditionSettingModeChanged mode=" + mode);
	        Element e = mArrayList.get(4);
	        e.setmValue("" + mode);
	        notifyAdapter();
	    }
	    
	    /**
	      * called when vehicle aircondition wind direction changed.
	      *
	      * @param direction  ToFace(0), ToLeg(1),  BothFaceAndLeg(2), ToLegAndWindow(3), ToWindow(4), Unknow(5)
	      * reminder (type = 12, id = 10)
	      */
	    public void onAirConditionWindDirectionChanged(VehicleManager.WindDirection direction)
	    {
	        Log.d(TAG, "in vehicle Listener onAirConditionWindDirectionChanged direction = " + direction);
	        Element e = mArrayList.get(5);
	        e.setmValue("" + direction);
	        notifyAdapter();
	    }
	    
	    /**
	      * called when vehicle aircondition wind max volume changed.
	      *
	      * @param volume 0 ~ 255 
	      * reminder (type = 12, id = 10)
	      */
	    public void onAirConditionWindVolumeMaxChanged(int volume)
	    {
	        Log.d(TAG, "in vehicle Listener onAirConditionWindVolumeMaxChanged volume =" + volume);
	        Element e = mArrayList.get(6);
	        e.setmValue("" + volume);
	        notifyAdapter();
	    }

	    /**
	      * called when vehicle aircondition wind min volume changed.
	      *
	      * @param volume  0 ~ 255 
	      * reminder (type = 12, id = 10)
	      */
	    public void onAirConditionWindVolumeMinChanged(int volume)
	    {
	        Log.d(TAG, "in vehicle Listener onAirConditionWindVolumeMinChanged volume =" + volume);
	        Element e = mArrayList.get(7);
	        e.setmValue("" + volume);
	        notifyAdapter();
	    }

	    /**
	      * called when vehicle aircondition wind current volume changed.
	      *
	      * @param volume 0 ~ 255 
	      * reminder (type = 12, id = 10)
	      */
	    public void onAirConditionWindVolumeCurChanged(int volume)
	    {
	        Log.d(TAG, "in vehicle Listener onAirConditionWindVolumeChanged volume =" + volume);
	        Element e = mArrayList.get(8);
	        e.setmValue("" + volume);
	        notifyAdapter();
	    }

	    /**
	      * called when vehicle aircondition wind max temperature or heat changed.
	      *
	      * @param max 0 ~ 255 
	      * reminder (type = 12, id = 10)
	      */
	    public void onAirConditionTemperatureOrHeatMaxChanged(int max)
	    {
	        Log.d(TAG, "in vehicle Listener onAirConditionTemperatureOrHeatMaxChanged max =" + max);
	        Element e = mArrayList.get(9);
	        e.setmValue("" + max);
	        notifyAdapter();
	    }
	    
	    /**
	      * called when vehicle aircondition wind min temperature or heat changed.
	      *
	      * @param min 0 ~ 255 
	      * reminder (type = 12, id = 10)
	      */
	    public void onAirConditionTemperatureOrHeatMinChanged(int min)
	    {
	        Log.d(TAG, "in vehicle Listener onAirConditionTemperatureOrHeatMinChanged min =" + min);
	        Element e = mArrayList.get(10);
	        e.setmValue("" + min);
	        notifyAdapter();
	    }
	    
	    /**
	      * called when vehicle aircondition wind current temperature or heat changed.
	      *
	      * @param cur 0 ~ 255 
	      * reminder (type = 12, id = 10)
	      */
	    public void onAirConditionTemperatureOrHeatCurChanged(int cur)
	    {
	        Log.d(TAG, "in vehicle Listener onAirConditionTemperatureOrHeatCurChanged cur =" + cur);
	        Element e = mArrayList.get(11);
	        e.setmValue("" + cur);
	        notifyAdapter();
	    }

	    /**
	      * called when vehicle aircondition Setting temperature changed.
	      *
	      * @param temp 0 ~ 255 
	      * reminder (type = 12, id = 10)
	      */
	    public void onAirConditionSettingTemperatureChanged(int temp)
	    {
	        Log.d(TAG, "in vehicle Listener onAirConditionSettingTemperatureChanged temp = " + temp);
	        Element e = mArrayList.get(12);
	        e.setmValue("" + temp);
	        notifyAdapter();
	    }
	    
	    /**
	      * called when vehicle aircondition power changed.
	      *
	      * @param power 0 ~ 255 
	      * reminder (type = 12, id = 10)
	      */
	    public void onAirConditionPowerChanged(int power)
	    {
	        Log.d(TAG, "in vehicle Listener onAirConditionPowerChanged power = " + power);
	        Element e = mArrayList.get(13);
	        e.setmValue("" + power);
	        notifyAdapter();
	    }
	};

}
