
public class info {
    int idclass;
    String kindclass,nameclass,infoclass;

    public info(int idclass, String kindclass, String nameclass, String infoclass) {
        this.idclass = idclass;
        this.kindclass = kindclass;
        this.nameclass = nameclass;
        this.infoclass = infoclass;
    }

    public int getIdclass() {
        return idclass;
    }

    public String getKindclass() {
        return kindclass;
    }

    public String getNameclass() {
        return nameclass;
    }

    public String getInfoclass() {
        return infoclass;
    }

    public void setIdclass(int idclass) {
        this.idclass = idclass;
    }

    public void setKindclass(String kindclass) {
        this.kindclass = kindclass;
    }

    public void setNameclass(String nameclass) {
        this.nameclass = nameclass;
    }

    public void setInfoclass(String infoclass) {
        this.infoclass = infoclass;
    }
    
    
}
