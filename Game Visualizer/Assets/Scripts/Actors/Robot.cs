using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Robot : Actor
{
    private RobotID id; // Robot information
    [SerializeField] private TextDisplay display; // For displaying text on robot

    private void Start()
    {
        this.VisualAttributes();
    }

    protected override void Process()
    {
        display.SetPosition(this.transform.position);        
    }

    private void VisualAttributes()
    {
        // Display robot name
        display.SetText(this.ToString());

        // Color the robot
        Color color = new Color();
        switch (this.id.alliance)
        {
            case RobotID.Alliance.BLUE:
                color = VisualizerManager.GetBlueAllianceColor();
                break;
            case RobotID.Alliance.RED:
                color = VisualizerManager.GetRedAllianceColor();
                break;
            default:
                color = VisualizerManager.GetGreenAllianceColor();
                break;
        }
        
        this.GetComponent<SpriteRenderer>().color = color;
    }   

    public void SetRobotID(RobotID botID)
    {
        this.id = botID;
        this.gameObject.name = this.ToString();
    }

    public override string ToString()
    {
        return id.alliance.ToString() + " " + id.botNumber;
    }
}
