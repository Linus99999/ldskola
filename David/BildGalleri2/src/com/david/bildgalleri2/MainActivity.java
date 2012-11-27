package com.david.bildgalleri2;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ((Gallery)findViewById(R.id.gallery1))
        			.setAdapter(new ImageAdapter(this));
    }
    /* Vår ImageAdapter Klass */
    
    public class ImageAdapter extends BaseAdapter {
    	
    	private Context mContext;
    	
    	private int[] bildIds={
    		
    		R.drawable.jesperthornlund,
    		R.drawable.erikovragard,
    		R.drawable.martinhallenalmroth,
    		R.drawable.joakimgusafsson,
    		R.drawable.sofiahelin,
    		R.drawable.corneliaeriksson
    	};
    	
    	public ImageAdapter(Context c){
    		mContext = c;
    	}
    	

		public int getCount() {
			// TODO Auto-generated method stub
			return bildIds.length;
		}

		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			ImageView imv = new ImageView(mContext);
			imv.setImageResource(bildIds[position]);
			imv.setScaleType(ImageView.ScaleType.FIT_XY);
			imv.setLayoutParams(new Gallery.LayoutParams(150,100));
			return imv;
		}
    	
    }
}