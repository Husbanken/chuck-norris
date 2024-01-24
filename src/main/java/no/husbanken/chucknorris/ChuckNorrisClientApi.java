package no.husbanken.chucknorris;

import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "chuck")
public interface ChuckNorrisClientApi {

    @RequestMapping(method = RequestMethod.GET, value ="/")
    @Headers({"Accept: application/json"})
    Joke getJoke();

}
