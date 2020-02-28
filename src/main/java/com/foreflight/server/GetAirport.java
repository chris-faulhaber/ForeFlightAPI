package com.foreflight.server;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.foreflight.dao.AirportDAO;
import com.foreflight.model.Airport;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("getAirport/")
public class GetAirport {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAirportByID(@QueryParam("id") List<String> ids) {
        ObjectMapper Obj = new ObjectMapper();
        try {
            if (ids.size() == 1) {
                Airport ap = AirportDAO.getAirportByID(ids.get(0));

                if (ap == null) {
                    return Response.status(Response.Status.NOT_FOUND).build();
                }
                String jsonStr = Obj.writeValueAsString(ap);
                return Response.status(Response.Status.OK).entity(jsonStr).build();
            } else {
                List<Airport> airports = AirportDAO.getAirportsByIDs(ids);
                String jsonStr = Obj.writeValueAsString(airports);

                return Response.status(Response.Status.OK).entity(jsonStr).build();
            }
        } catch (JsonProcessingException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response postAirportByID(@QueryParam("id") List<String> ids) {
        return getAirportByID(ids);
    }
}
