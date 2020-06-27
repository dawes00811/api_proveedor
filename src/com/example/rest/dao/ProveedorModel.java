package com.example.rest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.example.rest.entidades.Proveedor;
import com.example.rest.entidades.Usuario;
import com.example.rest.util.MySqlDBConexion;

public class ProveedorModel {
	
	private static final Log log= LogFactory.getLog(ProveedorModel.class);
	
	public List<Proveedor> listarProveedorTodos() {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		List<Proveedor> lista = new ArrayList<Proveedor>();
		try {
			String sql = "select * from proveedor";
			conn = MySqlDBConexion.getConexion();
			pstm = conn.prepareStatement(sql);
			log.info(pstm);
			rs = pstm.executeQuery();
			Proveedor obj = null;
			while (rs.next()) {
				obj = new Proveedor();
				obj.setIdProveedor(rs.getInt(1));
				obj.setRazonsocial(rs.getString(2));
				obj.setRuc(rs.getString(3));
				obj.setDireccion(rs.getString(4));
				obj.setTelefono(rs.getString(5));
				obj.setCelular(rs.getString(6));
				obj.setContacto(rs.getString(7));
				obj.setEstado(rs.getString(8));
				lista.add(obj);
			}
		} catch (Exception e) {
			log.info(e);
		} finally {
			try {
				if (rs != null)rs.close();
				if (pstm != null)pstm.close();
				if (conn != null)conn.close();
			} catch (SQLException e) {}
		}
		return lista;
	}
	public int insertaPro(Proveedor obj) {
		Connection conn = null;
		PreparedStatement pstm = null;
		int salida = -1;
		try {
			String sql = "insert into proveedor values(null,?,?,?,?,?,?,?)";
			conn = new MySqlDBConexion().getConexion();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, obj.getRazonsocial());
			pstm.setString(2, obj.getRuc());
			pstm.setString(3, obj.getDireccion());
			pstm.setString(4, obj.getTelefono());
			pstm.setString(5, obj.getCelular());
			pstm.setString(6, obj.getContacto());
			pstm.setString(7, obj.getEstado());
			log.info(pstm);
			salida = pstm.executeUpdate();
		} catch (Exception e) {
			log.info(e);
		} finally {
			try {
				if (pstm != null)pstm.close();
			} catch (SQLException e1) {}
			try {
				if (conn != null)conn.close();
			} catch (SQLException e) {}
		}
		return salida;
	}

	
	public int actualizaPro(Proveedor obj) {
		Connection conn = null;
		PreparedStatement pstm = null;
		int salida = -1;
		try {
			String sql = "update proveedor set razonsocial =?, ruc =?, direccion =?, telefono =?, celular =?, contacto =?, estado =? where idProveedor =? ";
			conn = new MySqlDBConexion().getConexion();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, obj.getRazonsocial());
			pstm.setString(2, obj.getRuc());
			pstm.setString(3, obj.getDireccion());
			pstm.setString(4, obj.getTelefono());
			pstm.setString(5, obj.getCelular());
			pstm.setString(6, obj.getContacto());
			pstm.setString(7, obj.getEstado());
			pstm.setInt(8, obj.getIdProveedor());
			log.info(pstm);
			
			salida = pstm.executeUpdate();
		} catch (Exception e) {
			log.info(e);
		} finally {
			try {
				if (pstm != null)pstm.close();
			} catch (SQLException e1) {}
			try {
				if (conn != null)conn.close();
			} catch (SQLException e) {}
		}
		return salida;
	}

	
	public List<Proveedor> consultaPro(int id) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		List<Proveedor> lista = new ArrayList<Proveedor>();
		try {
			String sql = "select * from proveedor where idproveedor = ?";
			conn = new MySqlDBConexion().getConexion();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			log.info(pstm);
			rs = pstm.executeQuery();
			Proveedor bean = null;
			while(rs.next()){
				bean = new Proveedor();
				bean.setIdProveedor(rs.getInt(1));
				bean.setRuc(rs.getString(2));
				bean.setRazonsocial(rs.getString(3));
				bean.setDireccion(rs.getString(4));
				bean.setTelefono(rs.getString(5));
				bean.setCelular(rs.getString(6));
				bean.setContacto(rs.getString(7));
				bean.setEstado(rs.getString(8));
				lista.add(bean);
			}
		} catch (Exception e) {
			log.info(e);
		} finally {
			try {
				if (rs != null)rs.close();
				if (pstm != null)pstm.close();
				if (conn != null)conn.close();
			} catch (SQLException e) {}
		}
		return lista;
	}
	
	public int eliminaPro(int id) {
		Connection conn = null;
		PreparedStatement pstm = null;
		int salida = -1;
		try {
			String sql = "delete from proveedor where idproveedor =?";
			conn = new MySqlDBConexion().getConexion();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			log.info(pstm);
			salida = pstm.executeUpdate();
		} catch (Exception e) {
			log.info(e);
		} finally {
			try {
				if (pstm != null)pstm.close();
			} catch (SQLException e1) {}
			try {
				if (conn != null)conn.close();
			} catch (SQLException e) {}
		}
		return salida;
	}
}
