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

import br.com.fiap.beans.Qualidade;
import br.com.fiap.bo.QualidadeBO;

@Path("/qualidade")
public class QualidadeResource {

	private QualidadeBO qualidadeBO = new QualidadeBO();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Qualidade> selecionarRs() throws ClassNotFoundException, SQLException {
		return (ArrayList<Qualidade>) qualidadeBO.selecionarBo();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response inserirRs(Qualidade qualidade, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
		qualidadeBO.inserirBo(qualidade);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(qualidade.getIdFazenda()));
		return Response.created(builder.build()).build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizarRs(Qualidade qualidade, @PathParam("idFazenda") int idFazenda) throws ClassNotFoundException, SQLException {
		qualidadeBO.atualizarBo(qualidade);
		return Response.ok().build();
	}

	@DELETE
	@Path("/{idFazenda}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deletarRs(@PathParam("idFazenda") int idFazenda) throws ClassNotFoundException, SQLException {
		qualidadeBO.deletarBo(idFazenda);
		return Response.ok().build();
	}
}