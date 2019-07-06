package avaj.launcher.Aircraft;

public class Aircraft {

    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCount = 1L;

    protected Aircraft(String name, Coordinates coordinates){

        this.name = name;
        this.id = nextId();
        this.coordinates = coordinates;
    }

    public Coordinates getCoordinates() {return this.coordinates;}

    private long nextId()
    {return (Aircraft.idCount)++;}

}
