package Person;
import java.util.List;

public class Dignitary {
    private String name;
    private List<String> knownFor;
    private List<Award> awards;

    public Dignitary(String name, List<String> knownFor, List<Award> awards) {
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
    public String getPerson() {
        StringBuilder person = new StringBuilder();
        person.append(name).append("\n Known For: \n");
        for (String achievement : knownFor) {
            person.append(achievement).append("\n");
        }
        person.append("Awards: \n");
        for(Award award : awards) {
            person.append(award.toString()).append("\n");
        }
        return person.toString();
    }
}
