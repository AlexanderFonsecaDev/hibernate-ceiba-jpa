package com.ceiba.hibernate.vista;

import javax.swing.JOptionPane;

import com.ceiba.hibernate.controlador.UsuarioController;

public class index {
	
	private static UsuarioController usuarioControlado = new UsuarioController();
	
	@SuppressWarnings("unchecked")
	public static void main(String args[]) {
		try {
			
			int funcion = Integer.parseInt(JOptionPane.showInputDialog("Bienvenido al prestamo de libros" + "\n" + "1 - Usuarios" + "\n" + "2 - Libros" + "\n" + "3 - Prestamos"));
			switch (funcion) {
			case 1:
				int metodo = Integer.parseInt(JOptionPane.showInputDialog("Menu de usuarios" + "\n" + "1 - Registrar" + "\n" + "2 - Listar" + "\n" + "3 - Buscar" + "\n" + "4 - Eliminar"));
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
				String rol = JOptionPane.showInputDialog("Esibra el nombre");
				break;

			default:
				break;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Oppss.. al parecer aun no desarrollamos esa funcion");
		}
	}
	
}
