package com.yy.study.listenter;

import com.yy.study.event.BaseEvent;
import com.yy.study.model.Motor;

/**
 * Created by zy48461 on 2017/9/15.
 */
public class MotorListenter implements BaseListenter {
    public void onEvent(BaseEvent event) {
        System.out.println("motor begin run ");

    }

    public boolean isSupportEvent(BaseEvent event) {
        return event.getType() instanceof Motor;
    }
}
