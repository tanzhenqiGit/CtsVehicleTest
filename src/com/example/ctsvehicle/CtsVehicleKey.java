package com.example.ctsvehicle;

import data.adapter.CommonActivity;
import data.adapter.Element;

import android.vehicle.vehicle.VehicleListener;
import android.vehicle.vehicle.VehicleManager;

public class CtsVehicleKey extends CommonActivity {

	@Override
	public void initializeData() {
		mArrayList.add(new Element("钥匙位置信息", ""+  mVehicleMgr.getKeyPositionInfo()));
		mArrayList.add(new Element("遥控钥匙电池电量是否", ""+  mVehicleMgr.getKeyRemoteCtlBatterySts()));
		mArrayList.add(new Element("遥控钥匙电池生命信号", ""+  mVehicleMgr.getKeyRomoteCtlBatteryVolume()));
	}

	@Override
	public VehicleListener getListener() {
		return mListener;
	}
	
	private VehicleListener mListener = new VehicleListener()
	{
		@Override
		public void onVehicleKeyPositionChanged(VehicleManager.KeyPositionInfo position)
	    {
			Element e = mArrayList.get(0);
			e.setmValue(position + "");
			notifyAdapter();
	    }
		@Override
		public void onVehicleKeyRemoteCtlBatteryStsChanged(VehicleManager.KeyRemoteCtlBatterySts sts)
		{
			Element e = mArrayList.get(1);
			e.setmValue(sts + "");
			notifyAdapter();
		}
		@Override
		public void onVehicleKeyRemoteCtlBatteryVolumeChanged(int value)
		{
			Element e = mArrayList.get(2);
			e.setmValue(value + "");
			notifyAdapter();
		}

		
	};
}
