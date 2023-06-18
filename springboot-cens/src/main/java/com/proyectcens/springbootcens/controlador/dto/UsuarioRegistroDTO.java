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
	private String rol;
	private Empresa empresa;

	public UsuarioRegistroDTO(Long id, String nombre, String apellido, String email, String password, String rut,
			String telefono, Empresa empresa) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
		this.rut = rut;
		this.telefono = telefono;

		this.empresa = empresa;
	}

	public UsuarioRegistroDTO(String nombre, String apellido, String email, String password, String rut,
			String telefono, String rol, Empresa empresa) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
		this.rut = rut;
		this.telefono = telefono;
		this.rol = rol;
		this.empresa = empresa;
	}

	public UsuarioRegistroDTO(String email) {
		this.email = email;
	}

	public UsuarioRegistroDTO() {
	}

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

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

}
