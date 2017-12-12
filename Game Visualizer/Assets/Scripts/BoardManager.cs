using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class BoardManager : MonoBehaviour
{
    // Static singleton reference
    private static BoardManager I;
    [Header("Board Properties")]
    [SerializeField] private int BOARD_WIDTH;
    [SerializeField] private int BOARD_HEIGHT;
    [SerializeField] private float TILE_SIZE = 1f;

    [Header("Prefabs")]
    [SerializeField] private GameObject tilePrefab;
    [SerializeField] private Robot robotPrefab;
    private Tile[,] board;
   
    // Use this for initialization
    void Awake()
    {
        // Only one instance of Board Manager should exist. If more than one exists, throw error.
        if (BoardManager.I != null)
        {
            Debug.LogError("No more than one instance of Board Manager should exist!");
        }
        BoardManager.I = this;

        // Check that tile prefab does, in fact, have a tile script
        if (!tilePrefab.GetComponent<Tile>())
        {
            Debug.LogError("Tile Prefab does not have tile script attached");
        }

        // Create board
        board = new Tile[BOARD_WIDTH, BOARD_HEIGHT];
        for (int i = 0; i < board.GetLength(0); i++)
        {
            for (int j = 0; j < board.GetLength(1); j++)
            {
                Vector3 tilePosition = transform.position + new Vector3(i * TILE_SIZE, j * TILE_SIZE);
                GameObject tile = Instantiate(tilePrefab, tilePosition, transform.rotation);
                tile.transform.parent = I.transform;
                tile.name = "Tile (" + i + ", " + j + ")";
                board[i, j] = tile.GetComponent<Tile>();
            }
        }
    }

    public static Tile GetTile(int x, int y)
    {
        return I.board[x, y];
    }

    public static Robot AddRobot(RobotID id, int x, int y)
    {
        Robot robot = Instantiate(I.robotPrefab, BoardManager.GetTile(x, y).transform);
        robot.SetRobotID(id);
        return robot;
    }

}
