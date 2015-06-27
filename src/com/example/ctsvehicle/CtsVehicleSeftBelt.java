package com.example.ctsvehicle;

import data.adapter.CommonActivity;
import data.adapter.Element;
import android.vehicle.vehicle.VehicleListener;
import android.vehicle.vehicle.VehicleManager;
import android.vehicle.vehicle.VehicleManager.SafetyBeltType;


public class CtsVehicleSeftBelt extends CommonActivity {

	@Override
	public void initializeData() {
		mArrayList.add(new Element("左前安全带是否扣上", 
				"" + mVehicleMgr.getSafetyBeltStsByType(SafetyBeltType.LeftForth)));
		mArrayList.add(new Element("右前安全带是否扣上", 
				"" + mVehicleMgr.getSafetyBeltStsByType(SafetyBeltType.RightForth)));
		mArrayList.add(new Element("左后安全带是否扣上", 
				"" + mVehicleMgr.getSafetyBeltStsByType(SafetyBeltType.LeftBack)));
		mArrayList.add(new Element("右后安全带是否扣上", 
				"" + mVehicleMgr.getSafetyBeltStsByType(SafetyBeltType.RightBack)));
		mArrayList.add(new Element("后中安全带是否扣上", 
				"" + mVehicleMgr.getSafetyBeltStsByType(SafetyBeltType.MidBack)));
		
	}


	@Override
	public VehicleListener getListener() {
		return mListener;
	}

	private VehicleListener mListener = new VehicleListener()
	{
		@Override
		public void onVehicleSafetyBeltStsChanged(VehicleManager.SafetyBeltType type,
		        VehicleManager.SafetyBeltSts sts)
		{
			Element e;
			switch (type.getValue()) {
			case 0:
				e = mArrayList.get(0);
				e.setmValue("" + sts);
				break;
			case 1:
				e = mArrayList.get(1);
				e.setmValue("" + sts);
				break;
			case 2:
				e = mArrayList.get(2);
				e.setmValue("" + sts);
				break;
			case 3:
				e = mArrayList.get(3);
				e.setmValue("" + sts);
				break;
			case 4:
				e = mArrayList.get(4);
				e.setmValue("" + sts);
				break;
			default: break;
			}
			notifyAdapter();
		}
	};

}
