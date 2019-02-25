package com.yms.station.controller.front;

import com.alibaba.dubbo.common.json.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;
import java.util.UUID;


/**
 * Created by Administrator on 2019/2/25.
 */
@Controller
@Slf4j
@RequestMapping("/front")
public class FrontPageController {
    @RequestMapping("test")
    @ResponseBody
    public String showSayHi(String name, String pwd) {
        MDC.put("TRACE_LOG_ID", UUID.randomUUID().toString());
        log.info("用户名:{},用户密码:{}", name, pwd);
        Random random = new Random(100);
        if (random.nextInt() > 50) {
            log.info("用户:{} 登陆成功！", name);
        } else {
            log.info("用户:{} 登陆失败！", name);
        }
        return "welcome";
    }
}
