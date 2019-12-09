package com.sd.lib.bs.stream;

import com.sd.lib.stream.FStream;

public interface BSProgress extends FStream
{
    void bsShowProgress(String msg);

    void bsHideProgress();
}
