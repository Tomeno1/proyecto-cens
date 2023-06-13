package com.proyectcens.springbootcens.controlador.dto;

import com.proyectcens.springbootcens.modelo.Empresa;

public class UsuarioRegistroDTO {

	private Long id;
	private String nombre;
	private String apellido;
	private String email;
	private String password;
	private String rut;
	private String telefono;
	private Empresa idEmpresa;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Empresa getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Empresa idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public UsuarioRegistroDTO(String nombre, String apellido, String email, String password, String rut,
			String telefono) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
		this.rut = rut;
		this.telefono = telefono;
	}

	public UsuarioRegistroDTO() {

	}

}
