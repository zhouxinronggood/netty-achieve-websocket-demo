package com.example.springbootwebsocketdemo.controller;

import com.example.springbootwebsocketdemo.config.NettyConfig;
import com.example.springbootwebsocketdemo.entity.User;
import com.example.springbootwebsocketdemo.service.ISendMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author zhouxinrong
 * @Date 2023/7/30
 * @Version 1.0
 */
@RestController
@RequestMapping("/msg/send/")
public class SendMsgController {

    @Autowired
    private ISendMessageService sendMessageService;

    /**
     * 单发消息：根据UserId给某个用户发送消息
     */
    @PostMapping("/user")
    public Map<String, Object> sendMsgToUserByUserId(
            @RequestParam("userId") String userId,
            @RequestParam("receiver") String receiver,
            @RequestParam("msg") String msg) {
        sendMessageService.sendMsgToUserByUserId(userId, receiver,msg);
        Map<String, Object> response = new HashMap<>();
        response.put("code", HttpServletResponse.SC_OK);
        response.put("msg", "给" + userId + "的消息发送成功");
        return response;
    }

    /**
     * 群发消息：给所有在线的客户端发送消息
     */
    @PostMapping("/group")
    public Map<String, Object> sendMsgToGroup(@RequestParam("msg") String msg) {
        sendMessageService.sendMsgToGroup(msg);
        Map<String, Object> response = new HashMap<>();
        response.put("code", HttpServletResponse.SC_OK);
        response.put("msg", "群发消息成功");
        return response;
    }

    /**
     * 返回在线的UserId
     * @CrossOrigin: 解决跨域问题, 使用@CrossOrigin()注解来配置CORS策略, 以便允许特定的域名、端口或协议进行跨域访问。
     */
    //@CrossOrigin(originPatterns = {"http://localhost:8081","http://sso.server.com:9999","http://10.40.129.179:8081"})
    @GetMapping("/online/list")
    public Map<String, Object> onlineList() {
        Map<String, Object> response = new HashMap<>();

        List<User> list = new ArrayList<>();
        NettyConfig.getOnlineUserChannelMap().forEach((key, value) -> {
            User user = new User(key, key);
            list.add(user);
        });
        response.put("code", 200);
        response.put("msg", "success");
        response.put("data", list);
        return response;
    }
}
