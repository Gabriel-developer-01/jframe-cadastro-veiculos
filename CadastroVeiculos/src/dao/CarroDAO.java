package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import DTO.CarroDTO;
import bd.ConexaoDAO;

public class CarroDAO {
	
	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;
	List<CarroDTO> list = new ArrayList<>();
	
	public void insertVeiculo(CarroDTO carroDto) {
		
		String sql = "INSERT INTO carro (nome, modelo, marca, "
				+ " placa, telefone) "
				+ "	VALUES (?, ?, ?, ?, ?) ";
		
		conn = new ConexaoDAO().conectaBD();
		
		try {
			
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, carroDto.getNome());
			pstm.setString(2, carroDto.getModelo());
			pstm.setString(3, carroDto.getMarca());
			pstm.setString(4, carroDto.getPlaca());
			pstm.setString(5, carroDto.getTelefone());
			
			pstm.execute();
			pstm.close();
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "CarroDAO " + e);
		}
	}
	
	public CarroDTO findByPlaca(String placa) {
		String sql = "SELECT * FROM carro WHERE placa = ?";
		conn = new ConexaoDAO().conectaBD();
		
		CarroDTO carroDto = new CarroDTO();
		try {
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, placa);;
			
			rs = pstm.executeQuery();
			
			while (rs.next()) {
	
				carroDto.setId(rs.getInt("id"));
				carroDto.setNome(rs.getString("nome"));
				carroDto.setModelo(rs.getString("modelo"));
				carroDto.setMarca(rs.getString("marca"));
				carroDto.setPlaca(rs.getString("placa"));
				carroDto.setTelefone(rs.getString("telefone"));	
				
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "CarroDAO findByPlaca: " + e);
		}
		
		return carroDto;
	}
}