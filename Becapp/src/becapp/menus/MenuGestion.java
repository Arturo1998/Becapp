package becapp.menus;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import becapp.menus.Ficheros.Log;

public class MenuGestion extends JFrame {

	public MenuGestion() {

		setTitle("MENU DE GESTION");
		setBounds(500, 300, 600, 450);
		getContentPane().setLayout(null);

		JButton gestionAdministrador = new JButton("Gestión de Administradores");
		gestionAdministrador.setBounds(100, 150, 400, 30);
		getContentPane().add(gestionAdministrador);

		JButton salir = new JButton("ATRAS");
		salir.setBounds(100, 250, 100, 30);
		getContentPane().add(salir);

		JButton Becas = new JButton("Gestión de becas");
		Becas.setBounds(100, 50, 400, 30);
		getContentPane().add(Becas);
		Becas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				GestionBecas gestionBecas = new GestionBecas();
				gestionBecas.setVisible(true);
				dispose();

			}
		});
		
		JButton log = new JButton("VER LOG");
		log.setBounds(400, 250, 100, 30);
		getContentPane().add(log);
		
		log.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Log log = new Log ();
				try {
					String datos=log.leerLog();
					JOptionPane.showMessageDialog(null, datos);
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		});
		
		
		

	}
}
