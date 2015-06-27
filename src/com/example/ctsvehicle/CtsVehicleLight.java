package com.example.ctsvehicle;

import data.adapter.CommonActivity;
import data.adapter.Element;
import android.vehicle.vehicle.VehicleListener;
import android.vehicle.vehicle.VehicleManager;
import android.vehicle.vehicle.VehicleManager.VehicleLightStsType;

public class CtsVehicleLight extends CommonActivity {

	@Override
	public void initializeData() {

		/**
		 * id = 0
		 */
		mArrayList.add(new Element("转向灯/侧转向灯转向方向", "" + mVehicleMgr.getVehicleTurnLightSts()));
		/**
		 * id = 1
		 */
		mArrayList.add(new Element("倒车灯开关状态", 
				"" + mVehicleMgr.getVehicleLightStsByType(VehicleLightStsType.ReversingLight)));
		/**
		 * id = 2
		 */
		mArrayList.add(new Element("近光灯开关状态", 
				"" + mVehicleMgr.getVehicleLightStsByType(VehicleLightStsType.CloseLight)));
		/**
		 * id = 3
		 */
		mArrayList.add(new Element("远光灯开关状态", 
				"" + mVehicleMgr.getVehicleLightStsByType(VehicleLightStsType.DriveLight)));
		/**
		 * id = 4
		 */
		mArrayList.add(new Element("前雾灯开关状态", 
				"" + mVehicleMgr.getVehicleLightStsByType(VehicleLightStsType.ForthFogLight)));
		/**
		 * id = 5
		 */
		mArrayList.add(new Element("后雾灯开关状态", 
				"" + mVehicleMgr.getVehicleLightStsByType(VehicleLightStsType.BackFogLight)));
		/**
		 * id = 6
		 */
		mArrayList.add(new Element("室内阅读灯开关状态", 
				"" + mVehicleMgr.getVehicleLightStsByType(VehicleLightStsType.ReadingLight)));
		/**
		 * id = 7
		 */
		mArrayList.add(new Element("背光灯(小灯开关状态)", 
				"" + mVehicleMgr.getVehicleLightStsByType(VehicleLightStsType.BackLight)));
		/**
		 * id = 8
		 */
		mArrayList.add(new Element("紧急灯开关状态", 
				"" + mVehicleMgr.getVehicleLightStsByType(VehicleLightStsType.EmergencyLight)));
		/**
		 * id = 9
		 */
		mArrayList.add(new Element("昼间行车灯开关状态", 
				"" + mVehicleMgr.getVehicleLightStsByType(VehicleLightStsType.DaytimeRunningLight)));
		/**
		 * id = 10
		 */
		mArrayList.add(new Element("制动灯开关状态", 
				"" + mVehicleMgr.getVehicleLightStsByType(VehicleLightStsType.BreakLight)));
		/**
		 * id = 11
		 */
		mArrayList.add(new Element("位置灯/牌照灯开关状态", 
				"" + mVehicleMgr.getVehicleLightStsByType(VehicleLightStsType.NumberPlateLight)));
		/**
		 * id = 12
		 */
		mArrayList.add(new Element("示宽灯", 
				"" + mVehicleMgr.getVehicleLightStsByType(VehicleLightStsType.WidthLight)));
		/**
		 * id = 13
		 */
		mArrayList.add(new Element("危险灯", 
				"" + mVehicleMgr.getVehicleLightStsByType(VehicleLightStsType.HazardLight)));

	}

	@Override
	public VehicleListener getListener() {
		// TODO 自动生成的方法存根
		return mListener;
	}
	
	private VehicleListener mListener = new VehicleListener()
	{
		@Override
		public void onVehicleLightStsChanged(VehicleManager.VehicleLightStsType type,
		        VehicleManager.OpenCloseSts sts)
		{
			Element e;
			switch (type.getValue()) {
			case 0:
				e = mArrayList.get(1);
				e.setmValue(sts + "");
				break;
			case 1:
				e = mArrayList.get(2);
				e.setmValue(sts + "");
				break;
			case 2:
				e = mArrayList.get(3);
				e.setmValue(sts + "");
				break;
			case 3:
				e = mArrayList.get(4);
				e.setmValue(sts + "");
				break;
			case 4:
				e = mArrayList.get(5);
				e.setmValue(sts + "");
				break;
			case 5:
				e = mArrayList.get(6);
				e.setmValue(sts + "");
				break;
			case 6:
				e = mArrayList.get(7);
				e.setmValue(sts + "");
				break;
			case 7:
				e = mArrayList.get(8);
				e.setmValue(sts + "");
				break;
			case 8:
				e = mArrayList.get(9);
				e.setmValue(sts + "");
				break;
			case 9:
				e = mArrayList.get(10);
				e.setmValue(sts + "");
				break;
			case 10:
				e = mArrayList.get(11);
				e.setmValue(sts + "");
				break;
			case 11:
				e = mArrayList.get(12);
				e.setmValue(sts + "");
				break;
			case 12:
				e = mArrayList.get(13);
				e.setmValue(sts + "");
				break;
			default:
				
				break;
			}
		
			notifyAdapter();
		}
		@Override
		public void onVehicleTurnLightStsChanged(VehicleManager.TurnLightSts sts)
		{
			Element e = mArrayList.get(0);
			e.setmValue(sts + "");
			notifyAdapter();
		}
	};
	

}
