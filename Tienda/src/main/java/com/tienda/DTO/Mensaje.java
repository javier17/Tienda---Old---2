package com.tienda.DTO;

public class Mensaje {
	//atributo donde guarda el mensaje
	private String mensaje;


	/**Contructor del mensaje
	 * @param mensaje
	 */
	public Mensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	//respectivos metodos set y get
	/**
	 * 
	 * @return
	 */
	public String getMensaje() {
		return mensaje;
	}
	/**
	 * 
	 * @param mensaje
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}