package com.example.ctsvehicle;

import data.adapter.CommonActivity;
import data.adapter.Element;
import android.vehicle.vehicle.VehicleListener;
import android.vehicle.vehicle.VehicleManager;
import android.vehicle.vehicle.VehicleManager.VehicleDoorInfoType;

public class CtsVehicleGate extends CommonActivity {

	@Override
	public void initializeData() {
		/**
		 * id = 0
		 */
		mArrayList.add(new Element("��ǰ�ſ���״̬", "" + 
				mVehicleMgr.getVehicleDoorInfoByType(VehicleDoorInfoType.LeftFrontDoor)));
		/**
		 * id = 1
		 */
		mArrayList.add(new Element("��ǰ�ſ���״̬", "" + 
				mVehicleMgr.getVehicleDoorInfoByType(VehicleDoorInfoType.RightFrontDoor)));
		/**
		 * id = 2
		 */
		mArrayList.add(new Element("����ſ���״̬", "" + 
				mVehicleMgr.getVehicleDoorInfoByType(VehicleDoorInfoType.LeftBackDoor)));
		/**
		 * id = 3
		 */
		mArrayList.add(new Element("�Һ��ſ���״̬", "" + 
				mVehicleMgr.getVehicleDoorInfoByType(VehicleDoorInfoType.RightBackDoor)));
		/**
		 * id = 4
		 */
		mArrayList.add(new Element("���ſ���״̬", "" + 
				mVehicleMgr.getVehicleDoorInfoByType(VehicleDoorInfoType.HatchBackDoor)));
		/**
		 * id = 5
		 */
		mArrayList.add(new Element("ǰ�ոǿ���״̬", "" + 
				mVehicleMgr.getVehicleDoorInfoByType(VehicleDoorInfoType.ForecabinConver)));
		/**
		 * id = 6
		 */
		
		mArrayList.add(new Element("��ǰ����������״̬", "" + 
				mVehicleMgr.getVehicleDoorInfoByType(VehicleDoorInfoType.LeftFrontDoorLock)));
		/**
		 * id = 7
		 */
		mArrayList.add(new Element("��ǰ����������״̬", "" + 
				mVehicleMgr.getVehicleDoorInfoByType(VehicleDoorInfoType.RightForntDoorLock)));
		/**
		 * id = 8
		 */
		mArrayList.add(new Element("�������������״̬", "" + 
				mVehicleMgr.getVehicleDoorInfoByType(VehicleDoorInfoType.LeftBackDoorLock)));
		/**
		 * id = 9
		 */
		mArrayList.add(new Element("�Һ�����������״̬", "" + 
				mVehicleMgr.getVehicleDoorInfoByType(VehicleDoorInfoType.RightBackDoorLock)));
		/**
		 * id = 10
		 */
		mArrayList.add(new Element("������������״̬", "" + 
				mVehicleMgr.getVehicleDoorInfoByType(VehicleDoorInfoType.CenterDoorLock)));
		/**
		 * id = 11
		 */
		mArrayList.add(new Element("��ǰ��Կ���Ƿ����", "" + 
				mVehicleMgr.getKeyInsertStsByType(VehicleDoorInfoType.LeftFrontDoor)));

		
	}


	@Override
	public VehicleListener getListener() {
		return mListener;
	}

	private VehicleListener mListener = new VehicleListener()
	{
		@Override
		public void onVehicleOpenCloseStsChanged(VehicleManager.VehicleDoorInfoType type, 
			        VehicleManager.OpenCloseSts sts)
	    {
			Element e ;
			switch (type.getValue())
			{
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
			case 5:
				e = mArrayList.get(5);
				e.setmValue("" + sts);
				break;
			case 6:
				e = mArrayList.get(6);
				e.setmValue("" + sts);
				break;
			case 7:
				e = mArrayList.get(7);
				e.setmValue("" + sts);
				break;
			case 8:
				e = mArrayList.get(8);
				e.setmValue("" + sts);
				break;
			case 9:
				e = mArrayList.get(9);
				e.setmValue("" + sts);
				break;
			case 10:
				e = mArrayList.get(10);
				e.setmValue("" + sts);
				break;
			default: break;
			}
			notifyAdapter();
			
	    }
		public void onVehicleKeyInsertStsChanged(VehicleManager.VehicleDoorInfoType type, 
			        VehicleManager.KeyInsertSts sts)
	    {
			Element e ;
			switch (type.getValue())
			{
			case 0:
				e = mArrayList.get(11);
				e.setmValue("" + sts);
				break;
			default:break;
			}
			notifyAdapter();
	    }
	};

}
