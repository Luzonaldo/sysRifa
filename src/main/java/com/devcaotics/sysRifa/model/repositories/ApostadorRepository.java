package com.devcaotics.sysRifa.model.repositories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.devcaotics.sysRifa.model.entities.Apostador;

public final class ApostadorRepository implements Repository<Apostador>{
	
	protected ApostadorRepository() {
		
	}
	
	@Override
	public void create(Apostador t) throws SQLException {
		// TODO Auto-generated method stub
		
		String sql = "insert into apostador(nome,localidade,"
				+ "whatsapp, email) values (?,?,?,?)";
		
		PreparedStatement pstm = ConnectionManager
				.getCurrentConnection().prepareStatement(sql);
		
		pstm.setString(1, t.getNome());
		pstm.setString(2, t.getLocalidade());
		pstm.setString(3, t.getWhatsapp());
		pstm.setString(4, t.getEmail());
		
		pstm.execute();
	
	}

	@Override
	public void update(Apostador t) throws SQLException {
		// TODO Auto-generated method stub
		
		String sql = "update Apostador "
				+ "set nome=?, localidade=?, whatsapp=?, email=? "
				+ "where codigo_apostador=?";
		
		PreparedStatement pstm = ConnectionManager
				.getCurrentConnection().prepareStatement(sql);
		
		pstm.setString(1, t.getNome());
		pstm.setString(2, t.getLocalidade());
		pstm.setString(3, t.getWhatsapp());
		pstm.setString(4, t.getEmail());
		
		pstm.setInt(5, t.getCodigo());
		
		pstm.execute();
		
	}

	@Override
	public Apostador read(int codigo) throws SQLException {
		// TODO Auto-generated method stub
		
		String sql ="select * from Apostador where codigo_apostador=?";
		
		PreparedStatement pstm = ConnectionManager
				.getCurrentConnection().prepareStatement(sql);
		
		pstm.setInt(1, codigo);
		
		ResultSet result = pstm.executeQuery();
		
		if(result.next()) {
			
			Apostador a = new Apostador();
			
			a.setCodigo(result.getInt("codigo_apostador"));
			a.setNome(result.getString("nome"));
			a.setLocalidade(result.getString("localidade"));
			a.setWhatsapp(result.getString("localidade"));
			a.setEmail(result.getString("email"));
			
			return a;
			
		}
		
		return null;
	}

	@Override
	public void delete(int codigo) throws SQLException {
		// TODO Auto-generated method stub
		
		String sql = "delete from Apostador where codigo_apostador = ?";
		
		PreparedStatement pstm = ConnectionManager
				.getCurrentConnection().prepareStatement(sql);
		
		pstm.setInt(1, codigo);
		
		pstm.execute();
		
	}

	@Override
	public List<Apostador> readAll() throws SQLException {
		// TODO Auto-generated method stub
		String sql ="select * from Apostador";
		
		PreparedStatement pstm = ConnectionManager
				.getCurrentConnection().prepareStatement(sql);
		
		
		ResultSet result = pstm.executeQuery();
		
		List<Apostador> apostadores = new ArrayList<>();
		
		while(result.next()) {
			
			Apostador a = new Apostador();
			
			a.setCodigo(result.getInt("codigo_apostador"));
			a.setNome(result.getString("nome"));
			a.setLocalidade(result.getString("localidade"));
			a.setWhatsapp(result.getString("localidade"));
			a.setEmail(result.getString("email"));
			
			apostadores.add(a);
			
		}
		
		return apostadores;
	}

}
