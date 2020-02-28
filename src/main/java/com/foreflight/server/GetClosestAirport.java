package com.foreflight.server;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.foreflight.dao.AirportDAO;
import com.foreflight.model.Airport;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("getClosestAirport/")
public class GetClosestAirport {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClosestAirport(
            @QueryParam("lon") Double lon,
            @QueryParam("lat") Double lat
    ) {
        Airport ap = AirportDAO.getClosestAirport(lon, lat);
        ObjectMapper Obj = new ObjectMapper();

        try {
            if (ap == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            String jsonStr = Obj.writeValueAsString(ap);
            return Response.status(Response.Status.OK).entity(jsonStr).build();
        } catch (JsonProcessingException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response postAirportByID(
            @QueryParam("lon") Double lon,
            @QueryParam("lat") Double lat
    ) {
        return getClosestAirport(lon, lat);
    }
}
