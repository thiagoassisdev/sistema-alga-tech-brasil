package br.com.fiap.resource;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.beans.Medicao;
import br.com.fiap.bo.MedicaoBO;

@Path("/medicao")
public class MedicaoResource {

	private MedicaoBO medicaoBO = new MedicaoBO();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Medicao> selecionarRs() throws ClassNotFoundException, SQLException {
		return (ArrayList<Medicao>) medicaoBO.selecionarBo();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response inserirRs(Medicao medicao, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
		medicaoBO.inserirBo(medicao);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(medicao.getIdSensor()));
		return Response.created(builder.build()).build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizarRs(Medicao medicao, @PathParam("idSensor") int idSensor) throws ClassNotFoundException, SQLException {
		medicaoBO.atualizarBo(medicao);
		return Response.ok().build();
	}

	@DELETE
	@Path("/{idSensor}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deletarRs(@PathParam("idSensor") int idSensor) throws ClassNotFoundException, SQLException {
		medicaoBO.deletarBo(idSensor);
		return Response.ok().build();
	}
}