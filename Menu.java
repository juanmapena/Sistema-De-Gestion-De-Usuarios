package ar.edu.unlam.pb1.tp9;

public enum Menu {

	ACTUALIZAR_NOMBRE_SISTEMA ("1. Ingresar un nombre a su sistema"), AGREGAR_USUARIO ("2. Agregar un usuario"), LOGUEAR_DESLOGUEAR_USUARIO ("3. Loguear o Desloguear un usuario"), DESBLOQUEAR_USUARIO ("4. Desbloquear un usuario"), VER_ESTADO_DE_USUARIOS ("5. Ver estado de los usuarios"), BUSCAR_UN_USUARIO_POR_NOMBRE ("6. Buscar un usuario por su nombre de usuario"), BUSCAR_USUARIOS_BLOQUEADOS ("7. Buscar usuarios bloqueados"), BUSCAR_USUARIOS_LOGUEADOS ("8. Buscar usuarios logueados"), CALCULAR_CANTIDAD_USUARIOS_MENORES ("9. Calcular cantidad de usuarios menores de edad: "), CALCULAR_PROMEDIO_EDAD_USUARIOS ("10. Calcular el promedio de edades de los usuarios"), BUSCAR_USUARIO_MAS_PEQUENIO ("11. Buscar el usuario mas pequeño en edad: "), BUSCAR_USUARIO_MAS_VIEJO ("12. Buscar el usuario mas viejo en edad: "),SALIR ("13. Salir del menu");
	
	private String mensaje;
	
	
	 Menu (String mensaje) {
		
		this.mensaje = mensaje;
	}
	
	public String toString () {
		
		return this.mensaje;
	}
}
