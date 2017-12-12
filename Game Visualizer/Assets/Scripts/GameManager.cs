using UnityEngine;
using System.Collections;

public class GameManager : MonoBehaviour
{

    // Use this for initialization
    private Robot[] blue;
    private Robot[] red;
    void Start()
    {
        blue = new Robot[3];
        red = new Robot[3];
        for (int i = 0; i < 3; i++)
        {
            blue[i] = BoardManager.AddRobot(new RobotID(RobotID.Alliance.BLUE, Random.Range(1, 9999), i + 1), 0, i * 2);
            red[i] = BoardManager.AddRobot(new RobotID(RobotID.Alliance.RED, Random.Range(1, 9999), i + 1), 8, i * 2);
        }

        StartCoroutine(TestStuff());
    }

    private IEnumerator TestStuff()
    {
        blue[0].Move(2f/3f, 90f);
        yield return new WaitForSeconds(1.0f);
        red[2].Move(1f, 0f);
        yield return new WaitForSeconds(.5f);
        blue[0].Stop();
        blue[0].SetPosition(0, 1);
        yield return new WaitForSeconds(.25f);
        yield return new WaitForSeconds(1.0f);
        yield return new WaitForSeconds(.8f);
    }
}
