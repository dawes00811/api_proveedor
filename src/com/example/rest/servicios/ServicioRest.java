package com.example.rest.servicios;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.example.rest.dao.ProveedorModel;
import com.example.rest.dao.UsuarioModel;
import com.example.rest.entidades.Proveedor;
import com.example.rest.entidades.Usuario;

@Path("/servicios")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class ServicioRest {
	private static final Log log = LogFactory.getLog(ServicioRest.class);
	private UsuarioModel daoUser = new UsuarioModel();
	private ProveedorModel daoPro = new ProveedorModel();

	@GET
	@Path("/login")
	public Response login(Usuario obj) {
		log.info("login rest ");
		return Response.ok(daoUser.login(obj)).build();
	}

	@GET
	@Path("/usuario")
	public Response listarTodos() {
		log.info("listarTodos rest ");
		return Response.ok(daoUser.listarTodos()).build();
	}
	@GET
	@Path("/proveedor")
	public Response listarProveedorTodos() {
		log.info("listarTodos proveedor rest ");
		return Response.ok(daoPro.listarProveedorTodos()).build();
	}
	@POST
	@Path("/proveedor")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response registra(Proveedor obj) {
		log.info("Registra proveedor " + obj.getIdProveedor());
		if (daoPro.insertaPro(obj) > 0)
			return Response.ok().build();
		else
			return Response.notModified().build();
	}

	@PUT
	@Path("/proveedor")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response atualiza(Proveedor obj) {
		log.info("Actualiza proveedor " + obj.getIdProveedor());
		if (daoPro.actualizaPro(obj) > 0)
			return Response.ok().build();
		else
			return Response.notModified().build();
	}

	@DELETE
	@Path("/proveedor/{idProveedor}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response elimina(@PathParam("idProveedor") int id) {
		log.info("Elimina proveedor " + id);
		if (daoPro.eliminaPro(id) > 0)
			return Response.ok().build();
		else
			return Response.notModified().build();
	}

	

}