package no.husbanken.chucknorris;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Joke {

    private int id;
    private String joke;

    public Joke(int id, String joke) {
        this.id = id;
        this.joke = joke;
    }
}
