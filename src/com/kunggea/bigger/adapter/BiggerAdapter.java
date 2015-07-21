package com.kunggea.bigger.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.kunggea.bigger.R;
import com.kunggea.bigger.base.BaseInfo;
import com.kunggea.bigger.base.BiggerApplication;
import com.kunggea.bigger.info.BiggerInfo;

public class BiggerAdapter extends BaseAdapter implements View.OnClickListener,
		Runnable {

	class ViewHolder {
		TextView item_bigger_title;
	}

	private static final String TAG = "BiggerAdapter";
	private OnItemClickListener mOnItemClickListener;

	private List<BaseInfo> mInfoList = new ArrayList<BaseInfo>();

	private LayoutInflater mInflater;

	private boolean mCanClick = true;

	public BiggerAdapter() {
		mInflater = (LayoutInflater) BiggerApplication.getInstance()
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	/**
	 * 清空数据
	 */
	public void clearAll() {
		if (mInfoList != null) {
			mInfoList.clear();
		}
		notifyDataSetChanged();
	}

	@Override
	public int getCount() {
		int count = 0;
		if (mInfoList == null) {
			count = 0;
		} else {
			count = mInfoList.size();
		}
		return count;
	}

	@Override
	public BiggerInfo getItem(int position) {
		if (mInfoList != null && mInfoList.size() > position) {
			return (BiggerInfo) mInfoList.get(position);
		}
		return null;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup viewGroup) {
		ViewHolder holder;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.item_bigger, null);
			holder = new ViewHolder();
			
			holder.item_bigger_title = (TextView) convertView
					.findViewById(R.id.item_bigger_title);

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		BiggerInfo info = getItem(position);
		if (info != null) {

			holder.item_bigger_title.setText(info.title);
		}
		return convertView;
	}

	@Override
	public void onClick(View v) {
		if (mCanClick) {
			// mCanClick = false;
			// Integer position = (Integer) v.getTag(R.id.item_bigger_title);
			// if (mOnItemClickListener != null) {
			// mOnItemClickListener.onItemClick(null, v, position, 0);
			// }
			// v.postDelayed(this, 1000);
		}
	}

	public void addData(List<BaseInfo> list) {
		if (mInfoList != null) {
			mInfoList.addAll(list);
		}
		notifyDataSetChanged();
	}
	
	public void refreshData(List<BaseInfo> list) {
		if (mInfoList != null) {
			mInfoList.clear();
			mInfoList.addAll(list);
		}
		notifyDataSetChanged();
	}

	@Override
	public void run() {
		mCanClick = true;
	}

	public void setOnItemClickListener(OnItemClickListener listener) {
		mOnItemClickListener = listener;
	}

}
