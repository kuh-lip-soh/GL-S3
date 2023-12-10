import java.util.ArrayList;
import java.util.List;

public class Repertoire extends SystemeDeFichier {
    private List<SystemeDeFichier> contents;

    public Repertoire(String name, String accessRights) {
        super(name, accessRights);
        this.contents = new ArrayList<>();
    }

    public void delete() {
    }

    public void rename(String newName) {
    }
}