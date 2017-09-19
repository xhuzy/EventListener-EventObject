package com.yy.study.listenter;

import com.yy.study.event.BaseEvent;
import com.yy.study.model.Car;

/**
 * Created by zy48461 on 2017/9/15.
 */
public class CarListenter implements BaseListenter {
    public void onEvent(BaseEvent event) {
        System.out.println("Car begin run");
    }

    public boolean isSupportEvent(BaseEvent event) {
        return event.getType() instanceof Car;
    }
}
