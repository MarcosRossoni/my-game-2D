package enumeration;

public enum Maps {

    MAP_01(1, "/maps/map01.txt");

    private final int idMap;
    private final String dsPathMap;

    Maps(int idMap, String dsPathMap) {
        this.idMap = idMap;
        this.dsPathMap = dsPathMap;
    }

    public int getIdMap() {
        return idMap;
    }

    public String getDsPathMap() {
        return dsPathMap;
    }
}
