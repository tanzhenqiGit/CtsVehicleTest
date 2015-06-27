package com.example.ctsvehicle;

import data.adapter.CommonActivity;
import data.adapter.Element;
import android.vehicle.vehicle.VehicleListener;
import android.vehicle.vehicle.VehicleManager;
import android.vehicle.vehicle.VehicleManager.SafeAirBagType;

public class CtsVehicleSeftBag extends CommonActivity {
	
	@Override
	public void initializeData() {
		mArrayList.add(new Element("��ǰ��ȫ����ǰ", ""
				+ mVehicleMgr.getSafeAirBagByType(SafeAirBagType.LeftForthSeatForthBug)));
		mArrayList.add(new Element("��ǰ��ȫ������", ""
				+ mVehicleMgr.getSafeAirBagByType(SafeAirBagType.LeftForthSeatLeftBug)));
		mArrayList.add(new Element("��ǰ��ȫ����ǰ", ""
				+ mVehicleMgr.getSafeAirBagByType(SafeAirBagType.RightForthSeatForthBug)));
		mArrayList.add(new Element("��ǰ��ȫ������", ""
				+ mVehicleMgr.getSafeAirBagByType(SafeAirBagType.RightForthSeatRightBug)));
		mArrayList.add(new Element("���ȫ������", ""
				+ mVehicleMgr.getSafeAirBagByType(SafeAirBagType.LeftBackSeatLeftBug)));
		mArrayList.add(new Element("�Һ�ȫ������", ""
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
