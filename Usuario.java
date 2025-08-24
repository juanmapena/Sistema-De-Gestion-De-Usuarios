package ar.edu.unlam.pb1.tp9;



public class Usuario {

	
	private String usuario;
	private String contrasena;
	private String nombre;
	private String apellido;
	private int dni;
	private int edad;
	private boolean estaLogueado;
	private boolean estaBloqueado;
	private int intentosFallidos;
	
	

	public Usuario (String usuario, String contrasena, String nombre, String apellido, int dni, int edad) {
		
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.edad = edad;
		this.estaBloqueado = false;
		this.estaLogueado = false;
		this.intentosFallidos = 0;
		
		
		
	}
	
	
	public static boolean esContraseniaValida (String contrasena) {

		if(hayNumero(contrasena) == true && hayMinusculas(contrasena) == true && hayMayuscula(contrasena) == true && evaluarCaracteres(contrasena) == true) {
			return true;
		}else {
			return false;
		}
		

}
	

	
	//Este metodo evalua que esté logueado
	public boolean isEstaLogueado() {
		return estaLogueado;
	}
	
	
	
	public void setEstaLogueado(boolean estaLogueado) {
		this.estaLogueado = estaLogueado;
	}

	public void setEstaBloqueado(boolean estaBloqueado) {
		this.estaBloqueado = estaBloqueado;
	}

	//Este metodo evalua que esté bloqueado
	public boolean isEstaBloqueado() {
		return estaBloqueado;
	}


	//Cambia el estado de el atributo del estaLogueado
	public void desloguear() {
		this.estaLogueado = false;
	}


	public static boolean evaluarCaracteres(String contrasena) {
		if(contrasena.length() > 7) { 
			
			return true;
		}
		
		return false;
	}


	public static boolean hayMinusculas(String contrasena) {
		int minusculas = 0;
		for (int i = 0; i < contrasena.length(); i++) { //para recorrer la contraseña y ver que contenga al menos 3 letras minusculas
			
			
			if(Character.isLowerCase(contrasena.charAt(i))) { //analiza si el caracter esta en minuscula, para eso llama al metodo charAt en donde evalua el indice de cada caracter en base a su indice
				minusculas++;
				
				
			}
			
			if (minusculas >= 3) {
				return true;
			}
					
		}
		return false;
	}


	public static boolean hayMayuscula(String contrasena) {
		for (int i = 0; i < contrasena.length(); i++ ) {
			
			if(Character.isUpperCase(contrasena.charAt(i))) {
				return true;
			}
			
		}
		
		return false;
	}


	public static boolean hayCaracterEspecial(String contrasena) {
		for (int i = 0 ; i < contrasena.length(); i++) {
			if(!Character.isDigit(contrasena.charAt(i)) && (!Character.isLetter(contrasena.charAt(i) ) && (!Character.isWhitespace(contrasena.charAt(i) )  ) )) {
				
				return true;

		}

		}
		
		return false;
	}


	public static boolean hayNumero(String contrasena) {
		for (int i = 0; i < contrasena.length(); i++) {
			
			if(Character.isDigit(contrasena.charAt(i))) {
				return true;
			}
			
		}
		
		return false;
	}


	public void desbloquearUsuario () {
		
		this.intentosFallidos = 0;
		this.estaBloqueado = false;
		
	}

	//Ver el estado de los usuarios
	public String toString() {
		return  "Usuario: " + this.usuario + '\n' +
                "Nombre: " + this.nombre + '\n' +
                "Apellido: " + this.apellido + '\n' +
                "DNI: " + this.dni + '\n' +
                "Edad: " + this.edad + '\n' +
                "Logueado: " + this.estaLogueado + '\n' +
                "Bloqueado: "+ this.estaBloqueado;
	}


	public void intentoFallido () {
		this.intentosFallidos++;
	}
	
	public void reiniciarIntentos() {
		
		this.intentosFallidos = 0;
		
	}
	public String getUsuario() {
		return usuario;
	}


	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public String getNombre() {
		return nombre;
	}
	
	
	
	public int getIntentosFallidos() {
		return intentosFallidos;
	}


	public String getContrasena() {
		return contrasena;
	}

	public int getEdad() {
		return edad;
	}

	public int getDni() {
		return dni;
	}

	public String getApellido() {
		return apellido;
	}
	
	
	
}
