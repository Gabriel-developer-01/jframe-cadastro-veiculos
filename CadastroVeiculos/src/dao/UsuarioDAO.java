package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import DTO.CarroDTO;
import DTO.UsuarioDTO;
import bd.ConexaoDAO;

public class UsuarioDAO {
	
	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;
	
	public void insertUsuario(UsuarioDTO usuarioDto) {
		
		String sql = "INSERT INTO usuario (nome, telefone) "
					 + " VALUES (?, ?) ";
		
		conn = new ConexaoDAO().conectaBD();
		
		try {
			
			pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			pstm.setString(1, usuarioDto.getNome());
			pstm.setString(2, usuarioDto.getTelefone());
			
			pstm.execute();
			ResultSet keys = pstm.getGeneratedKeys();
			keys.next();
            int key = keys.getInt(1);
            
            usuarioDto.setId(key);
            keys.close();
			pstm.close();
	
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "UsuarioDAO " + e);
		}
	}
	
	public UsuarioDTO findByPlaca(String placa) {
		String sql = "SELECT u.nome, u.telefone, c.modelo, c.marca, c.placa FROM usuario u JOIN carro c ON u.id = c.id_usuario WHERE c.placa = ?";
		conn = new ConexaoDAO().conectaBD();
		
		UsuarioDTO usuarioDto = new UsuarioDTO();
		CarroDTO carroDto = new CarroDTO();
		
		try {
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, placa);
			
			rs = pstm.executeQuery();
			
			while (rs.next()) {
	
				usuarioDto.setNome(rs.getString("nome"));
				usuarioDto.setTelefone(rs.getString("telefone"));
				carroDto.setModelo(rs.getString("modelo"));
				carroDto.setMarca(rs.getString("marca"));
				carroDto.setPlaca(rs.getString("placa"));
				usuarioDto.setCarro(carroDto);
				
			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "CarroDAO findByPlaca: " + e);
		}
		
		return usuarioDto;
	}
}