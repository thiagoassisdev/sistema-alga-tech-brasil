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

import br.com.fiap.beans.Colheita;
import br.com.fiap.bo.ColheitaBO;

@Path("/colheita")
public class ColheitaResource {

	private ColheitaBO colheitaBO = new ColheitaBO();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Colheita> selecionarRs() throws ClassNotFoundException, SQLException {
		return (ArrayList<Colheita>) colheitaBO.selecionarBo();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response inserirRs(Colheita colheita, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
		colheitaBO.inserirBo(colheita);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(colheita.getIdFazenda()));
		return Response.created(builder.build()).build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizarRs(Colheita colheita, @PathParam("idFazenda") int idFazenda) throws ClassNotFoundException, SQLException {
		colheitaBO.atualizarBo(colheita);
		return Response.ok().build();
	}

	@DELETE
	@Path("/{idFazenda}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deletarRs(@PathParam("idFazenda") int idFazenda) throws ClassNotFoundException, SQLException {
		colheitaBO.deletarBo(idFazenda);
		return Response.ok().build();
	}
}