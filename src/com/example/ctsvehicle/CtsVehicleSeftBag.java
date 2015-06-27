package com.example.ctsvehicle;

import data.adapter.CommonActivity;
import data.adapter.Element;
import android.vehicle.vehicle.VehicleListener;
import android.vehicle.vehicle.VehicleManager;
import android.vehicle.vehicle.VehicleManager.SafeAirBagType;

public class CtsVehicleSeftBag extends CommonActivity {
	
	@Override
	public void initializeData() {
		mArrayList.add(new Element("左前安全气囊前", ""
				+ mVehicleMgr.getSafeAirBagByType(SafeAirBagType.LeftForthSeatForthBug)));
		mArrayList.add(new Element("左前安全气囊左", ""
				+ mVehicleMgr.getSafeAirBagByType(SafeAirBagType.LeftForthSeatLeftBug)));
		mArrayList.add(new Element("右前安全气囊前", ""
				+ mVehicleMgr.getSafeAirBagByType(SafeAirBagType.RightForthSeatForthBug)));
		mArrayList.add(new Element("右前安全气囊右", ""
				+ mVehicleMgr.getSafeAirBagByType(SafeAirBagType.RightForthSeatRightBug)));
		mArrayList.add(new Element("左后安全气囊左", ""
				+ mVehicleMgr.getSafeAirBagByType(SafeAirBagType.LeftBackSeatLeftBug)));
		mArrayList.add(new Element("右后安全气囊右", ""
				+ mVehicleMgr.getSafeAirBagByType(SafeAirBagType.RightBackSeatRightBug)));
	}

	@Override
	public VehicleListener getListener() {
		return mListener;
	}
	
	private VehicleListener mListener = new VehicleListener()
	{
		@Override
		public void onVehicleSafeAirBagInfoChanged(VehicleManager.SafeAirBagType type,
		        VehicleManager.OpenCloseSts sts)
		{
			
		}
	};

}
