package ar.edu.unlam.pb1.tp9;


public class Sistema {

	private String nombre;
	Usuario listaDeUsuarios[];// Agrega una lista de usuarios creados


	public Sistema(String nombre) {

		this.nombre = nombre;
		this.listaDeUsuarios = new Usuario [200];

	}
	
	
	
	public Usuario [] obtenerArrayUsuarios() {
		
		return listaDeUsuarios;
		
	}

	// Este metodo recorre el array de usuarios y agrega un usuario si tiene un
	// elemento vacio
	public void agregarUsuarios(Usuario usuario) {

		for (int i = 0; i < listaDeUsuarios.length; i++) {

			if (listaDeUsuarios[i] == null) {
				listaDeUsuarios[i] = usuario;
				return; //rompe la ejecucion, provoca que se agregue una unica vez
			}

		}

	}

	// Este metodo evalua si el usuario existe
	public boolean existe(String usuario) {

		for (int i = 0; i < listaDeUsuarios.length; i++) {

			if (listaDeUsuarios[i] != null && listaDeUsuarios[i].getUsuario().equals(usuario)) {
				return true;

			}
		}

		return false;
	}



	public Usuario buscarUsuarioPorNombreDeUsuario(String usuario) {

		for (int i = 0; i < listaDeUsuarios.length; i++) {

			if (listaDeUsuarios[i] != null && listaDeUsuarios[i].getUsuario().equalsIgnoreCase(usuario)) {
				return listaDeUsuarios[i];
			}

		}

		return null;
	}

	public Usuario[] buscarUsuariosBloqueados() {

		Usuario acumuladorDeUsuarios[] = new Usuario[listaDeUsuarios.length];
		int contador = 0;

		for (int i = 0; i < listaDeUsuarios.length; i++) {

			if (listaDeUsuarios[i] != null && listaDeUsuarios[i].isEstaBloqueado() == true) {

				acumuladorDeUsuarios[contador] = listaDeUsuarios[i];
				contador++;
			}

		}
		return acumuladorDeUsuarios;

	}

	public Usuario[] buscarUsuariosLogueados() {

		Usuario acumuladorDeUsuarios[] = new Usuario[listaDeUsuarios.length];
		int contador = 0;

		for (int i = 0; i < listaDeUsuarios.length; i++) {

			if (listaDeUsuarios[i] != null && listaDeUsuarios[i].isEstaLogueado() == true) {

				acumuladorDeUsuarios[contador] = listaDeUsuarios[i];
				contador++;
			}

		}
		return acumuladorDeUsuarios;

	}

	public double promedioEdadUsuarios() {

		double sumaEdades = 0;
		int cantidadDeUsuarios = 0;
		double promedio = 0;

		for (int i = 0; i < listaDeUsuarios.length; i++) {

			if (listaDeUsuarios[i] != null) {

				sumaEdades += listaDeUsuarios[i].getEdad();
				cantidadDeUsuarios++;

			}

		}
		
		if(cantidadDeUsuarios < 1) {
			return 0.0; //si no tengo ningun usuario, y aplico el metodo, no va a funcionar. No se puede dividir ningun numero por 0
		}
		
		promedio = sumaEdades / cantidadDeUsuarios;
		return promedio;

	}

	public int cantidadEdadUsuariosMenoresDeEdad() {

		int cantidadDeMenores = 0;

		for (int i = 0; i < listaDeUsuarios.length; i++) {

			if (listaDeUsuarios[i] != null && listaDeUsuarios[i].getEdad() < 18) {

				cantidadDeMenores++;

			}

		}

		return cantidadDeMenores;

	}

	public Usuario usuarioMasPequenio() {

		if ( this.listaDeUsuarios[0] == null ) {
			return null;
		}
          
		Usuario usuarioMasPequenio = this.listaDeUsuarios[0];


		for (int i = 1; i < listaDeUsuarios.length; i++) { //empieza el for en 1 para que no se compare a si mismo

			if (listaDeUsuarios[i] != null && listaDeUsuarios[i].getDni() > usuarioMasPequenio.getDni()) {

				usuarioMasPequenio = listaDeUsuarios[i];
				

			}

		}

		return usuarioMasPequenio;

	}

	public Usuario usuarioMasGrande() {

		if ( this.listaDeUsuarios[0] == null ) {
			return null;
		}
          
		Usuario usuarioMasGrande = this.listaDeUsuarios[0];


		for (int i = 1; i < listaDeUsuarios.length; i++) { //empieza el for en 1 para que no se compare a si mismo

			if (listaDeUsuarios[i] != null && listaDeUsuarios[i].getDni() < usuarioMasGrande.getDni()) {

				usuarioMasGrande = listaDeUsuarios[i];
				

			}
		}

		return usuarioMasGrande;

	}

	public String loguearUsuario(String usuario, String contraseniaIngresada) {

		Usuario usuarioBuscado = buscarUsuarioPorNombreDeUsuario(usuario);

		if (usuarioBuscado == null) {

			return "El usuario no existe";
		}

		if (usuarioBuscado.getContrasena().equals(contraseniaIngresada) ) {

			if(usuarioBuscado.isEstaLogueado()) {
				return "El usuario ya inició sesión";
			}
			
			usuarioBuscado.setEstaLogueado(true);
			return "Usuario logueado exitosamente!";

		}

		return "Usuario o contraseña incorrectos, intentelo nuevamente";

	}

	public String desloguearUsuario(String usuario) {

		Usuario usuarioBuscado = buscarUsuarioPorNombreDeUsuario(usuario);

		if (usuarioBuscado == null) {

			return "El usuario no existe";
		}
		
		if(!usuarioBuscado.isEstaLogueado()) {
			return "El usuario no inició sesion";
		}
		
		
		usuarioBuscado.setEstaLogueado(false);
		return "El usuario se deslogueó exitosamente";
	}


	
	public boolean evaluarIntentos(Usuario usuario, String contraseniaIngresada) {
		

		if (!usuario.getContrasena().equals(contraseniaIngresada)
				|| Usuario.esContraseniaValida(contraseniaIngresada) == false) {
				usuario.intentoFallido();
				
				if (usuario.getIntentosFallidos() >= 4) { //mayor a 3

					usuario.setEstaBloqueado(true);
					usuario.reiniciarIntentos(); //reinicio de contador
					return false;
				}
				return false;
		}
		return true;
	}

	
	
	
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

}
