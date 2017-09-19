package com.yy.study.event;

import java.util.EventObject;

/**
 * Created by zy48461 on 2017/9/14.
 */
public  class BaseEvent extends EventObject {
    private Object type;

    public BaseEvent(Object obj, Object type) {
        super(obj);
        this.type = type;
    }

    public Object getType() {
        return type;
    }

    public void Object(String type) {
        this.type = type;
    }
}
