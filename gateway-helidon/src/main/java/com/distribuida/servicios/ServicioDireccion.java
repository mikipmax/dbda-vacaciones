package com.distribuida.servicios;

import java.util.List;

import org.apache.commons.configuration.AbstractConfiguration;

import com.distribuida.clases.Direccion;
import com.distribuida.consul.GetUrl;
import com.distribuida.rest.TipoDireccionesRest;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.client.config.CommonClientConfigKey;
import com.netflix.config.ConfigurationManager;
import com.netflix.ribbon.Ribbon;
import com.netflix.ribbon.RibbonRequest;

import io.netty.buffer.ByteBuf;

public class ServicioDireccion {

	private String urlsDireccion = GetUrl.getUrlDireccion(); //obtengo las url con sus respectivos puertos

	public List<Direccion> listarTodo() {
		List<Direccion> lista = null; 
		//Lógica para el balanceo de carga
		AbstractConfiguration config = ConfigurationManager.getConfigInstance();
		config.setProperty("direccion.ribbon." + CommonClientConfigKey.ListOfServers, urlsDireccion);

		TipoDireccionesRest servicio = Ribbon.from(TipoDireccionesRest.class);

		RibbonRequest<ByteBuf> ret = servicio.findAll();

		//Lógica para convertir ByteBuff a string
		// ejecutar la accion
		ByteBuf result = ret.execute();

		// convertir a string
		int size = result.readableBytes();
		byte[] data = new byte[size];
		result.readBytes(data);

		String str = new String(data);
		ObjectMapper mapper = new ObjectMapper();
		//Convierto los datos de string a una lista de tipo personas
		try {
			lista = mapper.readValue(str, new TypeReference<List<Direccion>>() { });
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	
	public Direccion obtenerPorId(Integer id) {
		Direccion direccion = null;
		AbstractConfiguration config = ConfigurationManager.getConfigInstance();
		config.setProperty("direccion.ribbon." + CommonClientConfigKey.ListOfServers, urlsDireccion);

		TipoDireccionesRest servicio = Ribbon.from(TipoDireccionesRest.class);

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
			direccion = mapper.readValue(str, Direccion.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return direccion;
	}
	
}
