package com.distribuida.consul;

import java.util.List;
import java.util.stream.Collectors;

import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.QueryParams;
import com.ecwid.consul.v1.Response;
import com.ecwid.consul.v1.health.HealthServicesRequest;
import com.ecwid.consul.v1.health.model.HealthService;

public class GetUrl {

	private static final String SRVPERSONA = "persona"; //nombre del servicio registrado en consul
	private static final String SRVDIRECCION = "direccion"; 

	/**
	 * 
	 * @return devuelve las urls de de todas las instancias de una persona en consul
	 */
	public static String getUrlPersona() {
		ConsulClient cliente = new ConsulClient("127.0.0.1"); //instancio un cliente de consul en localhost
		HealthServicesRequest request = HealthServicesRequest.newBuilder().setPassing(true)
				.setQueryParams(QueryParams.DEFAULT).build();  // compruebo los servicios saludables

		Response<List<HealthService>> srvEnLinea = cliente.getHealthServices(SRVPERSONA, request); // guardo en una lista los servicios en línea

		List<HealthService> datos = srvEnLinea.getValue();  
		System.out.println("test1------------------------------------ "+datos);
		List<String> ipPuerto = datos.stream().map(s -> s.getService())
				.map(s -> String.format("%s:%d", s.getAddress(), s.getPort())).collect(Collectors.toList()); //mapeo los servicios 

		StringBuilder sb = new StringBuilder(); // para construir string (consultar)

		for (String st : ipPuerto) { //recorro  cada url y la guardo en el string st con su respectivo puerto
			sb.append(st);
			sb.append(",");
		}
		System.out.println("test2-------------------------------------"+sb);
		System.out.println("test3-------------------------------------"+sb.toString());

		return sb.toString();
	}

	public static String getUrlDireccion() {
		ConsulClient cliente = new ConsulClient("127.0.0.1");
		HealthServicesRequest request = HealthServicesRequest.newBuilder().setPassing(true)
				.setQueryParams(QueryParams.DEFAULT).build();

		Response<List<HealthService>> srvEnLinea = cliente.getHealthServices(SRVDIRECCION, request);

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
