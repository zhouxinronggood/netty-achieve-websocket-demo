package com.example.springbootwebsocketdemo.wbserver;

import com.example.springbootwebsocketdemo.handler.WebSocketIdleStateHandler;
import com.example.springbootwebsocketdemo.handler.WebSocketServerHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.codec.http.websocketx.extensions.compression.WebSocketServerCompressionHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description 自定义的ChannelInitializer，用于初始化ChannelPipeline，以处理客户端的Channel请求
 * ChannelInitializer抽象类，帮助用户配置新创建的通道（Channel），以便在通道创建完成后，添加一系列的处理器（handler）来处理通道的数据。
 * @Author zhouxinrong
 * @Date 2023/7/30
 * @Version 1.0
 */
@Slf4j
@AllArgsConstructor
public class WebSocketServerInitializer extends ChannelInitializer<NioSocketChannel> {

    private String webSocketUrl;

    @Override
    protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {
        log.debug("服务的接口地址：{}", webSocketUrl);
        ChannelPipeline pipeline = nioSocketChannel.pipeline();
        //自定义的Handler-心跳检测
        pipeline.addLast(new WebSocketIdleStateHandler());
        //HTTP协议编解码器，用于处理HTTP请求和响应的编码和解码。其主要作用是将HTTP请求和响应消息转换为Netty的ByteBuf对象，并将其传递到下一个处理器进行处理。
        pipeline.addLast(new HttpServerCodec());
        //用于HTTP服务端，将来自客户端的HTTP请求和响应消息聚合成一个完整的消息，以便后续的处理。
        //聚合内容的最大长度（以字节为单位）。如果聚合内容的长度超过此值，将调用handleversizedMessage（ChannelHandlerContext，HttpMessage）
        pipeline.addLast(new HttpObjectAggregator(65536));
        // WebSocket通信支持
        pipeline.addLast("http-chunked", new ChunkedWriteHandler());
        //netty提供最简单用于对WebSocket消息进行压缩和解压缩操作。
        pipeline.addLast(new WebSocketServerCompressionHandler());
        //可以对整个WebSocker通信进行初始化（当Http请求中有升级为WebSocker的请求时），以及握手处理
        //它负责websocket握手以及控制帧（Close、Ping、Pong）的处理。文本和二进制数据帧被传递给管道中的下一个处理程序（由您实现）进行处理。
        //（是netty内置的handler，直接使用即可，websocket的请求路径是 ws://ip:port/${webSocketPath}）
        pipeline.addLast(new WebSocketServerProtocolHandler(webSocketUrl, null, true));
        //自定义的Handler-处理WebSocket文本类型的消息
        pipeline.addLast(new WebSocketServerHandler());
    }
}
