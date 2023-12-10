public abstract class SystemeDeFichier {
    protected String name;
    protected String accessRights;

    public SystemeDeFichier(String name, String accessRights) {
        this.name = name;
        this.accessRights = accessRights;
    }

    public abstract void delete();

    public abstract void rename(String newName);
}