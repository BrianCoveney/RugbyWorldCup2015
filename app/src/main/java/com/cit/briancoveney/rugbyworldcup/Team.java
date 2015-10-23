package com.cit.briancoveney.rugbyworldcup;

/**
 * Created by briancoveney on 10/22/15.
 */
public enum Team {
    IRE("ire", 1),
    SCT("sct", 2),
    AUS("aus", 3),
    NZL("nzl", 4),
    WAL("wal", 5),
    RSA("rsa", 6),
    ARG("arg", 7),
    FRA("fra", 8),
    SAM("sam", 9),
    ENG("eng", 10),
    ITA("ita", 11),
    JPN("jpn", 12),
    ROM("rom", 13),
    CAN("can", 14),
    FIJ("fij", 15),
    URG("urg", 16);

    private String teamName;
    private int teamColor;

    private Team(String teamName, int teamColor)
    {
        this.teamName = teamName;
        this.teamColor = teamColor;
    }

    public String getTeamName()
    {
        return teamName;
    }
}
