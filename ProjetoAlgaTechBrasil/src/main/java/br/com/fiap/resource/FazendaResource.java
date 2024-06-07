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

import br.com.fiap.beans.Fazenda;
import br.com.fiap.bo.FazendaBO;

@Path("/fazenda")
public class FazendaResource {

	private FazendaBO fazendaBO = new FazendaBO();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Fazenda> selecionarRs() throws ClassNotFoundException, SQLException {
		return (ArrayList<Fazenda>) fazendaBO.selecionarBo();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response inserirRs(Fazenda fazenda, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
		fazendaBO.inserirBo(fazenda);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(fazenda.getNome());
		return Response.created(builder.build()).build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizarRs(Fazenda fazenda, @PathParam("nome") String nome) throws ClassNotFoundException, SQLException {
		fazendaBO.atualizarBo(fazenda);
		return Response.ok().build();
	}

	@DELETE
	@Path("/{nome}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deletarRs(@PathParam("nome") int idFazenda) throws ClassNotFoundException, SQLException {
		fazendaBO.deletarBo(idFazenda);
		return Response.ok().build();
	}
}