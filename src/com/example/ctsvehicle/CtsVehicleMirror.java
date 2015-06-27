package com.example.ctsvehicle;

import data.adapter.CommonActivity;
import data.adapter.Element;
import android.vehicle.vehicle.VehicleListener;
import android.vehicle.vehicle.VehicleManager;
import android.vehicle.vehicle.VehicleManager.RearViewType;

public class CtsVehicleMirror extends CommonActivity {

	@Override
	public void initializeData() {
		mArrayList.add(new Element("����Ӿ�����", 
				"" + mVehicleMgr.getRearViewControlStsByType(RearViewType.Left)));
		mArrayList.add(new Element("�Һ��Ӿ�����", 
				"" + mVehicleMgr.getRearViewControlStsByType(RearViewType.Right)));
		
	}

	@Override
	public VehicleListener getListener() {
		// TODO �Զ����ɵķ������
		return mListener;
	}

	private VehicleListener mListener = new VehicleListener()
	{
		@SuppressWarnings("static-access")
		@Override
		public void onVehicleRearViewControlStsChanged(VehicleManager.RearViewType type,
		        VehicleManager.VehicleControlSts sts)
		{
			
			if (type.Left == type) {
				Element e = mArrayList.get(0);
				e.setmValue(sts + "");
			} else if (type.Right == type) {
				Element e = mArrayList.get(0);
				e.setmValue(sts + "");
			} else {
				
			}
			notifyAdapter();
		}
	};
}
