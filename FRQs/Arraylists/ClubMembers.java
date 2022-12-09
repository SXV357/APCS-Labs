package FRQs.Arraylists;

import java.util.ArrayList;

public class ClubMembers {
    private ArrayList<MemberInfo> memberList;

    public void addMembers(String[] names, int gradYear) {
        // only name varies and not gradYear/status of standing
        for (int i = 0; i < names.length; i++) {
            memberList.add(new MemberInfo(names[i], gradYear, true));
        }
    }

    public ArrayList<MemberInfo> removeMembers(int year) {
        ArrayList<MemberInfo> removed = new ArrayList<MemberInfo>();
        for (int i = 0; i < memberList.size(); i++) {
            if (memberList.get(i).getGradYear() <= year) {
                if (memberList.get(i).inGoodStanding()) {
                    removed.add(memberList.get(i));
                }
                memberList.remove(i);
                i++;
            }

        }
        return removed;
    }
}
