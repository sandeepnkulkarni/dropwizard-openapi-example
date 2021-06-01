package local.snk.helloworld;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;
import io.swagger.v3.oas.integration.SwaggerConfiguration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import local.snk.helloworld.health.NoopHealthCheck;
import local.snk.helloworld.resources.HelloWorldResource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HelloWorldApplication extends Application<HelloWorldConfiguration> {

    public static void main(final String[] args) throws Exception {
        new HelloWorldApplication().run(args);
    }

    @Override
    public String getName() {
        return "Hello World";
    }

    @Override
    public void initialize(final Bootstrap<HelloWorldConfiguration> bootstrap) {
        // Swagger UI
        bootstrap.addBundle(new AssetsBundle("/app", "/", "index.html", "static"));
    }

    @Override
    public void run(final HelloWorldConfiguration configuration,
                    final Environment environment) {
        environment.healthChecks().register("noop-healthcheck", new NoopHealthCheck());
        environment.jersey().register(new OpenApiResource().openApiConfiguration(getOpenApiConfiguration()));
        environment.jersey().register(new HelloWorldResource());
    }

    private SwaggerConfiguration getOpenApiConfiguration() {
        final OpenAPI oas = new OpenAPI();
        final Info info = new Info()
                .title("Hello World API")
                .description("RESTful greetings for you.")
                .contact(new Contact().email("sandeepnkulkarni@gmail.com"));
        oas.info(info);
        final List<Server> servers = Stream.of(new Server().url("/api")).collect(Collectors.toList());
        oas.servers(servers);

        return new SwaggerConfiguration()
                .openAPI(oas)
                .prettyPrint(true)
                .resourcePackages(Stream.of("local.snk.helloworld").collect(Collectors.toSet()));
    }

}
