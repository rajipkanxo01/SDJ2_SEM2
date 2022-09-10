package soccerMatch;

public class StartSoccerMatch {
    public static void main(String[] args) {
        SoccerMatch soccerMatch = new SoccerMatch();
        DreamTeamFan dreamTeamFan = new DreamTeamFan(soccerMatch);
        OldBoysFan oldBoysFan = new OldBoysFan(soccerMatch);
        Refree refree = new Refree(soccerMatch);
        AngryCoach angryCoach = new AngryCoach(soccerMatch);
        Medic medic = new Medic(soccerMatch);
        soccerMatch.startMatch();
    }
}
