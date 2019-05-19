package com.ceiba.hibernate.vista;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import com.ceiba.hibernate.controlador.LibroController;
import com.ceiba.hibernate.controlador.PrestamoController;
import com.ceiba.hibernate.controlador.UsuarioController;

public class index {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("aplicacion");
	private static EntityManager manager = emf.createEntityManager();

	private static UsuarioController usuarioControlado = new UsuarioController(manager, emf);
	private static LibroController libroControlado = new LibroController(manager, emf);
	private static PrestamoController prestamoControlado = new PrestamoController(manager, emf);

	@SuppressWarnings("unchecked")
	public static void main(String args[]) {
		menu();
	}

	public static void menu() {
		try {

			int funcion = Integer.parseInt(JOptionPane.showInputDialog("Bienvenido al prestamo de libros" + "\n"
					+ "1 - Usuarios" + "\n" + "2 - Libros" + "\n" + "3 - Prestamos"));
			switch (funcion) {
			case 1:
				int metodo = Integer.parseInt(
						JOptionPane.showInputDialog("Menu de usuarios" + "\n" + "1 - Registrar" + "\n" + "2 - Buscar"));
				menuUsuario(metodo);
				break;
			case 2:
				metodo = Integer.parseInt(
						JOptionPane.showInputDialog("Menu de Libros" + "\n" + "1 - Registrar" + "\n" + "2 - Buscar"));
				menuLibro(metodo);
				break;
			case 3:
				metodo = Integer.parseInt(
						JOptionPane.showInputDialog("Menu de Prestamos" + "\n" + "1 - Registrar" + "\n" + "2 - Buscar"));
				menuPrestamo(metodo);
				break;

			default:
				JOptionPane.showMessageDialog(null, "Oppss.. al parecer aun no desarrollamos esa funcion");
				break;
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Oppss.. parece que digito una opcion no valida");
		}
	}

	public static void menuUsuario(int metodo) {
		try {
			switch (metodo) {
			case 1:
				JOptionPane.showMessageDialog(null, "Digite los datos del usuario");
				String nombre = JOptionPane.showInputDialog("Escriba el nombre");
				String identificacion = JOptionPane.showInputDialog("Escriba el identificacion");
				String rol = JOptionPane.showInputDialog("Esibra el rol");
				String msg = usuarioControlado.registrarUsuario(nombre, identificacion, rol);
				JOptionPane.showMessageDialog(null, msg);
				menu();
				break;
			case 2:
				JOptionPane.showMessageDialog(null, "Digite la identificacion del usuario");
				identificacion = JOptionPane.showInputDialog("Escriba la identificacion");
				msg = usuarioControlado.buscarUsuario(identificacion);
				JOptionPane.showMessageDialog(null, msg);
				menu();
				break;
			default:
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Oppss.. al parecer aun no desarrollamos esa funcion");
		}
	}
	
	public static void menuLibro(int metodo) {
		try {
			switch (metodo) {
			case 1:
				JOptionPane.showMessageDialog(null, "Digite los datos del libro");
				String nombre = JOptionPane.showInputDialog("Escriba el nombre");
				int isbn = Integer.parseInt(JOptionPane.showInputDialog("Escriba el ISBN"));
				int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Esibra la cantidad"));				
				String msg = libroControlado.registrarLibro(isbn, nombre, cantidad, true);
				JOptionPane.showMessageDialog(null, msg);
				menu();
				break;
			case 2:
				
				menu();
				break;
			default:
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Oppss.. al parecer aun no desarrollamos esa funcion");
		}
	}
	
	public static void menuPrestamo(int metodo) {
		try {
			switch (metodo) {
			case 1:
				JOptionPane.showMessageDialog(null, "Digite los datos del usuario");
				String nombre = JOptionPane.showInputDialog("Escriba el nombre");
				String identificacion = JOptionPane.showInputDialog("Escriba el identificacion");
				String rol = JOptionPane.showInputDialog("Esibra el rol");
				String msg = usuarioControlado.registrarUsuario(nombre, identificacion, rol);
				JOptionPane.showMessageDialog(null, msg);
				menu();
				break;
			case 2:
				JOptionPane.showMessageDialog(null, "Digite la identificacion del usuario");
				identificacion = JOptionPane.showInputDialog("Escriba la identificacion");
				msg = usuarioControlado.buscarUsuario(identificacion);
				JOptionPane.showMessageDialog(null, msg);
				menu();
				break;
			default:
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Oppss.. al parecer aun no desarrollamos esa funcion");
		}
	}

}
