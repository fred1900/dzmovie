package com.android.meimi.activity;

 

import com.android.dzdp.movie.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

public class SecondActivity extends Activity implements OnTouchListener {
	//��ָ���һ���ʱ����С�ٶ�  
    private static final int XSPEED_MIN = 200;  
      
    //��ָ���һ���ʱ����С����  
    private static final int XDISTANCE_MIN = 150;  
      
    //��¼��ָ����ʱ�ĺ���ꡣ  
    private float xDown;  
      
    //��¼��ָ�ƶ�ʱ�ĺ���ꡣ  
    private float xMove;  
      
    //���ڼ�����ָ�������ٶȡ�  
    private VelocityTracker mVelocityTracker;  
 
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main2);
		findViewById(R.id.second_button).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
			}
		});
		LinearLayout ll = (LinearLayout) findViewById(R.id.second_layout);  
	    ll.setOnTouchListener(this);  
		//�жϵ�ǰSDK�汾�ţ������4.4���ϣ�����֧�ֳ���ʽ״̬����
		if (VERSION.SDK_INT >= VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
	}

	@Override
	public boolean onTouch(View arg0, MotionEvent event) {
		// TODO Auto-generated method stub
		createVelocityTracker(event);  
        switch (event.getAction()) {  
        case MotionEvent.ACTION_DOWN:  
            xDown = event.getRawX();  
            break;  
        case MotionEvent.ACTION_MOVE:  
            xMove = event.getRawX();  
            //��ľ���  
            int distanceX = (int) (xMove - xDown);  
            //��ȡ˳ʱ�ٶ�  
            int xSpeed = getScrollVelocity();  
            //�������ľ�����������趨����С�����һ�����˲���ٶȴ��������趨���ٶ�ʱ�����ص���һ��activity  
            if(distanceX > XDISTANCE_MIN && xSpeed > XSPEED_MIN) {  
                finish();  
            }  
            break;  
        case MotionEvent.ACTION_UP:  
            recycleVelocityTracker();  
            break;  
        default:  
            break;  
        }  
        return true;  
		 
	}
	 /** 
     * ����VelocityTracker���󣬲�������content����Ļ����¼����뵽VelocityTracker���С� 
     *  
     * @param event 
     *         
     */  
    private void createVelocityTracker(MotionEvent event) {  
        if (mVelocityTracker == null) {  
            mVelocityTracker = VelocityTracker.obtain();  
        }  
        mVelocityTracker.addMovement(event);  
    }  
      
    /** 
     * ����VelocityTracker���� 
     */  
    private void recycleVelocityTracker() {  
        mVelocityTracker.recycle();  
        mVelocityTracker = null;  
    }  
      
    /** 
     * ��ȡ��ָ��content���滬�����ٶȡ� 
     *  
     * @return �����ٶȣ���ÿ�����ƶ��˶�������ֵΪ��λ�� 
     */  
    private int getScrollVelocity() {  
        mVelocityTracker.computeCurrentVelocity(1000);  
        int velocity = (int) mVelocityTracker.getXVelocity();  
        return Math.abs(velocity);  
    }  

}
