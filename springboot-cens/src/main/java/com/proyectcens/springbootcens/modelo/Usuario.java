package com.proyectcens.springbootcens.modelo;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "usuarios", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellido")
	private String apellido;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "rut")
	private String rut;

	@Column(name = "telefono")
	private String telefono;

	@ManyToOne
	@JoinColumn(name = "empresa_id", referencedColumnName = "id")
	private Empresa empresa;

	@ManyToMany
	@JoinTable(name = "usuarios_roles", joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "rol_id", referencedColumnName = "id"))
	private Collection<Rol> rol;

	public Usuario() {
	}

	public Usuario(Long id, String nombre, String apellido, String email, String password, String rut, String telefono,
			Empresa empresa, Collection<Rol> rol) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
		this.rut = rut;
		this.telefono = telefono;
		this.empresa = empresa;
		this.rol = rol;
	}

	public Usuario(String nombre, String apellido, String email, String password, String rut, String telefono,
			Empresa empresa) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
		this.rut = rut;
		this.telefono = telefono;
		this.empresa = empresa;

	}

	public Usuario(String nombre, String apellido, String email, String password, String rut, String telefono,
			Collection<Rol> rol) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
		this.rut = rut;
		this.telefono = telefono;
		this.rol = rol;
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

	public Collection<Rol> getRol() {
		return rol;
	}

	public void setRol(Collection<Rol> rol) {
		this.rol = rol;
	}

}
