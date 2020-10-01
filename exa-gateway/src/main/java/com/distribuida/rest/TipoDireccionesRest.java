package com.distribuida.rest;

import com.netflix.ribbon.RibbonRequest;
import com.netflix.ribbon.proxy.annotation.Http;
import com.netflix.ribbon.proxy.annotation.Var;
import com.netflix.ribbon.proxy.annotation.Http.HttpMethod;
import com.netflix.ribbon.proxy.annotation.ResourceGroup;

import io.netty.buffer.ByteBuf;

@ResourceGroup(name = "Servicio-direccion")
public interface TipoDireccionesRest {

	@Http(method = HttpMethod.GET,
			uri = "/tipos"
	)
	public RibbonRequest<ByteBuf> findAll();
	
	@Http(method = HttpMethod.GET, 
			uri = "/tipos/{id}")
	public RibbonRequest<ByteBuf> findById(@Var("id")Integer id);
	
}
