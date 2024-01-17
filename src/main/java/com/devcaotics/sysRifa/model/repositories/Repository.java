package com.devcaotics.sysRifa.model.repositories;

import java.sql.SQLException;
import java.util.List;

public interface Repository<T> {

	public void create(T t) throws SQLException;
	public void update(T t) throws SQLException;
	public T read(int codigo) throws SQLException;
	public void delete(int codigo) throws SQLException;
	public List<T> readAll() throws SQLException;
	
}
