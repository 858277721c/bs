package com.sd.lib.bs;

import com.sd.lib.bs.stream.BSProgress;
import com.sd.lib.stream.FStream;

public abstract class FBusiness
{
    private final String mTag;

    public FBusiness(String tag)
    {
        mTag = tag;
    }

    /**
     * 返回当前业务类的标识
     *
     * @return
     */
    public final String getTag()
    {
        return mTag;
    }

    /**
     * 创建一个流代理对象返回
     *
     * @param clazz
     * @param <T>
     * @return
     */
    protected final <T extends FStream> T getStream(Class<T> clazz)
    {
        return new FStream.ProxyBuilder().setTag(getTag()).build(clazz);
    }

    protected final BSProgress getProgress()
    {
        return getStream(BSProgress.class);
    }

    public void onDestroy()
    {
    }
}
