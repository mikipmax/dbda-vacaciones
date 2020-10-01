package com.distribuida.res;

import java.util.Set;

import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Destroyed;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.agent.model.NewService;


@ApplicationPath(value = "/")
@ApplicationScoped
public class RestApplication extends Application {
	
	@Inject
	@ConfigProperty(name = "server.port", defaultValue = "7025")
	private Integer puerto;

	@Inject
	@ConfigProperty(name = "consul.port", defaultValue = "localhost")
	private String consulHost;

	@Inject
	@ConfigProperty(name = "consul.port", defaultValue = "8500")
	private Integer consulPort;

	private String ID = UUID.randomUUID().toString();
	
	@Override
	public Set<Class<?>> getClasses() {
		return Set.of(SingerRest.class);
	}
	
	public void init(@Observes @Initialized(ApplicationScoped.class) Object init) {

		System.out.println("inicializando");

		ConsulClient client = new ConsulClient();
		NewService newService = new NewService();
		newService.setId(ID);
		newService.setName("singer");
		newService.setAddress("127.0.0.1"); // donde se esta ejecutando la maquina
		newService.setPort(puerto);

		// quita servidores caidos
		client.agentServiceRegister(newService);
	}
	public void destroy(@Observes @Destroyed(ApplicationScoped.class) Object init) {
		System.out.println("Finalizando");

		ConsulClient client = new ConsulClient();
		client.agentServiceDeregister(ID);

	}

	
}
