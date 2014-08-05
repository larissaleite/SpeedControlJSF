package br.com.speedcontrol.webservice;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.speedcontrol.model.SpeedRadar;
import br.com.speedcontrol.service.IRadarService;
import br.com.speedcontrol.service.RadarService;
 
@Path("/graphics")
public class JerseyWebService {
	
	@GET
	@Path("/speedPerDay") //ajeitar pra ser um metodo generico que recebe o tipo do grafico e redireciona pra o metodo q retorna os dados especificos pra o determinado grafico
	@Produces(MediaType.APPLICATION_JSON)
	public List<SpeedRadar> getData() {
		IRadarService service = new RadarService();
		return service.retrieveSpeeds();
	}
	
	@GET
	@Path("/speed")
	@Produces(MediaType.APPLICATION_JSON)
	public SpeedRadar getSpeed() {
		IRadarService service = new RadarService();
		return service.getSpeedRealTime();
	}

	@GET
	@Path("/speedTag/{param}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<SpeedRadar> getSpeedsTags(@PathParam("param") String param) {
		System.out.println("parametro "+param);
		IRadarService service = new RadarService();
		if (param.equals("fined"))
			return service.getFinedSpeeds();
		else
			return service.getNotFinedSpeeds();
	}
}
