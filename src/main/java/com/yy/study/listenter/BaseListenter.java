package com.yy.study.listenter;

import com.yy.study.event.BaseEvent;

import java.util.EventListener;

/**
 * Created by zy48461 on 2017/9/14.
 */
public interface BaseListenter extends EventListener {
    void onEvent(BaseEvent event);

    boolean isSupportEvent(BaseEvent event);
}
