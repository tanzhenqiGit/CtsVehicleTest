package com.example.ctsvehicle;


import data.adapter.CommonActivity;
import data.adapter.Element;
import android.vehicle.vehicle.VehicleListener;


public class CtsVehicleVin extends CommonActivity {

	@Override
	public void initializeData() {
		Element e;
		e = new Element("vin��", mVehicleMgr.getVehicleVinCode());
		mArrayList.add(e);
		
	}


	@Override
	public VehicleListener getListener() {
		// TODO �Զ����ɵķ������
		return mListener;
	}
	

	private VehicleListener mListener = new VehicleListener()
	{
		@Override
		public void onVehicleVinCodeChanged(String vinCode)
		{
			Element e = mArrayList.get(0);
			e.setmValue(vinCode);
			notifyAdapter();
		}
	};
	

}
