package stubailey18.stuflix.programs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ProgramService {

    private RestTemplate restTemplate;

    @Value("${apiUrl}")
    private String apiUrl;

    @Value("${apiKey}")
    private String apiKey;

    public ProgramService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Program> findProgramsByTitle(String partialTitle) {
        var response = restTemplate.getForEntity(
                String.format("%s?apiKey=%s&s=%s", apiUrl, apiKey, partialTitle), ProgramWrapper.class);
        var programWrapper = response.getBody();
        return (programWrapper != null) ? programWrapper.getPrograms() : List.of();
    }

    public ProgramDetail getProgramDetailByImdbId(String imdbId) {
        var response = restTemplate.getForEntity(
                String.format("%s?apiKey=%s&i=%s", apiUrl, apiKey, imdbId), ProgramDetail.class);
        return response.getBody();
    }
}
