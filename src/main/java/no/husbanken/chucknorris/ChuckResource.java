package no.husbanken.chucknorris;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ChuckResource {

    private final ChuckProperties chuckProperties;
    private final ChuckNorrisService chuckNorrisService;
    private final ChuckNorrisClientApi chuckNorrisClientApi;

    @GetMapping("/")
    public Joke joke() {

        if (chuckProperties.isForwardRequest()) {
            return chuckNorrisClientApi.getJoke();
        } else {
            return chuckNorrisService.getRandomChuckNorrisJoke();
        }

    }


}
