package com.example.ctsvehicle;

import data.adapter.CommonActivity;
import data.adapter.Element;
import android.vehicle.vehicle.VehicleListener;
import android.vehicle.vehicle.VehicleManager;
import android.vehicle.vehicle.VehicleManager.SafetyBeltType;


public class CtsVehicleSeftBelt extends CommonActivity {

	@Override
	public void initializeData() {
		mArrayList.add(new Element("��ǰ��ȫ���Ƿ����", 
				"" + mVehicleMgr.getSafetyBeltStsByType(SafetyBeltType.LeftForth)));
		mArrayList.add(new Element("��ǰ��ȫ���Ƿ����", 
				"" + mVehicleMgr.getSafetyBeltStsByType(SafetyBeltType.RightForth)));
		mArrayList.add(new Element("���ȫ���Ƿ����", 
				"" + mVehicleMgr.getSafetyBeltStsByType(SafetyBeltType.LeftBack)));
		mArrayList.add(new Element("�Һ�ȫ���Ƿ����", 
				"" + mVehicleMgr.getSafetyBeltStsByType(SafetyBeltType.RightBack)));
		mArrayList.add(new Element("���а�ȫ���Ƿ����", 
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
