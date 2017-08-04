package com.ql.Service;

import com.ql.baseTest.SpringTestCase;
import com.ql.model.User;
import com.ql.service.IUserService;
import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * Created by 123 on 2017/08/01.
 */

public class UserServiceTest extends SpringTestCase {
    private IUserService userService;
    Logger logger = Logger.getLogger(UserServiceTest.class);

    @Test
    public void selectUserByIdTest() {
        System.out.println("fuck");
        User user = userService.selectUserById(1);

        System.out.println(user+"wc");
        logger.debug("查找结果" + user);
    }

}
