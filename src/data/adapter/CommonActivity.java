package data.adapter;

import java.util.ArrayList;

import com.example.ctsvehicle.CtsVehicleMain;
import com.example.ctsvehicle.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.vehicle.vehicle.VehicleListener;
import android.vehicle.vehicle.VehicleManager;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

abstract public class CommonActivity extends Activity {

	@Override
	protected void onCreate(Bundle arg0) {
		// TODO 自动生成的方法存根
		super.onCreate(arg0);
		setContentView(R.layout.activity_vehicle);
		initialize();
	}

	@Override
	protected void onDestroy() {
		// TODO 自动生成的方法存根
		super.onDestroy();
		if (mVehicleMgr != null) {
			mVehicleMgr.removeVehicleListener(getListener());
		}
	}
	
	
	private void initialize()
	{
		mGet = (Button) findViewById(R.id.vehicle_com_get);
		if (mGet != null) {
			mGet.setOnClickListener(mListener);
		}
		mRet = (Button) findViewById(R.id.vehicle_com_return);
		if (mRet != null) {
			mRet.setOnClickListener(mListener);
		}
		mVehicleMgr = (VehicleManager) getSystemService(VEHICLE_SERVICE);
		if (mVehicleMgr != null) {
			mVehicleMgr.addVehicleListener(getListener());
		}
		mDataAdapter = new DataAdapter(this);
		mList = (ListView) findViewById(R.id.vehicle_com_list);
		if (mList != null) {
			initializeData();
			mDataAdapter.setListNameData(mArrayList);
			mList.setAdapter(mDataAdapter);
		}
	}
	public void notifyAdapter()
	{
		if (mDataAdapter != null) {
			mDataAdapter.notifyDataSetChanged();
		}
	}
	
	public VehicleManager mVehicleMgr;
	private DataAdapter mDataAdapter;
	public ArrayList<Element> mArrayList = new ArrayList<Element>();
	
	private Button mGet, mRet;
	
	private ListView mList;
	abstract public void initializeData();
    public void onGetButtonClick()
	{
		mArrayList.clear();
		initializeData();
		notifyAdapter();
	}
	abstract public VehicleListener getListener();
	
	private View.OnClickListener mListener = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.vehicle_com_get:
				if (mVehicleMgr != null) {
				    mVehicleMgr.syncVehicleData();
				}
				onGetButtonClick();
				break;
			case R.id.vehicle_com_return:
				Intent ret = new Intent(CommonActivity.this, CtsVehicleMain.class);
				startActivity(ret);
				finish();
				break;
			}
			
		}
	};
	
	

}
