package becapp.menus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import becapp.Conexion_BBDD;

public class ModificarBeca extends JFrame {

	public ModificarBeca() {

		setTitle("MODIFICACION BECA");
		setBounds(500, 300, 600, 450);
		getContentPane().setLayout(null);

		JButton atras = new JButton("ATRAS");
		atras.setBounds(100, 350, 100, 30);
		getContentPane().add(atras);

		atras.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				dispose();
				GestionBecas gb = new GestionBecas();
				gb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				gb.setVisible(true);

			}
		});

		JTextPane codC = new JTextPane();
		codC.setText("Numero de id");
		codC.setBounds(100, 30, 100, 19);
		getContentPane().add(codC);
		codC.setEditable(false);
		codC.setOpaque(false);

		JTextField cod = new JTextField();
		cod.setBounds(100, 60, 60, 19);
		getContentPane().add(cod);
		cod.setColumns(10);

		JTextPane actualizacionC = new JTextPane();
		actualizacionC.setText("Actualizacion");
		actualizacionC.setBounds(250, 30, 100, 19);
		getContentPane().add(actualizacionC);
		actualizacionC.setEditable(false);
		actualizacionC.setOpaque(false);

		JTextField actualizacion = new JTextField();
		actualizacion.setBounds(250, 60, 250, 19);
		getContentPane().add(actualizacion);
		actualizacion.setColumns(10);

		JTextPane columnaC = new JTextPane();
		columnaC.setText("Columna");
		columnaC.setBounds(100, 100, 100, 19);
		getContentPane().add(columnaC);
		columnaC.setEditable(false);
		columnaC.setOpaque(false);

		JRadioButton nombre = new JRadioButton("nombre");
		nombre.setBounds(100, 130, 120, 23);
		getContentPane().add(nombre);
		nombre.setActionCommand("nombre");

		JRadioButton condiciones = new JRadioButton("condiciones");
		condiciones.setBounds(225, 130, 120, 23);
		getContentPane().add(condiciones);
		condiciones.setActionCommand("condiciones");

		JRadioButton descripcion = new JRadioButton("descripcion");
		descripcion.setBounds(350, 130, 120, 23);
		getContentPane().add(descripcion);
		descripcion.setActionCommand("descripcion");

		JRadioButton contacto = new JRadioButton("contacto");
		contacto.setBounds(100, 160, 120, 23);
		getContentPane().add(contacto);
		contacto.setActionCommand("contacto");

		JRadioButton nombreProveedor = new JRadioButton("proveedor");
		nombreProveedor.setBounds(225, 160, 120, 23);
		getContentPane().add(nombreProveedor);
		nombreProveedor.setActionCommand("nombreProveedor");

		JRadioButton tipoBeca = new JRadioButton("tipo beca");
		tipoBeca.setBounds(350, 160, 120, 23);
		getContentPane().add(tipoBeca);
		tipoBeca.setActionCommand("tipoBeca");

		ButtonGroup grupo1 = new ButtonGroup();
		grupo1.add(nombre);
		grupo1.add(condiciones);
		grupo1.add(descripcion);
		grupo1.add(contacto);
		grupo1.add(nombreProveedor);
		grupo1.add(tipoBeca);

		JButton aceptar = new JButton("ACEPTAR");
		aceptar.setBounds(400, 350, 100, 30);
		getContentPane().add(aceptar);

		aceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Conexion_BBDD conexion = new Conexion_BBDD();
				conexion.conectar();

				String columna;

				// con null devuelve true si no esta seleccionado
				try {

					if (grupo1.isSelected(null)) {

						throw new Exception();
					} 
					
					else if(cod.getText().isEmpty()||cod.getText().isBlank()) {
						
						throw new Exception();
						
					}
					else if(actualizacion.getText().isEmpty()||actualizacion.getText().isBlank()) {
						throw new Exception();
					}
					
					else {

						ButtonModel bm = grupo1.getSelection();
						columna = bm.getActionCommand();
						grupo1.clearSelection();
						int numeroCod= Integer.parseInt(cod.getText());
						if(conexion.modificarBeca(columna, numeroCod, actualizacion.getText())) {
							JOptionPane.showMessageDialog(null, "Actualizacion realiza con exito");
						}
						else {
							JOptionPane.showMessageDialog(null, "Error: al realizar la actualización");
						}

					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Atencion: obligatorio elegir columna a cambiar");
				}

			}
		});
		
		JButton comprobar = new JButton("COMPROBAR ");
		comprobar.setBounds(225, 350, 150, 30);
		getContentPane().add(comprobar);

	}
}
