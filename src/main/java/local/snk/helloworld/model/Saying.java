package local.snk.helloworld.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Optional;

import static java.lang.String.format;

public class Saying {
    @JsonProperty("saying")
    public final String saying;

    public Saying() {
        saying = "";
    }

    public Saying(Optional<String> name) {
        final String who = name.isPresent() ? name.get() : "World";
        saying = format("Hello, %s!", who);
    }

    @Override
    public String toString() {
        return "Saying{" +
                "saying='" + saying + '\'' +
                '}';
    }
}
