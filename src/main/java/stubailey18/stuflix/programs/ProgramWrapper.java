package stubailey18.stuflix.programs;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ProgramWrapper {

    @JsonProperty("Search")
    private List<Program> programs;

    public ProgramWrapper() {}

    public List<Program> getPrograms() {
        return programs;
    }

    public void setPrograms(List<Program> programs) {
        this.programs = programs;
    }
}
