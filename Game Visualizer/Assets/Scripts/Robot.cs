using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Robot : MonoBehaviour
{
    private float speed;
    private RobotID id;

    private TextDisplay display;
    // Update is called once per frame
    void Update()
    {
        this.transform.position += transform.right * (speed * Time.deltaTime);
    }

    public void Move(float speed, float angle)
    {
        this.speed = speed;
        transform.rotation = Quaternion.Euler(0, 0, angle);
    }

    public void Stop()
    {
        this.speed = 0f;
    }

    public void SetPosition(int x, int y)
    {
        transform.parent = BoardManager.GetTile(x, y).transform;
        transform.localPosition = Vector3.zero;
    }

    public void SetRobotID(RobotID botID)
    {
        this.id = botID;
        this.gameObject.name = botID.alliance.ToString() + " " + botID.botNumber;
    }
}
