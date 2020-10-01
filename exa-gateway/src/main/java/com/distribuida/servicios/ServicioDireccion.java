package com.distribuida.servicios;

import java.util.List;

import org.apache.commons.configuration.AbstractConfiguration;

import com.distribuida.consul.ObtenerUrl;
import com.distribuida.dto.TipoDireccion;
import com.distribuida.rest.TipoDireccionesRest;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.client.config.CommonClientConfigKey;
import com.netflix.config.ConfigurationManager;
import com.netflix.ribbon.Ribbon;
import com.netflix.ribbon.RibbonRequest;

import io.netty.buffer.ByteBuf;

public class ServicioDireccion {

	private String urlsDireccion = ObtenerUrl.urlDireccion();

	public List<TipoDireccion> listarTodo() {
		List<TipoDireccion> lista = null;
		AbstractConfiguration config = ConfigurationManager.getConfigInstance();
		config.setProperty("Servicio-direccion.ribbon." + CommonClientConfigKey.ListOfServers, urlsDireccion);

		TipoDireccionesRest servicio = Ribbon.from(TipoDireccionesRest.class);

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
			lista = mapper.readValue(str, new TypeReference<List<TipoDireccion>>() { });
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	
	public TipoDireccion obtenerPorId(Integer id) {
		TipoDireccion direccion = null;
		AbstractConfiguration config = ConfigurationManager.getConfigInstance();
		config.setProperty("Servicio-direccion.ribbon." + CommonClientConfigKey.ListOfServers, urlsDireccion);

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
			direccion = mapper.readValue(str, TipoDireccion.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return direccion;
	}
	
}
