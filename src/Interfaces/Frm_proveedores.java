package Interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Button;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTable;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;

public class Frm_proveedores extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField textField;
	private JTextField txtRuc;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JTable tablaProveedores;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frm_proveedores frame = new Frm_proveedores();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Frm_proveedores() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 810, 609);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 81, 342, 157);
		panel.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(62, 24, 86, 20);
		panel.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JLabel lblRazonsocial = new JLabel("RAZ\u00D3N SOCIAL:");
		lblRazonsocial.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRazonsocial.setBounds(10, 52, 86, 14);
		panel.add(lblRazonsocial);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCodigo.setBounds(10, 27, 54, 14);
		panel.add(lblCodigo);
		
		textField = new JTextField();
		textField.setBounds(105, 49, 142, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblRuc = new JLabel("RUC:");
		lblRuc.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRuc.setBounds(10, 77, 37, 14);
		panel.add(lblRuc);
		
		txtRuc = new JTextField();
		txtRuc.setBounds(49, 74, 125, 20);
		panel.add(txtRuc);
		txtRuc.setColumns(10);
		
		JLabel lblDireccin = new JLabel("DIRECCI\u00D3N:");
		lblDireccin.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDireccin.setBounds(10, 103, 66, 14);
		panel.add(lblDireccin);
		
		JLabel lblTelfono = new JLabel("TEL\u00C9FONO:");
		lblTelfono.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTelfono.setBounds(10, 128, 66, 14);
		panel.add(lblTelfono);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(86, 100, 212, 20);
		panel.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(79, 125, 119, 20);
		panel.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		JButton btnMostrar = new JButton("MOSTRAR");
		btnMostrar.setBounds(243, 23, 89, 23);
		panel.add(btnMostrar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(442, 81, 143, 157);
		panel_1.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.setBounds(22, 11, 100, 23);
		panel_1.add(btnRegistrar);
		
		JButton btnModificar = new JButton("MODIFICAR");
		btnModificar.setBounds(22, 45, 100, 23);
		panel_1.add(btnModificar);
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setBounds(22, 79, 100, 23);
		panel_1.add(btnEliminar);
		
		JButton btnLimpiar = new JButton("LIMPIAR");
		btnLimpiar.setBounds(22, 113, 100, 23);
		panel_1.add(btnLimpiar);
		
		tablaProveedores = new JTable();
		tablaProveedores.setBorder(new LineBorder(new Color(0, 0, 0)));
		tablaProveedores.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Title 1", "Title 2", "Title 3", "Title 4"
			}
		));
		tablaProveedores.setBounds(57, 472, 361, -163);
		contentPane.add(tablaProveedores);
		
		
	}
}
