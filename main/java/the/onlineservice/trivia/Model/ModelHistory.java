package the.onlineservice.trivia.Model;

public class ModelHistory {
    String gameNo,ID,gameDate,userName,a1,a2;

    public ModelHistory() {
    }

    public ModelHistory(String gameNo, String ID, String gameDate, String userName, String a1, String a2) {
        this.gameNo = gameNo;
        this.ID = ID;
        this.gameDate = gameDate;
        this.userName = userName;
        this.a1 = a1;
        this.a2 = a2;
    }

    public String getGameNo() {
        return gameNo;
    }

    public void setGameNo(String gameNo) {
        this.gameNo = gameNo;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getGameDate() {
        return gameDate;
    }

    public void setGameDate(String gameDate) {
        this.gameDate = gameDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getA1() {
        return a1;
    }

    public void setA1(String a1) {
        this.a1 = a1;
    }

    public String getA2() {
        return a2;
    }

    public void setA2(String a2) {
        this.a2 = a2;
    }
}
