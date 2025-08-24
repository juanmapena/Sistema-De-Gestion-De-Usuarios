package ar.edu.unlam.pb1.tp9;

import java.util.Scanner;

import ar.edu.unlam.pb1.tp9.Menu;
import ar.edu.unlam.pb1.tp9.Sistema;
import ar.edu.unlam.pb1.tp9.Usuario;

public class interfazDelSistema {

	public static void main(String[] args) {

		Sistema sistema;

		sistema = new Sistema(""); // Para actualizar el nombre del Sistema

		Sistema sistema2;
		sistema2 = new Sistema(""); // Para llamar y trabajar con los metodos de los usuarios

		Usuario usuarioCreado = null;

		Scanner teclado = new Scanner(System.in);

		int opcionIngresada = 0;

		Menu opcionSeleccionada = Menu.ACTUALIZAR_NOMBRE_SISTEMA;

		Menu opciones[] = Menu.values();// Metodo que devuelve un array con todos los elementos que tiene el
										// enum

		do {

			System.out.println("--------------------------------");
			System.out.println("Bienvenido al menu del Sistema:");
			mostrarMenu(opciones);
			opcionIngresada = teclado.nextInt();
			teclado.nextLine();
			if (opcionIngresada > 0 && opcionIngresada <= opciones.length) {

				opcionSeleccionada = opciones[opcionIngresada - 1];

			}

			switch (opcionSeleccionada) {
			// case 1:

			case ACTUALIZAR_NOMBRE_SISTEMA:

				actualizarNombreSistema(sistema, teclado);

				break;

			case AGREGAR_USUARIO:

				agregarUsuario(sistema2, teclado);

				break;

			case LOGUEAR_DESLOGUEAR_USUARIO:

				// Intento de logueo

				loguearODesloguear(sistema2, teclado);
				
				
				
				break;

			case DESBLOQUEAR_USUARIO:
				
				desbloquearUsuario(sistema2, teclado);
				

				break;

			case VER_ESTADO_DE_USUARIOS:

				verEstadoDeLosUsuarios(sistema2);

				
				break;

			case BUSCAR_UN_USUARIO_POR_NOMBRE:

				buscarUsuarioPorNombre(sistema2, teclado);

				break;

			case BUSCAR_USUARIOS_BLOQUEADOS:

				buscarUsuariosBloqueados(sistema2);
	
				break;

			case BUSCAR_USUARIOS_LOGUEADOS:

				buscarUsuariosLogueados(sistema2);
				
				break;

			case CALCULAR_CANTIDAD_USUARIOS_MENORES:
				
				calcularCantidadDeUsuariosMenores(sistema2);
				
				
				break;

			case CALCULAR_PROMEDIO_EDAD_USUARIOS:
				
				calcularPromedioEdadUsuarios(sistema2);
				
				break;

			case BUSCAR_USUARIO_MAS_PEQUENIO:
				
				buscarUsuarioMasPequenio(sistema2);
				
				break;

			case BUSCAR_USUARIO_MAS_VIEJO:
				
				buscarUsuarioMasViejo(sistema2);
				
				break;

			case SALIR:

				System.out.println("Saliendo del menu...");

				break;

			}

		} while (opcionSeleccionada != Menu.SALIR);
		
		teclado.close();
	}


	public static void buscarUsuarioMasViejo(Sistema sistema2) {
		System.out.println("A continuación se va a mostrar el usuario mas viejo: ");
		
		Usuario usuarioGrande = sistema2.usuarioMasGrande();
		

		if(usuarioGrande != null) {
			
			System.out.println(usuarioGrande);
		}else {
			System.out.println("No existe ningun usuario");
		}
	}


	public static void buscarUsuarioMasPequenio(Sistema sistema2) {
		System.out.println("A continuación se va a mostrar el usuario mas joven:");
		 Usuario usuarioPequenio = sistema2.usuarioMasPequenio();


		if(usuarioPequenio != null) {
			
			System.out.println(usuarioPequenio);
		}else {
			System.out.println("No existe ningun usuario");
		}
	}


	public static void calcularPromedioEdadUsuarios(Sistema sistema2) {
		System.out.println(
				"A continuación se va a mostrar el calculo del proemdio de edad de todos los usuarios:");
		System.out.println(sistema2.promedioEdadUsuarios());
	}


	public static void calcularCantidadDeUsuariosMenores(Sistema sistema2) {
		System.out.println(
				"A continuación se va a mostrar el calculo de la cantidad de usuarios menores de edad: ");
		System.out.println(sistema2.cantidadEdadUsuariosMenoresDeEdad());
	}


	public static void buscarUsuariosLogueados(Sistema sistema2) {
		System.out.println("A continuación se van a mostrar, los usuarios logueados: ");

		Usuario [] arrayUsuariosLogueados = sistema2.buscarUsuariosLogueados();
		
		if(arrayUsuariosLogueados[0] == null) {
			
			System.out.println("No hay ningun usuario logueado"); //para validar que existan usuarios en el array
			return;
		}
		
		for (int i = 0; i < arrayUsuariosLogueados.length; i++) {
			
			
			if (arrayUsuariosLogueados[i] != null) {
				
				System.out.println(" - " + arrayUsuariosLogueados[i].getUsuario());
			}

		}
	}


	public static void buscarUsuariosBloqueados(Sistema sistema2) {
		System.out.println("A continuación se mostrarán todos los usuarios bloqueados");
		
		Usuario [] arrayUsuariosBloqueados = sistema2.buscarUsuariosBloqueados();
		
		if(arrayUsuariosBloqueados[0] == null) {
			
			System.out.println("No hay ningun usuario bloqueado"); //para validar que existan usuarios en el array
			return;
		}
		
		for (int i = 0; i < arrayUsuariosBloqueados.length; i++) {
			
			
			if (arrayUsuariosBloqueados[i] != null) {
				
				System.out.println(" - " + arrayUsuariosBloqueados[i].getUsuario());
			}

		}
	}


	public static void buscarUsuarioPorNombre(Sistema sistema2, Scanner teclado) {
		System.out.println("Ingrese el nombre del usuario, para buscarlo: ");
		String nombre1 = teclado.nextLine();

		if(sistema2.buscarUsuarioPorNombreDeUsuario(nombre1) != null) {
			
			System.out.println(sistema2.buscarUsuarioPorNombreDeUsuario(nombre1));
		}else {
			System.out.println("El usuario no existe");
		}
	}


	public static void verEstadoDeLosUsuarios(Sistema sistema2) {
		Usuario [] arrayUsuario = sistema2.obtenerArrayUsuarios();
		
		if(arrayUsuario[0] == null) {
			
			System.out.println("No hay usuarios existentes"); //para validar que existan usuarios en el array
			return;
		}
		
		for(int i = 0; i < arrayUsuario.length; i++) {
			
			if(arrayUsuario[i] != null) {
				
				System.out.println(arrayUsuario[i]);
			}
			
		}
	}


	public static void desbloquearUsuario(Sistema sistema2, Scanner teclado) {
		System.out.println("Ingrese el nombre de usuario que usted quiera desbloquear: ");
		String nombreIngresado;
		nombreIngresado = teclado.nextLine();
		Usuario usuarioIngresado = sistema2.buscarUsuarioPorNombreDeUsuario(nombreIngresado);
		
		if (usuarioIngresado != null) {
			
			if (usuarioIngresado.isEstaBloqueado()) {
				System.out.println("Ingrese el nombre de usuario que usted quiera desbloquear: ");
				usuarioIngresado.desbloquearUsuario();
				
				System.out.println("Su usuario ha sido desbloqueado!");
			}else {
				System.out.println("El usuario no está bloqueado");
			}
			
		}else {
			System.out.println("El usuario no existe");
		}
	}


	public static void agregarUsuario(Sistema sistema2, Scanner teclado) {
		Usuario usuarioCreado;
		System.out.println("Ingrese su nombre de usuario:");
		String usuario = teclado.nextLine();
		while (sistema2.existe(usuario)) {
			System.out.println("El usuario que usted desea ingresar, ya existe, elija uno nuevo:");
			usuario = teclado.nextLine();
		}

		System.out.println(
				"Ingrese una contraseña, recuerde que debe tener al menos 8 caracteres, al menos tres letras minusculas, una letra mayuscula, un caracter especial y un numero para que sea VALIDA.");
		String contrasena = teclado.nextLine();
		while (!Usuario.esContraseniaValida(contrasena) == true) {
			System.out.println("Ingrese la contraseña nuevamente");
			contrasena = teclado.nextLine();
		}
		System.out.println("Ingrese un nombre:");
		String nombre = teclado.nextLine();
		System.out.println("Ingrese un apellido");
		String apellido = teclado.nextLine();
		System.out.println("Ingrese su DNI:");
		int dni = teclado.nextInt();
		teclado.nextLine();
		System.out.println("Ingrese su edad:");
		int edad = teclado.nextInt();
		teclado.nextLine();

		usuarioCreado = new Usuario(usuario, contrasena, nombre, apellido, dni, edad);

		sistema2.agregarUsuarios(usuarioCreado); // Agrego al array de usuarios, ese usuario que se esta creando

		System.out.println("Su usuario fue guardado exitosamente!");
	}


	public static void loguearODesloguear(Sistema sistema2, Scanner teclado) {
		System.out.println("Ingrese el nombre de usuario para loguearse: ");

		String nombreDelUsuario = teclado.nextLine();
		
		Usuario usuarioParaLoguear = sistema2.buscarUsuarioPorNombreDeUsuario(nombreDelUsuario);
		
		
		if(usuarioParaLoguear != null) {
			if(usuarioParaLoguear.isEstaLogueado()) {
				sistema2.desloguearUsuario(nombreDelUsuario);
				System.out.println("El usuario ha sido deslogueado con exito");
				return;
			}
			System.out.println("Ingrese la contraseña de su usuario");
			String contrasenia = teclado.nextLine();
			if(sistema2.evaluarIntentos(usuarioParaLoguear, contrasenia) == true) {
				
				sistema2.loguearUsuario(nombreDelUsuario, contrasenia);
				System.out.println("El usuario ha sido logueado con exito!");
			}else {
					System.out.println("Usuario o contraseña incorrectos");
			}
		
		}else {
			System.out.println("El usuario no existe");//si es distinto de null, el usuario no existe

		}
	}


	public static void actualizarNombreSistema(Sistema sistema, Scanner teclado) {
		System.out.println("Actualizá el nombre del sistema:");
		String nombreActualizado;

		nombreActualizado = teclado.nextLine();

		sistema.setNombre(nombreActualizado);

		System.out.println("El nuevo nombre actualizado del sistema es: " + sistema.getNombre());
	} 


	private static void mostrarMenu(Menu[] opciones) {

		System.out.println("Menu de opciones: ");

		for (int i = 0; i < opciones.length; i++) {

			System.out.println(opciones[i]);
		}
	}

}
