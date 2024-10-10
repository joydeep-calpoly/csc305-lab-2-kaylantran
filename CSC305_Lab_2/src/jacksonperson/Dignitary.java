package jacksonperson;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Dignitary {
    private final String name;
    private final List<String> knownFor;
    private final List<Award> awards;

    public Dignitary(
        @JsonProperty("name") String name,
        @JsonProperty("knownFor") List<String> knownFor,
        @JsonProperty("awards") List<Award> awards) {
            this.name = name;
            this.knownFor = knownFor;
            this.awards = awards;
    }

    public String getName() {
        return name;
    }

    public List<String> getKnownFor() {
        return knownFor;
    }

    public List<Award> getAwards() {
        return awards;
    }

    @Override
    public String toString() {
        StringBuilder person = new StringBuilder();
        person.append(name).append("\nKnown For: \n");
        for(String achievement : knownFor) {
            person.append("- ").append(achievement).append("\n");
        }
        person.append("Awards: \n");
        for(Award award : awards) {
            person.append("- ").append(award.toString()).append("\n");
        }
        return person.toString();
    }
}
