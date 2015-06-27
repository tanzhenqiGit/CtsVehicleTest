package com.example.ctsvehicle;

import data.adapter.CommonActivity;
import data.adapter.Element;
import android.vehicle.vehicle.VehicleListener;
import android.vehicle.vehicle.VehicleManager;
import android.vehicle.vehicle.VehicleManager.EnvironmentTemperature;

public class CtsVehicleTemperature extends CommonActivity {

	@Override
	public void initializeData() {
		
		mArrayList.add(new Element("车内温度", ""  
				+ mVehicleMgr.getEnvironmentTemperatureByType(EnvironmentTemperature.VehicleInside)));
		mArrayList.add(new Element("车外温度", ""  
				+ mVehicleMgr.getEnvironmentTemperatureByType(EnvironmentTemperature.VehicleOutside)));
	}

	@Override
	public VehicleListener getListener() {
		return mListener;
	}

	private VehicleListener mListener = new VehicleListener()
	{
		@Override
		public void onVehicleEnvironTemperatureChanged(VehicleManager.EnvironmentTemperature type,
		        int temperature)
		{
			Element e;
			switch (type.getValue()) {
			case 0: //inside
				e = mArrayList.get(0);
				e.setmValue(temperature + "");
				break;
			case 1: //outside
				e = mArrayList.get(1);
				e.setmValue(temperature + "");
				break;
			default:
				
				break;
			}
			notifyAdapter();
		}
	};
}
