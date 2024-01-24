package no.husbanken.chucknorris;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "chuck")
public class ChuckProperties {

    private boolean forwardRequest;
    private String jokeLocation;

}
