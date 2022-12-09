package FRQs.Arraylists;

public class MemberInfo {

    String name;
    int gradYear;
    boolean hasGoodStanding;

    public MemberInfo(String name, int gradYear, boolean hasGoodStanding) {
        this.name = name;
        this.gradYear = gradYear;
        this.hasGoodStanding = hasGoodStanding;
    }

    public int getGradYear() {
        return gradYear;
    }

    public boolean inGoodStanding() {
        if (hasGoodStanding){
            return true;
        }
        return false;
    }

}
