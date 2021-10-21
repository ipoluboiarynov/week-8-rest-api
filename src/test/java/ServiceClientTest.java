import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.swapi.Planet;
import org.junit.jupiter.api.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import static org.junit.jupiter.api.Assertions.*;

class ServiceClientTest {

    @Test
    public void testswapiJSON() throws JsonProcessingException {
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("https://swapi.dev/api/planets/1");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        ObjectMapper mapper = new ObjectMapper();
        Planet planet = mapper.readValue(response, Planet.class);
        String expectedPlanetName = "Tatooine";
        assertEquals(expectedPlanetName, planet.getName());
    }
}
