package api.impl;

import api.sayHello;

/**
 * Created by 123 on 2017/08/21.
 */

public class sayHelloImpl implements sayHello {
    public String sayHello(String name) {
        System.out.println("方法执行了" + name);
        return "hello" + name;
    }
}
