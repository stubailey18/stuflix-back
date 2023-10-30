package stubailey18.stuflix.programs;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/programs")
@CrossOrigin
public class ProgramController {

    private ProgramService service;

    public ProgramController(ProgramService service) {
        this.service = service;
    }

    @GetMapping(params = "title")
    public List<Program> findProgramsByTitle(String title) {
        return service.findProgramsByTitle(title);
    }

    @GetMapping(params = "imdbId")
    public ProgramDetail getProgramDetailByImdbId(String imdbId) {
        return service.getProgramDetailByImdbId(imdbId);
    }
}
