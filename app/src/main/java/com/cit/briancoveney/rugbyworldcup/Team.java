package com.cit.briancoveney.rugbyworldcup;

/**
 * Created by briancoveney on 10/22/15.
 */
public enum Team {
    IRELAND("ire", 1),
    SCOTLAND("sct", 2),
    AUSTRALIA("aus", 3),
    NEW_ZEALAND("nzl", 4),
    WALES("wal", 5),
    SOUTH_AFRICA("rsa", 6),
    ARGENTINA("arg", 7),
    FRANCE("fra", 8),
    SAMOA("sam", 9),
    ENGLAND("eng", 10),
    ITALY("ita", 11),
    JAPAN("jpn", 12),
    ROMANIA("rom", 13),
    CANADA("can", 14),
    FIJI("fij", 15),
    URUGUAY("urg", 16)
    ;

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
