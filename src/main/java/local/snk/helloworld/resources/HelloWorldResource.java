package local.snk.helloworld.resources;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import local.snk.helloworld.model.Saying;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Optional;

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldResource.class);

    @GET
    @Operation(description = "Says Hello")
    public Saying sayHello(
            @Parameter(description = "Name of person", required = false)
            @QueryParam("name") Optional<String> name) {
        return new Saying(name);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(description = "Accepts properly formatted greetings and says nothing in response.")
    public void receiveHello(
            @Parameter(description = "Formatted greeting", required = true)
            @Valid Saying saying) {
        LOGGER.info("Received a saying: {}", saying);
    }
}
