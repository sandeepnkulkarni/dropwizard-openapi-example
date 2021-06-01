package local.snk.helloworld.resources;

import com.google.common.base.Optional;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import local.snk.helloworld.model.Saying;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

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
    @Operation(description = "Accepts properly formatted greetings and says nothing in response.")
    public void receiveHello(
            @Parameter(description = "Formatted greeeting", required = true)
            @Valid Saying saying) {
        LOGGER.info("Received a saying: {}", saying);
    }
}
