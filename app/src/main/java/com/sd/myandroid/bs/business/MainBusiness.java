package com.sd.myandroid.bs.business;

import android.os.Handler;

import com.sd.lib.bs.FBusiness;
import com.sd.lib.stream.FStream;

public class MainBusiness extends FBusiness
{
    private int mCount;

    public MainBusiness(String tag)
    {
        super(tag);
    }

    public void requestData()
    {
        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                mCount++;
                getStream(RequestDataCallback.class).bsRequestDataSuccess("success count " + mCount);
            }
        }, 1000);
    }

    public interface RequestDataCallback extends FStream
    {
        void bsRequestDataSuccess(String result);
    }
}
