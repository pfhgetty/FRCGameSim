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
    public Alliance alliance { get; private set; }
    public int teamNumber { get; private set; }
    public int botNumber { get; private set; }


}
