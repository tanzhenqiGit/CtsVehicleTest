package com.example.ctsvehicle;

import data.adapter.CommonActivity;
import data.adapter.Element;
import android.util.Log;
import android.vehicle.vehicle.VehicleListener;
import android.vehicle.vehicle.VehicleManager;
import android.vehicle.vehicle.VehicleManager.ADASErrorInfoType;
import android.vehicle.vehicle.VehicleManager.ADASInvalidInfoType;

public class CtsVehicleADAS extends CommonActivity {

	@Override
	public void initializeData() {
		/**
		 * id = 0
		 */
		mArrayList.add(new Element("ADAS控制命令代码", "" + mVehicleMgr.getADASCtlCommandCode()));
		/**
		 * id = 1
		 */
		mArrayList.add(new Element("ADAS命令状态", "" + mVehicleMgr.getADASCommandSts()));
		/**
		 * id = 2
		 */
		mArrayList.add(new Element("ADAS返回数据长度", "" + mVehicleMgr.getADASReturnDataLength()));
		/**
		 * id = 3
		 */
		byte[] array = mVehicleMgr.getADASReturnData();
		StringBuilder sb = new StringBuilder();
		if (array == null) {
			sb.append("null");
		} else {
			for (int i = 0; i < array.length; i++) {
				sb.append(array[i] + " ");
			}
		}
		mArrayList.add(new Element("ADAS返回数据", "" + sb));
		/**
		 * id = 4
		 */
		mArrayList.add(new Element("ADAS Left Lane Detected", 
				"" + mVehicleMgr.getADASLeftLaneDetectedSts()));
		/**
		 * id = 5
		 */
		mArrayList.add(new Element("ADAS Lane Departure Left", 
				"" + mVehicleMgr.getLeftLaneDepartureSts()));
		/**
		 * id = 6
		 */
		mArrayList.add(new Element("ADAS Right Lane Detected", 
				"" + mVehicleMgr.getRightLaneDepartureSts()));
		/**
		 * id = 7
		 */
		mArrayList.add(new Element("ADAS Lane Departure Right", 
				"" + mVehicleMgr.getRightLaneDepartureSts()));
		/**
		 * id = 8
		 */
		mArrayList.add(new Element("ADAS Vehicle Decect Result",
				"" + mVehicleMgr.getADASDepartureResult()));
		/**
		 * id = 9
		 */
		mArrayList.add(new Element("ADAS FCWS距离前车距离信息",
				"" + mVehicleMgr.getADASFrontVehicleDistance()));
		
		/**
		 * id = 10
		 */
		mArrayList.add(new Element("ADAS Error Information Calibration",
				"" + mVehicleMgr.getADASInfoErrorStsByType(ADASErrorInfoType.CalibrationSts)));
		/**
		 * id = 11
		 */
		mArrayList.add(new Element("ADAS Error Information Camera",
				"" + mVehicleMgr.getADASInfoErrorStsByType(ADASErrorInfoType.CameraSts)));
		/**
		 * id = 12
		 */
		mArrayList.add(new Element("ADAS Error Information controller",
				"" + mVehicleMgr.getADASInfoErrorStsByType(ADASErrorInfoType.ControllerSts)));
		/**
		 * id = 13
		 */
		mArrayList.add(new Element("ADAS Error Information can",
				"" + mVehicleMgr.getADASInfoErrorStsByType(ADASErrorInfoType.CanSts)));
		
		
		/**
		 * id = 14
		 */
		mArrayList.add(new Element("ADAS Invalid Information CameraSts",
				"" + mVehicleMgr.getADASInfoValidSts(ADASInvalidInfoType.CameraSts)));
		/**
		 * id = 15
		 */
		mArrayList.add(new Element("ADAS Invalid Information ImageContrast",
				"" + mVehicleMgr.getADASInfoValidSts(ADASInvalidInfoType.ImageContrast)));
		/**
		 * id = 16
		 */
		mArrayList.add(new Element("ADAS Invalid Information VehicleSingle",
				"" + mVehicleMgr.getADASInfoValidSts(ADASInvalidInfoType.VehicleSingle)));
		
		/**
		 * id = 17
		 */
		mArrayList.add(new Element("ADAS左车轮与左车道线距离",
				"" + mVehicleMgr.getADASDistanceLeftLaneAndLeftWheel()));
		/**
		 * id = 18
		 */
		mArrayList.add(new Element("ADAS右车轮与右车道线距离",
				"" + mVehicleMgr.gtADASDistanceRightLaneAndRightWheel()));
		/**
		 * id = 19
		 */
		mArrayList.add(new Element("ADAS Crash Time",
				"" + mVehicleMgr.getADASCrashTime()));
		/**
		 * id = 20
		 */
		mArrayList.add(new Element("ADAS LDWS当前状态",
				"" + mVehicleMgr.getADASLDWSSts()));
		/**
		 * id = 21
		 */
		mArrayList.add(new Element("ADAS FCWS当前状态",
				"" + mVehicleMgr.getADASFCWSSts()));
		
	}

	@Override
	public VehicleListener getListener() {
		return mListener;
	}

	private final String TAG = "cts";
	private VehicleListener mListener = new VehicleListener()
	{
		/**
		 * id = 0
		 */
		@Override
		public void onVehicleADASCommandCodeChanged(int value)
	    {
	    	Element e = mArrayList.get(0);
	    	e.setmValue("" + value);
	    	notifyAdapter();
	    }
	    
	    /**
	     * called when vehicle ADAS command code status changed
	     *
	     * @param sts
	     * reminder(type = 12, id = 8)
	     */
		@Override
	    public void onVehicleADASCommandCodeStsChanged(VehicleManager.ADASCommandSts sts)
	    {
	    	Log.d(TAG, "onVehicleADASCommandCodeStsChanged value = " + sts);
	    	Element e = mArrayList.get(1);
	    	e.setmValue("" + sts);
	    	notifyAdapter();
	    }
	    
	    /**
	     * called when vehicle ADAS return data length changed
	     *
	     * @param vlaue
	     * reminder(type = 12, id = 8)
	     */
		@Override
	    public void onVehicleADASReturnDataLengthChanged(int value)
	    {
	    	Log.d(TAG, "onADASReturnDataLengthChanged value=" + value);
	    	Element e = mArrayList.get(2);
	    	e.setmValue("" + value);
	    	notifyAdapter();
	    }
	    
	    /**
	     * called when vehicle ADAS return data  changed
	     *
	     * @param array
	     * reminder(type = 12, id = 8)
	     */
		@Override
	    public void onVehicleADASReturnDataChanged(byte[] array)
	    {
	    	Element e = mArrayList.get(3);
	    
	    	StringBuilder sb = new StringBuilder();
			if (array == null) {
				sb.append("null");
			} else {
				for (int i = 0; i < array.length; i++) {
					sb.append(array[i] + " ");
				}
			}
	    	e.setmValue("" + sb);
	    	notifyAdapter();
	    }
	    /**
	     * called when vehicle ADAS left lane detected status changed
	     *
	     * @param sts
	     * reminder(type = 12, id = 8)
	     */
		@Override
	    public void onVehicleADASLeftLaneDetectedStsChanged(VehicleManager.ADASDetectedLaneSts sts)
	    {
		  	Element e = mArrayList.get(4);
	    	e.setmValue("" + sts);
	    	notifyAdapter();
	    }
	    
	    /**
	     * called when vehicle ADAS left lane departure status changed
	     *
	     * @param sts
	     * reminder(type = 12, id = 8)
	     */
		@Override
	    public void onVehicleADASLeftLaneDepartureStsChanged(VehicleManager.ADASLaneDepartureSts sts)
	    {
	    	Log.d(TAG, "onVehicleLeftLaneDepartureStsChanged value=" + sts);
	    	Element e = mArrayList.get(5);
	    	e.setmValue("" + sts);
	    	notifyAdapter();
	    }
	    
	    /**
	     * called when vehicle ADAS right lane detected status changed
	     *
	     * @param sts
	     * reminder(type = 12, id = 8)
	     */
		@Override
	    public void onVehicleADASRightLaneDetectedStsChanged(VehicleManager.ADASDetectedLaneSts sts)
	    {
	    	Log.d(TAG, "onVehicleADASLeftLaneDetectedStsChanged value=" + sts);
	    	Element e = mArrayList.get(6);
	    	e.setmValue("" + sts);
	    	notifyAdapter();
	    }
	    
	    /**
	     * called when vehicle ADAS right lane departure status changed
	     *
	     * @param sts
	     * reminder(type = 12, id = 8)
	     */
		@Override
	    public void onVehicleADASRightLaneDepartureStsChanged(VehicleManager.ADASLaneDepartureSts sts)
	    {
	    	Log.d(TAG, "onVehicleLeftLaneDepartureStsChanged value=" + sts);
	    	Element e = mArrayList.get(7);
	    	e.setmValue("" + sts);
	    	notifyAdapter();
	    }
	    

	    /**
	     * called when vehicle ADAS departure result changed
	     *
	     * @param result
	     * reminder(type = 12, id = 8)
	     */
		@Override
	    public void onVehicleADASDepartureResultChanged(VehicleManager.ADASDepartureResult result)
	    {
	    	Log.d(TAG, "onVehicleADASDepartureResultChanged result=" + result);
	    	Element e = mArrayList.get(8);
	    	e.setmValue("" + result);
	    	notifyAdapter();
	    }
	    /**
	     * called when vehicle ADAS front vehicle distance changed
	     *
	     * @param sts
	     * reminder(type = 12, id = 8)
	     */
		@Override
	    public void onADASFrontVehicleDistanceChanged(VehicleManager.ADASFrontVehicleDistance sts)
	    {
	    	Log.d(TAG, "onADASFrontVehicleDistanceChanged sts=" + sts);
	    	Element e = mArrayList.get(9);
	    	e.setmValue("" + sts);
	    	notifyAdapter();
	    }
	    
	    /**
	     * called when vehicle ADAS info error status changed
	     *
	     * @param type
	     * @param sts
	     * reminder(type = 12, id = 8)
	     */
		@Override
	    public void onVehicleADASInfoErrorStsChanged(VehicleManager.ADASErrorInfoType type, 
	    		VehicleManager.ADASInfoErrorSts sts)
	    {
			Element e; 
	    	Log.d(TAG, "onVehicleADASInfoErrorStsChanged type=" + type + ",sts = " + sts);
	    	switch (type.getValue()) {
	    	case 0:
	    		e = mArrayList.get(10);
	    		e.setmValue("" + sts);
	    		break;
	    	case 1:
	    		e = mArrayList.get(11);
	    		e.setmValue("" + sts);
	    		break;
	    	case 2:
	    		e = mArrayList.get(12);
	    		e.setmValue("" + sts);
	    		break;
	    	case 3:
	    		e = mArrayList.get(13);
	    		e.setmValue("" + sts);
	    		break;
	    	default:
	    		
	    		break;
	    	}
	    	notifyAdapter();
	    }
	    
	    /**
	     * called when vehicle ADAS info valid status changed
	     *
	     * @param type
	     * @param sts
	     * reminder(type = 12, id = 8)
	     */
		@Override
	    public void onVehicleADASInfoValidStsChanged(VehicleManager.ADASInvalidInfoType type,
	    		VehicleManager.ADASInfoValidSts sts)
	    {
			Element e; 
	    	Log.d(TAG, "onVehicleADASInfoValidStsChanged type=" + type + ",sts = " + sts);
	    	switch (type.getValue())
	    	{
	    	case 0:
	    		e = mArrayList.get(14);
	    		e.setmValue("" + sts);
	    		break;
	    	case 1:
	    		e = mArrayList.get(15);
	    		e.setmValue("" + sts);
	    		break;
	    	case 2:
	    		e = mArrayList.get(16);
	    		e.setmValue("" + sts);
	    		break;
	    	default:
	    		
	    		break;
	    	}
	    	notifyAdapter();
	    }
	    /**
	     * called when vehicle ADAS distance of left lane and left wheel  changed
	     *
	     * @param distance
	     * reminder(type = 12, id = 8)
	     */
		@Override
	    public void onVehicleDistanceOfLeftLaneAndLeftWheelChanged(float distance)
	    {
			Element e = mArrayList.get(17);
	    	e.setmValue("" + distance);
	    	notifyAdapter();
	    }
	    /**
	     * called when vehicle ADAS distance of right lane and right wheel  changed
	     *
	     * @param distance
	     * reminder(type = 12, id = 8)
	     */
		@Override
	    public void onVehicleDistanceOfRightLaneAndRightWheelChanged(float distance)
	    {
			Element e = mArrayList.get(18);
	    	e.setmValue("" + distance);
	    	notifyAdapter();
	    }
	    /**
	     * called when vehicle ADAS crash time changed
	     *
	     * @param time
	     * reminder(type = 12, id = 8)
	     */
		@Override
	    public void onVehicleADASCrashTimeChanged(float time)
	    {
			Element e = mArrayList.get(19);
	    	e.setmValue("" + time);
	    	notifyAdapter();
	    }
	    
	    /**
	     * called when vehicle ADAS LDWS   status changed.
	     *
	     * @param sts
	     * reminder(type = 12, id = 8)
	     */
		@Override
	    public void onVehicleADASLDWSStsChanged(int sts)
	    {
			Element e = mArrayList.get(20);
			e.setmValue("" + sts);
			notifyAdapter();
	    }
	    
	    /**
	      * called when ADAS FCWS  status changed.
	      *
	      * @param sts
	      * reminder(type = 12, id = 8)
	      */
		@Override
	    public void onVehicleADASFCWSStsChanged(int sts)
	    {	
			Element e = mArrayList.get(21);
			e.setmValue("" + sts);
			notifyAdapter();
	    }
	};
}
