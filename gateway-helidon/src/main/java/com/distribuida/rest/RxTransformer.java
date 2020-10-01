package com.distribuida.rest;

import java.nio.charset.Charset;

import com.distribuida.clases.Persona;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.reactivex.netty.channel.ContentTransformer;

public class RxTransformer implements ContentTransformer<Persona> {
    @Override
    public ByteBuf call(Persona movie, ByteBufAllocator byteBufAllocator) {
        byte[] bytes = movie.toString().getBytes(Charset.defaultCharset());
        ByteBuf byteBuf = byteBufAllocator.buffer(bytes.length);
        byteBuf.writeBytes(bytes);
        return byteBuf;
    }
}
