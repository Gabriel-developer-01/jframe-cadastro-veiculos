package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import DTO.CarroDTO;
import DTO.UsuarioDTO;
import bd.ConexaoDAO;

public class CarroDAO {
	
	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;
	
	public void insertVeiculo(UsuarioDTO usuarioVeiculo) {
		
		String sql = "INSERT INTO carro (modelo, marca, placa, id_usuario) "
				+ "	VALUES (?, ?, ?, ?) ";
		
		conn = new ConexaoDAO().conectaBD();
		
		try {
			
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, usuarioVeiculo.getCarro().getModelo());
			pstm.setString(2, usuarioVeiculo.getCarro().getMarca());
			pstm.setString(3, usuarioVeiculo.getCarro().getPlaca());
			pstm.setInt(4, usuarioVeiculo.getId());
			
			pstm.execute();
			pstm.close();
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "CarroDAO " + e);
		}
	}
}