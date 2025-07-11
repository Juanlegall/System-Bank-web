package Entidades;

import java.time.LocalDate;
import java.util.List;
public class Persona {

	    private String dni;
	    private String cuil;
	    private String nombre;
	    private String apellido;
	    private String sexo;
	    private Pais pais;
	    private List<String> telefonos;
	    private LocalDate fechaNacimiento;
	    private String direccion;
	    private Localidad localidad;  
	    private Provincia provincia;
	    private String correoElectronico;
	    private boolean estado;

	    public Persona() {}

	    public Persona(String dni, String cuil, String nombre, String apellido, String sexo, Pais pais,
	                   LocalDate fechaNacimiento, String direccion, Localidad localidad,Provincia provincia, String correoElectronico) {
	        this.dni = dni;
	        this.cuil = cuil;
	        this.nombre = nombre;
	        this.apellido = apellido;
	        this.sexo = sexo;
	        this.pais = pais;
	        this.fechaNacimiento = fechaNacimiento;
	        this.direccion = direccion;
	        this.localidad = localidad;
	        this.provincia = provincia;
	        this.correoElectronico = correoElectronico;
	    }


	    public String getDni() {
	        return dni;
	    }
	    public void setDni(String dni) {
	        this.dni = dni;
	    }
	    public String getCuil() {
	        return cuil;
	    }
	    public void setCuil(String cuil) {
	        this.cuil = cuil;
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
	    public String getSexo() {
	        return sexo;
	    }
	    public void setSexo(String sexo) {
	        this.sexo = sexo;
	    }
	    
	    public Pais getPais() {
			return pais;
		}

		public void setPais(Pais pais) {
			this.pais = pais;
		}

		public LocalDate getFechaNacimiento() {
	        return fechaNacimiento;
	    }
	    public void setFechaNacimiento(LocalDate fechaNacimiento) {
	        this.fechaNacimiento = fechaNacimiento;
	    }
	    public String getDireccion() {
	        return direccion;
	    }
	    public void setDireccion(String direccion) {
	        this.direccion = direccion;
	    }
	    
	    public Localidad getLocalidad() {
			return localidad;
		}

		public void setLocalidad(Localidad localidad) {
			this.localidad = localidad;
		}

		public Provincia getProvincia() {
			return provincia;
		}

		public void setProvincia(Provincia provincia) {
			this.provincia = provincia;
		}

		public String getCorreoElectronico() {
	        return correoElectronico;
	    }
	    public void setCorreoElectronico(String correoElectronico) {
	        this.correoElectronico = correoElectronico;
	    }
	    

	    public boolean isEstado() {
			return estado;
		}

		public void setEstado(boolean estado) {
			this.estado = estado;
		}

		public List<String> getTelefonos() {
		    return telefonos;
		}

		public void setTelefonos(List<String> telefonos) {
		    this.telefonos = telefonos;
		}

		@Override
	    public String toString() {
	        return nombre + " " + apellido + " | DNI: " + dni + " | CUIL: " + cuil + " | Nacido: " + fechaNacimiento;
	    }
	}

