using UnityEngine;
using System.Collections;

public struct RobotID
{
    public RobotID(Alliance alliance, int teamNumber, int botNumber)
    {
        this.alliance = alliance;
        this.teamNumber = teamNumber;
        this.botNumber = botNumber;
    }

    public enum Alliance { RED, BLUE, GREEN };
    public Alliance alliance;
    public int teamNumber;
    public int botNumber;


}
