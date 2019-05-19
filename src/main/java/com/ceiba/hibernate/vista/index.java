package com.ceiba.hibernate.vista;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import com.ceiba.hibernate.controlador.UsuarioController;

public class index {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("aplicacion");
	private static EntityManager manager = emf.createEntityManager();

	private static UsuarioController usuarioControlado = new UsuarioController(manager, emf);

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

}
