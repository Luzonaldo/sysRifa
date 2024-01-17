package com.devcaotics.sysRifa.model.repositories;

import java.sql.SQLException;
import java.util.List;


import com.devcaotics.sysRifa.model.entities.Apostador;
import com.devcaotics.sysRifa.model.entities.Rifa;

public class RepositoryService {
	
	//implementação do singleton
		private static RepositoryService myself = null;
		
		private Repository<Apostador> repApostador = null;
		private Repository<Rifa> repRifa = null;
		
		private RepositoryService() {
			repApostador = new ApostadorRepository();
			repRifa = new RifaRepository();
		}
		
		public static RepositoryService getCurrentInstance() {
			
			if(myself == null)
				myself = new RepositoryService();
			
			return myself;
			
		}
		//fim da implementação do singleton
		
		public void create(Apostador a) throws SQLException {
			this.repApostador.create(a);
		}
		
		public void update(Apostador a) throws SQLException {
			this.repApostador.update(a);
		}
		
		public Apostador read(int codigo) throws SQLException {
			return this.repApostador.read(codigo);
		}
		
		public void delete(int codigo) throws SQLException {
			this.repApostador.delete(codigo);
		}
		
		public List<Apostador> readAll() throws SQLException{
			return this.repApostador.readAll();
		}
		
		public void create(Rifa r) throws SQLException {
			
			this.repRifa.create(r);
			
		}
		
		public Rifa readRifa(int codigo) throws SQLException {
			
			return this.repRifa.read(codigo);
			
		}

}
