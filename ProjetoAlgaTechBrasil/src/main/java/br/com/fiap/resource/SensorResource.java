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

import br.com.fiap.beans.Sensor;
import br.com.fiap.bo.SensorBO;

@Path("/sensor")
public class SensorResource {

	private SensorBO sensorBO = new SensorBO();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Sensor> selecionarRs() throws ClassNotFoundException, SQLException {
		return (ArrayList<Sensor>) sensorBO.selecionarBo();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response inserirRs(Sensor sensor, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
		sensorBO.inserirBo(sensor);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(sensor.getTipo());
		return Response.created(builder.build()).build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizarRs(Sensor sensor, @PathParam("tipo") String tipo)
			throws ClassNotFoundException, SQLException {
		sensorBO.atualizarBo(sensor);
		return Response.ok().build();
	}

	@DELETE
	@Path("/{tipo}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deletarRs(@PathParam("tipo") int idSensor) throws ClassNotFoundException, SQLException {
		sensorBO.deletarBo(idSensor);
		return Response.ok().build();
	}
}