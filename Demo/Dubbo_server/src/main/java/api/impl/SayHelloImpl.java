package api.impl;

import api.SayHello;

/**
 * Created by 123 on 2017/08/21.
 */

public class SayHelloImpl implements SayHello {
    public String sayHello(String name) {
        System.out.println(name);
        return "hello"+name;
    }
}
