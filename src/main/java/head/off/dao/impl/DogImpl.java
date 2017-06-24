package head.off.dao.impl;

import head.off.dao.Dog;

/**
 * Created by 123 on 2017/06/22.
 */
public class DogImpl implements Dog {

    public void info() {
        System.out.println("第一执行");
        System.out.println("他是一只猎狗");
    }

    public void run() {
        System.out.println("第二执行");
        System.out.println("他在迅速奔跑");
    }
}
