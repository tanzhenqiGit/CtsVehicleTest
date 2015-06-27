package data.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DataAdapter extends BaseAdapter {

    public DataAdapter(Context context) 
    {
    	mContext = context;
    }
    
    public void setListNameData(ArrayList<Element> data)
    {
    	if (data != null) {
    		mDataList = data;
    		mCount = data.size();
    	}

    }
    
    
	@Override
	public int getCount() {
		// TODO 自动生成的方法存根
		return mCount;
	}

	@Override
	public Object getItem(int pos) {
		// TODO 自动生成的方法存根
		return pos;
	}

	@Override
	public long getItemId(int pos) {
		// TODO 自动生成的方法存根
		return pos;
	}

	@Override
	public View getView(int position, View arg1, ViewGroup arg2) {
		LinearLayout ll = new LinearLayout(mContext);
		ll.setOrientation(LinearLayout.HORIZONTAL);
		TextView name = new TextView(mContext);
		TextView value = new TextView(mContext);
		name.setText(mDataList.get(position).getmName());
		name.setTextColor(Color.RED);
		name.setWidth(300);
		value.setText("[  " + mDataList.get(position).getmValue() + "  ]");
		value.setTextColor(Color.WHITE);
		ll.addView(name);
		ll.addView(value);
		return ll;
	}
	private int mCount = 0;
	private Context mContext;
    private ArrayList<Element> mDataList;
}
