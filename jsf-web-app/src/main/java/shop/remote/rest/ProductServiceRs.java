package shop.remote.rest;

import shop.product.Product;

import javax.ejb.Local;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Local
@Path("/products")
public interface ProductServiceRs {
    @PUT
    @Path("/new")
    @Consumes(MediaType.APPLICATION_JSON)
    void insert(Product product) throws Exception;

    @POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    void update(Product product) throws Exception;

    @DELETE
    @Path("/{id}/id")
    void delete(@PathParam("id") long id) throws Exception;

    @GET
    @Path("/{id}/id")
    @Produces(MediaType.APPLICATION_JSON)
    Product findById(@PathParam("id") long id) throws Exception;

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    List<Product> findAll() throws Exception;
}
