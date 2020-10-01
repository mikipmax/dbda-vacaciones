package com.distribuida.consul;

import java.util.List;

import java.util.stream.Collectors;

import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.QueryParams;
import com.ecwid.consul.v1.Response;
import com.ecwid.consul.v1.health.HealthServicesRequest;
import com.ecwid.consul.v1.health.model.HealthService;


public class ObtenerUrl {
	
	public static final String NAME_PERSONA = "Servicio-persona";
	public static final String NAME_DIRECCION = "Servicio-direccion";
	
	public ObtenerUrl() {
		System.out.println("LLAMA OBTENER URL");
	}
	
	public static String urlPersona() {
		
		ConsulClient cliente = new ConsulClient("127.0.0.1");
		HealthServicesRequest request = HealthServicesRequest.newBuilder().setPassing(true)
				.setQueryParams(QueryParams.DEFAULT).build();
		System.out.println("CONECTA CON CONSUL");
		Response<List<HealthService>> srvEnLinea = cliente.getHealthServices(NAME_PERSONA, request);

		List<HealthService> datos = srvEnLinea.getValue();

		List<String> ipPuerto = datos.stream().map(s -> s.getService())
				.map(s -> String.format("%s:%d", s.getAddress(), s.getPort())).collect(Collectors.toList());
		
		StringBuilder sb = new StringBuilder();

		for (String st : ipPuerto) {
			sb.append(st);
			sb.append(",");
		}
		
		System.out.println(sb.toString());
		
		return sb.toString();
	}
	
	
	public static String urlDireccion() {
		
		ConsulClient cliente = new ConsulClient("127.0.0.1");
		HealthServicesRequest request = HealthServicesRequest.newBuilder().setPassing(true)
				.setQueryParams(QueryParams.DEFAULT).build();
		
		Response<List<HealthService>> srvEnLinea = cliente.getHealthServices(NAME_DIRECCION, request);

		List<HealthService> datos = srvEnLinea.getValue();

		List<String> ipPuerto = datos.stream().map(s -> s.getService())
				.map(s -> String.format("http://%s:%d", s.getAddress(), s.getPort())).collect(Collectors.toList());
		
		StringBuilder sb = new StringBuilder();

		for (String st : ipPuerto) {
			sb.append(st);
			sb.append(",");
		}
		return sb.toString();
	}
	

}
