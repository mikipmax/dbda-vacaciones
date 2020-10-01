package com.distribuida.servicios;

import java.util.List;

import org.apache.commons.configuration.AbstractConfiguration;

import com.distribuida.clases.Persona;
import com.distribuida.consul.GetUrl;
import com.distribuida.rest.PersonaRest;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.client.config.CommonClientConfigKey;
import com.netflix.config.ConfigurationManager;
import com.netflix.ribbon.Ribbon;
import com.netflix.ribbon.RibbonRequest;

import io.helidon.common.http.HttpRequest;
import io.netty.buffer.ByteBuf;

public class ServicioPersona {

	public ServicioPersona () {
		System.out.println("LLAMA SERVICIO PERSONA");
	}
	
	private String urlsPersona = GetUrl.getUrlPersona();

	public List<Persona> listarTodo() {
		List<Persona> lista = null;
		AbstractConfiguration config = ConfigurationManager.getConfigInstance();
		config.setProperty("persona.ribbon." + CommonClientConfigKey.ListOfServers, urlsPersona);

		PersonaRest servicio = Ribbon.from(PersonaRest.class);

		RibbonRequest<ByteBuf> ret = servicio.findAll();

		// ejecutar la accion
		ByteBuf result = ret.execute();

		// convertir a string
		int size = result.readableBytes();
		byte[] data = new byte[size];
		result.readBytes(data);

		String str = new String(data);
		ObjectMapper mapper = new ObjectMapper();
		try {
			lista = mapper.readValue(str, new TypeReference<List<Persona>>() { });
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(lista.toString());
		return lista;
	}
	
	public Persona obtenerPorId(Integer id) {
		Persona pers = null;
		AbstractConfiguration config = ConfigurationManager.getConfigInstance();
		config.setProperty("persona.ribbon." + CommonClientConfigKey.ListOfServers, urlsPersona);

		PersonaRest servicio = Ribbon.from(PersonaRest.class);

		RibbonRequest<ByteBuf> ret = servicio.findById(id);

		// ejecutar la accion
		ByteBuf result = ret.execute();

		// convertir a string
		int size = result.readableBytes();
		byte[] data = new byte[size];
		result.readBytes(data);

		String str = new String(data);
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			pers = mapper.readValue(str, Persona.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(pers.getNombre());
		return pers;
	}
	
	
	public void crear(Persona pers) {
		AbstractConfiguration config = ConfigurationManager.getConfigInstance();
		config.setProperty("persona.ribbon." + CommonClientConfigKey.ListOfServers, urlsPersona);

		PersonaRest servicio = Ribbon.from(PersonaRest.class);
		
		RibbonRequest<ByteBuf> ret = servicio.crear(pers);
		
		ret.execute();
	
	}

}
