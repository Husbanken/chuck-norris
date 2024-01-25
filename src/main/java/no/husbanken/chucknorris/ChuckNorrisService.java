package no.husbanken.chucknorris;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
@Service
public class ChuckNorrisService {


    private static final List<Joke> JOKES = List.of(
            new Joke(1, "When Chuck Norris throws exceptions, it’s across the room."),
            new Joke(2, "All arrays Chuck Norris declares are of infinite size, because Chuck Norris knows no bounds."),
            new Joke(3, "Chuck Norris doesn’t have disk latency because the hard drive knows to hurry the hell up."),
            new Joke(4, "Chuck Norris writes code that optimizes itself."),
            new Joke(5, "Chuck Norris can’t test for equality because he has no equal."),
            new Joke(6, "Chuck Norris doesn’t need garbage collection because he doesn’t call .Dispose(), he calls .DropKick()."),
            new Joke(7, "Chuck Norris’s first program was kill -9."),
            new Joke(8, "Chuck Norris burst the dot com bubble."),
            new Joke(9, "All browsers support the hex definitions #chuck and #norris for the colors black and blue."),
            new Joke(10, "MySpace actually isn’t your space, it’s Chuck’s (he just lets you use it)."),
            new Joke(11, "Chuck Norris can write infinite recursion functions…and have them return."),
            new Joke(12, "Chuck Norris can solve the Towers of Hanoi in one move."),
            new Joke(13, "The only pattern Chuck Norris knows is God Object."),
            new Joke(14, "Chuck Norris finished World of Warcraft."),
            new Joke(15, "Project managers never ask Chuck Norris for estimations…ever."),
            new Joke(16, "Chuck Norris doesn’t use web standards as the web will conform to him."),
            new Joke(17, "'It works on my machine' always holds true for Chuck Norris."),
            new Joke(18, "Whiteboards are white because Chuck Norris scared them that way."),
            new Joke(19, "Chuck Norris doesn’t do Burn Down charts, he does Smack Down charts."),
            new Joke(20, "Chuck Norris can delete the Recycling Bin."),
            new Joke(21, "Chuck Norris’s beard can type 140 wpm."),
            new Joke(22, "Chuck Norris can unit test entire applications with a single assert."),
            new Joke(23, "Chuck Norris doesn’t bug hunt as that signifies a probability of failure, he goes bug killing."),
            new Joke(24, "Chuck Norris’s keyboard doesn’t have a Ctrl key because nothing controls Chuck Norris."),
            new Joke(25, "When Chuck Norris is web surfing websites get the message “Warning: Internet Explorer has deemed this user to be malicious or dangerous. Proceed?”.")
    );

    private final ChuckProperties chuckProperties;

    private final static ObjectMapper objectMapper = new ObjectMapper();

    public Joke getRandomChuckNorrisJoke() {
        List<Joke> listOfJokes = JOKES;

        if (chuckProperties.getJokeLocation() != null) {
            File file = new File(chuckProperties.getJokeLocation());

            if (file.exists()) {
                try {
                    listOfJokes = objectMapper.readValue(file, new TypeReference<>() {
                    });
                } catch (IOException e) {
                    throw new RuntimeException("Failed to parse json", e);
                }

            } else {
                throw new RuntimeException("File with jokes does not exist!");
            }
        }

        Random r = new Random();
        return listOfJokes.get(r.nextInt(listOfJokes.size()));
    }
}
