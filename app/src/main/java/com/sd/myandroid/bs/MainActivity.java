package com.sd.myandroid.bs;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.sd.lib.stream.FStream;
import com.sd.lib.stream.FStreamManager;
import com.sd.myandroid.bs.business.MainBusiness;

public class MainActivity extends AppCompatActivity
{
    private final MainBusiness mBusiness = new MainBusiness(toString());

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_request).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mBusiness.requestData();
            }
        });

        FStreamManager.getInstance().bindStream(mRequestDataCallback, this);
    }

    private final MainBusiness.RequestDataCallback mRequestDataCallback = new MainBusiness.RequestDataCallback()
    {
        @Override
        public void bsRequestDataSuccess(String result)
        {
            final TextView textView = findViewById(R.id.tv_content);
            textView.setText(result);
        }

        @Override
        public Object getTagForStream(Class<? extends FStream> clazz)
        {
            return MainActivity.this.toString();
        }
    };
}
