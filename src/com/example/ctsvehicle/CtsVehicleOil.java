package com.example.ctsvehicle;

import data.adapter.CommonActivity;
import data.adapter.Element;
import android.vehicle.vehicle.VehicleListener;
import android.vehicle.vehicle.VehicleManager;

public class CtsVehicleOil extends CommonActivity {

	@Override
	public void initializeData() {
		mArrayList.add(new Element("”Õœ‰√≈", "" + mVehicleMgr.getVehicleOilTankSts()));
	}

	@Override
	public VehicleListener getListener() {
		return mListener;
	}
	
	private VehicleListener mListener = new VehicleListener()
	{
		@Override
		public void onVehicleOilTankDoorChanged(VehicleManager.OpenCloseSts sts)
		{
			Element e = mArrayList.get(0);
			e.setmValue(sts + "");
			notifyAdapter();
		}
	};

}
