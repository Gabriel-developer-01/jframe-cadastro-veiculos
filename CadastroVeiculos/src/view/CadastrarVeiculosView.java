package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import DTO.CarroDTO;
import dao.CarroDAO;
import util.LimpaCampos;
import javax.swing.ImageIcon;

public class CadastrarVeiculosView extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField textMarca;
	private JTextField textPlaca;
	private JTextField textNomeCliente;
	private JTextField textModelo;
	private JTextField textConsultarPlaca;
	private JFormattedTextField formattedTextTelefone;
	private JButton btnInserir;
	private JButton btnConsultar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarVeiculosView frame = new CadastrarVeiculosView();
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
	public CadastrarVeiculosView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 844, 466);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNomeCliente = new JLabel("Nome do Cliente:");
		lblNomeCliente.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNomeCliente.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textMarca = new JTextField();
		textMarca.setColumns(10);
		
		textPlaca = new JTextField();
		textPlaca.setColumns(10);
		
		textNomeCliente = new JTextField();
		textNomeCliente.setColumns(10);
		
		textModelo = new JTextField();
		textModelo.setColumns(10);
		
		formataCampos();
		
		btnInserir = new JButton("Inserir");
		btnInserir.setIcon(new ImageIcon(CadastrarVeiculosView.class.getResource("/icones/add-icon.png")));
		btnInserir.addActionListener(this);
		btnInserir.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textConsultarPlaca = new JTextField();
		textConsultarPlaca.setColumns(10);
		
		JLabel lblConsultarPlaca = new JLabel("Consultar placa:");
		lblConsultarPlaca.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setIcon(new ImageIcon(CadastrarVeiculosView.class.getResource("/icones/Search-icon.png")));
		btnConsultar.addActionListener(this);
		btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 10));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNomeCliente)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textNomeCliente, GroupLayout.PREFERRED_SIZE, 598, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblModelo, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textModelo, GroupLayout.PREFERRED_SIZE, 293, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblMarca, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textMarca, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblPlaca)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textPlaca, GroupLayout.PREFERRED_SIZE, 371, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(324)
							.addComponent(btnInserir, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblTelefone, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(formattedTextTelefone, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblConsultarPlaca, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textConsultarPlaca, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnConsultar)))
					.addContainerGap(37, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNomeCliente)
						.addComponent(textNomeCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblModelo)
						.addComponent(textModelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMarca)
						.addComponent(textMarca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPlaca)
						.addComponent(textPlaca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(5)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTelefone)
						.addComponent(formattedTextTelefone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnInserir)
					.addGap(43)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblConsultarPlaca)
						.addComponent(textConsultarPlaca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnConsultar))
					.addContainerGap(162, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	private void formataCampos() {
		try {
			formattedTextTelefone = new JFormattedTextField(new MaskFormatter("(##) 9####-####"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnConsultar) {
			handle_btnConsultar_actionPerformed(e);
		}
		if (e.getSource() == btnInserir) {
			handle_btnInserir_actionPerformed(e);
		}
	}
	
	protected void handle_btnInserir_actionPerformed(ActionEvent e) {
		if(validarCampos()) {
			CarroDTO veiculo = prepararVeiculos();
			
			CarroDAO carroDao = new CarroDAO();
			
			int confirm = JOptionPane.showConfirmDialog(null, "Deseja cadastrar seu veículo?");
			if(confirm == JOptionPane.YES_OPTION) {
				carroDao.insertVeiculo(veiculo);
				JOptionPane.showMessageDialog(null, "Veículo cadastrado com sucesso!");
				LimpaCampos.LimpaTela(getContentPane());
			}
		}
	}
	
	protected void handle_btnConsultar_actionPerformed(ActionEvent e) {
		
		CarroDAO carroDao = new CarroDAO();
		String placa = textConsultarPlaca.getText();
		
		CarroDTO veiculoSelecionado = carroDao.findByPlaca(placa);
		
		if(placa.equals(veiculoSelecionado.getPlaca())) {
			carregarDadosFormulario(veiculoSelecionado);
		}
	}

	private void carregarDadosFormulario(CarroDTO veiculoSelecionado) {
		textNomeCliente.setText(veiculoSelecionado.getNome());
		textModelo.setText(veiculoSelecionado.getModelo());
		textMarca.setText(veiculoSelecionado.getMarca());
		textPlaca.setText(veiculoSelecionado.getPlaca());
		formattedTextTelefone.setText(veiculoSelecionado.getTelefone());
	}
	
	private boolean validarCampos() {
		String nome = textNomeCliente.getText();
		String modelo = textModelo.getText();
		String placa = textPlaca.getText();
		// foi utilizados um regex para tirar pontuações e traços dos campos formatados.
		Integer telefone = formattedTextTelefone.getText().replaceAll("\\D", "").length();
		
		if(nome.isEmpty() || modelo.isEmpty() || placa.isEmpty() || telefone.equals(1)) {
			JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos obrigatórios: Nome, Modelo, Placa e telefone");
		}else {
			return true;
		}
		
		return false;
	}
	
	private CarroDTO prepararVeiculos() {
		CarroDTO veiculo = new CarroDTO();
		veiculo.setNome(textNomeCliente.getText());
		veiculo.setModelo(textModelo.getText());
		veiculo.setMarca(textMarca.getText());
		veiculo.setPlaca(textPlaca.getText());
		veiculo.setTelefone(formattedTextTelefone.getText());	
		return veiculo;
	}
}
