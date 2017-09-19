package com.yy.study.RegesiterManager;

import com.yy.study.event.BaseEvent;
import com.yy.study.listenter.BaseListenter;
import com.yy.study.listenter.CarListenter;
import com.yy.study.listenter.MotorListenter;
import com.yy.study.model.Car;
import com.yy.study.model.Motor;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by zy48461 on 2017/9/15.
 */
public class ListenRegister {
    private List<BaseListenter>   lstListener;
    private static ListenRegister listenrRegister;
    private Lock                  lock = new ReentrantLock();

    public static ListenRegister getInstance() {
        synchronized (ListenRegister.class) {
            if (null == listenrRegister) {
                listenrRegister = new ListenRegister();
            }
            return listenrRegister;
        }
    }

    private ListenRegister() {
        lstListener = new ArrayList<BaseListenter>();
    }

    public void registerListener(BaseListenter listenter) {
        try {
            boolean lockSuccess = lock.tryLock(5, TimeUnit.SECONDS);
            if (lockSuccess) {
                lstListener.add(listenter);
            }

        } catch (Exception ex) {

        } finally {
            lock.unlock();
        }
    }

    public void onEvent(BaseEvent baseEvent) {
        for (BaseListenter listenter : lstListener) {
            if (listenter.isSupportEvent(baseEvent)) {
                listenter.onEvent(baseEvent);
            }
        }
    }

    public static void main(String[] args) {
        ListenRegister register = ListenRegister.getInstance();
        register.registerListener(new CarListenter());
        register.registerListener(new MotorListenter());

        Object envntSource=new Object();

        BaseEvent carEvent = new BaseEvent(envntSource, new Car());
        BaseEvent motorEvent = new BaseEvent(envntSource, new Motor());

        register.onEvent(carEvent);
        register.onEvent(motorEvent);
    }
}
