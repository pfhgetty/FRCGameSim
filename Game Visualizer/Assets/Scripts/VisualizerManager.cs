using UnityEngine;
using System.Collections;
using UnityEngine.UI;

public class VisualizerManager : MonoBehaviour
{
    [Header("Colors")]
    [SerializeField]
    private Color redAllianceColor;
    [SerializeField] private Color blueAllianceColor;
    [SerializeField] private Color greenAllianceColor;
    [SerializeField] private Slider progressBar;
    private Robot[] blue;
    private Robot[] red;

    public static float SimulationTime { get; private set; }
    private bool isPlaying = true;

    public static VisualizerManager I { get; private set; }

    private void Awake()
    {
        if (VisualizerManager.I != null)
        {
            Debug.LogError("There should only be one Visualizer Manager!");
        }
        VisualizerManager.I = this;
    }

    void Start()
    {
        blue = new Robot[3];
        red = new Robot[3];
        for (int i = 0; i < 3; i++)
        {
            blue[i] = BoardManager.AddRobot(new RobotID(RobotID.Alliance.BLUE, Random.Range(1, 9999), i + 1), 0, i * 2);
            red[i] = BoardManager.AddRobot(new RobotID(RobotID.Alliance.RED, Random.Range(1, 9999), i + 1), 8, i * 2);
        }

        AddActions();
    }

    private void AddActions()
    {
        blue[0].AddAction(new Move(GridCoord.zero, GridCoord.zero, 0, 1));
        blue[0].AddAction(new Move(GridCoord.zero, new GridCoord(5, 5), 1, 5));
        blue[0].AddAction(new Move(new GridCoord(5, 5), new GridCoord(5, 6), 5, 7));
        blue[0].AddAction(new Move(new GridCoord(5, 6), new GridCoord(5, 6), 7, 8));

        red[1].AddAction(new Move(new GridCoord(8, 2), new GridCoord(8, 2), 0, 2));
        red[1].AddAction(new Move(new GridCoord(8, 2), new GridCoord(10, 3), 2, 5));
        red[1].AddAction(new Move(new GridCoord(10, 3), new GridCoord(5, 2), 5, 8));

        red[2].AddAction(new Move(new GridCoord(8, 4), new GridCoord(8, 4), 0, 1.5f));
        red[2].AddAction(new Move(new GridCoord(8, 4), new GridCoord(6, 3), 1.5f, 3.5f));
        red[2].AddAction(new Move(new GridCoord(6, 3), new GridCoord(3, 4), 3.5f, 7f));
        red[2].AddAction(new Move(new GridCoord(3, 4), new GridCoord(4, 4), 7f, 8f));
        progressBar.maxValue = 8f;

    }

    private void Update()
    {
        if (isPlaying)
        {
            if (SimulationTime <= progressBar.maxValue)
            {
                SimulationTime += Time.deltaTime;
            }
            else
            {
                SimulationTime = progressBar.maxValue;
            }

            progressBar.value = SimulationTime;
        }
        isPlaying = true;
    }

    public void SetTime()
    {
        SimulationTime = progressBar.value;
        isPlaying = false;
    }

    public void Play(bool play)
    {
        isPlaying = play;
    }

    public static Color GetBlueAllianceColor()
    {
        return VisualizerManager.I.blueAllianceColor;
    }

    public static Color GetRedAllianceColor()
    {
        return VisualizerManager.I.redAllianceColor;
    }
    public static Color GetGreenAllianceColor()
    {
        return VisualizerManager.I.greenAllianceColor;
    }
}
