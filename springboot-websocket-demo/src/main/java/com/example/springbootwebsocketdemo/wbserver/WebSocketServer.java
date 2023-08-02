package com.example.springbootwebsocketdemo.wbserver;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Objects;

/**
 * @Description 消息服务主类
 * @Author zhouxinrong
 * @Date 2023/7/30
 * @Version 1.0
 */
@Component
public class WebSocketServer {

    private static final Logger log = LoggerFactory.getLogger(WebSocketServer.class);

    @Value("${websocket.netty.port:19999}")
    private int port;

    @Value("${websocket.netty.url:/websocket}")
    private String webSocketUrl;

    private EventLoopGroup bossGroup = null;
    private EventLoopGroup workGroup = null;

    /**
     * 初始化WebSocketServer（调用init()）
     * PostConstruct注解：用于指示一个方法在容器创建该组件之后立即调用
     * 注解使用前提：该类的实例必须是由容器创建和管理的，如 Spring、JavaEE 容器等。
     */
    @PostConstruct
    public void init() {
        //这里要新开一个线程，否则会阻塞原本的controller等业务
        new Thread(() -> {
            try {
                run(port, webSocketUrl);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    public void run(int port, String webSocketUrl) throws Exception {
        bossGroup = new NioEventLoopGroup(1);
        workGroup = new NioEventLoopGroup();
        ServerBootstrap bootstrap = new ServerBootstrap();
        Channel channel = bootstrap.group(workGroup, bossGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new WebSocketServerInitializer(webSocketUrl))
                .bind(port)
                .sync()
                .channel();
        log.debug("服务端启动成功，端口号：{}", port);

        // .closeFuture() 返回一个特殊的ChannelFuture对象，它表示通道的关闭状态。我们可以通过添加监听器（Listener）来处理通道关闭的事件。当通道被关闭时，监听器中的相应逻辑将被执行。
        /*channel.closeFuture().addListener((ChannelFuture future) -> {
            if (future.isSuccess()) {
                System.out.println("通道已成功关闭");
            } else {
                System.out.println("通道关闭失败：" + future.cause());
            }
        });*/
        try {
            // 等待通道关闭的异步任务结束
            // .sync() 方法会阻塞当前线程，直到通道关闭为止。
            channel.closeFuture().sync();
            log.info("通道已成功关闭");
        } catch (InterruptedException e) {
            log.error("通道关闭时发生中断异常：" + e.getMessage());
        } finally {
            if (Objects.nonNull(bossGroup)) {
                bossGroup.shutdownGracefully();
            }
            if (Objects.nonNull(workGroup)) {
                workGroup.shutdownGracefully();
            }
        }
    }

}




















