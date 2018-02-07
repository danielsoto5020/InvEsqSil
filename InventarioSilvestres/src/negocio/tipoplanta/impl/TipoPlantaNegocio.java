package negocio.tipoplanta.impl;

import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;

import dao.tipoplanta.ITipoPlantaDAO;
import dao.tipoplanta.jdbc.TipoPlantaDAO;
import dto.TipoPlantaDTO;
import negocio.tipoplanta.ITipoPlantaNegocio;
import util.PersistUtil;

public class TipoPlantaNegocio implements ITipoPlantaNegocio{
		
		private ITipoPlantaDAO tipoPlantaDAO;
	    private DataSource dataSource;
		
		public TipoPlantaNegocio(){
			dataSource = PersistUtil.getDataSource();
			tipoPlantaDAO = new TipoPlantaDAO();
		}
		
		@Override
		public TipoPlantaDTO consultarTipoPlantaPorId(Integer id) {
			Connection con = null;
			TipoPlantaDTO tipoPlantaDTO = null;
			try {
				con = dataSource.getConnection();
				tipoPlantaDTO= tipoPlantaDAO.consultarTipoPlantaPorId(id, con);
			} catch (Exception e) {
				System.out.println(e.toString());
			} finally {
				PersistUtil.closeConnection(con);
			}
			return tipoPlantaDTO;
		}

		@Override
		public String actualizarTipoPlanta(TipoPlantaDTO tipoPlantaDTO) {
			Connection con = null;
			String message="";
			try {
				con = dataSource.getConnection();
				message = tipoPlantaDAO.actualizarTipoPlanta(tipoPlantaDTO, con);
			} catch (Exception e) {
				System.out.println(e.toString());
			} finally {
				PersistUtil.closeConnection(con);
			}
			return message;
		}

		@Override
		public String crearTipoPlanta(TipoPlantaDTO tipoPlantaDTO) {
			Connection con = null;
			String message="";
			try {
				con = dataSource.getConnection();
				message = tipoPlantaDAO.crearTipoPlanta(tipoPlantaDTO, con);
			} catch (Exception e) {
				System.out.println(e.toString());
			} finally {
				PersistUtil.closeConnection(con);
			}
			return message;
		}

		@Override
		public String borrarTipoPlanta(Integer id) {
			Connection con = null;
			String message="";
			try {
				con = dataSource.getConnection();
				message = tipoPlantaDAO.borrarTipoPlanta(id, con);
			} catch (Exception e) {
				System.out.println(e.toString());
			} finally {
				PersistUtil.closeConnection(con);
			}
			return message;
		}

		@Override
		public List<TipoPlantaDTO> ListarTipoPlantas() {
			Connection con = null;
			List<TipoPlantaDTO> listaTipoPlantas = null;
			try {
				con = dataSource.getConnection();
				listaTipoPlantas= tipoPlantaDAO.ListarTipoPlantas(con);
			} catch (Exception e) {
				System.out.println(e.toString());
			} finally {
				PersistUtil.closeConnection(con);
			}
			return listaTipoPlantas;
		}

}
