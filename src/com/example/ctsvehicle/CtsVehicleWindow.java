package com.example.ctsvehicle;

import android.vehicle.vehicle.VehicleListener;
import android.vehicle.vehicle.VehicleManager;
import android.vehicle.vehicle.VehicleManager.VehicleWindowType;
import data.adapter.CommonActivity;
import data.adapter.Element;



public class CtsVehicleWindow extends CommonActivity {

	@Override
	public void initializeData() {
		
		mArrayList.add(new Element("��ǰ�����������״̬", 
				"" + mVehicleMgr.getVehicleWindowStsByType(VehicleWindowType.LeftForth)));
		mArrayList.add(new Element("��ǰ�����������״̬", 
				"" + mVehicleMgr.getVehicleWindowStsByType(VehicleWindowType.RightForth)));
		mArrayList.add(new Element("������������״̬", 
				"" + mVehicleMgr.getVehicleWindowStsByType(VehicleWindowType.LeftBack)));
		mArrayList.add(new Element("�Һ����������״̬", 
				"" + mVehicleMgr.getVehicleWindowStsByType(VehicleWindowType.RightBack)));
		
		mArrayList.add(new Element("�촰����״̬", 
				"" + mVehicleMgr.getVehicleSkyLightSts()));
		mArrayList.add(new Element("�󵲷粣�����ȿ���", 
				"" + mVehicleMgr.getVehicleWindShieldHeatingSts()));
	}

	@Override
	public VehicleListener getListener() {
		// TODO �Զ����ɵķ������
		return mListener;
	}

	private VehicleListener mListener = new VehicleListener()
	{
		@Override
		public void onVehicleWindowStsChanged(VehicleManager.VehicleWindowType type,
		        VehicleManager.VehicleWindowSts sts)
		{
			Element e;
			switch (type.getValue()) {
			case 0:
				e = mArrayList.get(0);
				e.setmValue(sts + "");
				break;
			case 1:
				e = mArrayList.get(1);
				e.setmValue(sts + "");
				break;
			case 2:
				e = mArrayList.get(2);
				e.setmValue(sts + "");
				break;
			case 3:
				e = mArrayList.get(3);
				e.setmValue(sts + "");
				break;
			default:break;
			}
			notifyAdapter();
		}
		@Override
	    public void onVehicleSkyLightStsChanged(VehicleManager.VehicleSkyLightSts sts)
	    {
			Element e = mArrayList.get(4);
			e.setmValue(sts + "");
			notifyAdapter();
	    }
		@Override
	    public void onVehicleWindShieldHeatingStsChanged(VehicleManager.OpenCloseSts sts)
	    {
			Element e = mArrayList.get(5);
			e.setmValue(sts + "");
			notifyAdapter();
	    }
	};
}
