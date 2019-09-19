package cn.qydx.service.sso.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.qydx.service.sso.SsoApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={SsoApplication.class})
public class RedisTest {

    @Autowired
    private RedisUtil util;

    @Test
    public void test1(){
        util.set("k1", "v1");
    }

}
