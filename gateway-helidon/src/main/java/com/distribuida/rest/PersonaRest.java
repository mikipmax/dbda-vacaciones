package com.distribuida.rest;

import com.distribuida.clases.Persona;
import com.netflix.ribbon.RibbonRequest;
import com.netflix.ribbon.proxy.annotation.Content;
import com.netflix.ribbon.proxy.annotation.ContentTransformerClass;
import com.netflix.ribbon.proxy.annotation.Http;
import com.netflix.ribbon.proxy.annotation.Var;
import com.netflix.ribbon.proxy.annotation.Http.HttpMethod;
import com.netflix.ribbon.proxy.annotation.ResourceGroup;

import io.netty.buffer.ByteBuf;

@ResourceGroup(name = "persona") // Hace referencia al nombre del servicio en el consul
public interface PersonaRest {

	// Mediante http se conectara al consul y obtendrá el path de listar personas
	@Http(method = HttpMethod.GET, uri = "/personas")

	// Mëtodo para listar todas las personas, ribbon usa el tipo de dato ByteBuff y
	// posteriormente se lo mapeará a tipo List<Persona>
	public RibbonRequest<ByteBuf> findAll();

	// Método http para conectar al consul y obtener el path de buscar por id
	@Http(method = HttpMethod.GET, uri = "/personas/{id}")
	// Mëtodo para buscar una persona
	// con @Var tomamos el valor {id} en la url
	public RibbonRequest<ByteBuf> findById(@Var("id") Integer id);

	@Http(method = HttpMethod.POST, uri = "/personas/crear")
	@ContentTransformerClass(RxTransformer.class)
	public RibbonRequest<ByteBuf> crear(@Content Persona persona);

}
			