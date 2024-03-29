package com.distribuida.conexion;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class ConexionDatos {
	@Inject
	@ConfigProperty(name = "usuario")
	private String usuario;
	
	@Inject
	@ConfigProperty(name = "cadena")
	private String cadena;
	
	@Inject
	@ConfigProperty(name = "password")
	private String password;
	
	@Inject
	@ConfigProperty(name = "driver")
	private String driver;

	//Nos devuelve un objeto que vamos a utilizar
	@ApplicationScoped
	@Produces
	public DataSource dataSource() {
		BasicDataSource db = new BasicDataSource();
		db.setDriverClassName(driver);
		db.setUrl(cadena);
		db.setUsername(usuario);
		db.setPassword(password);
		return db;
		
	}
}
