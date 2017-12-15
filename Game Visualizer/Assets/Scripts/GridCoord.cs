using UnityEngine;
using System.Collections;

public struct GridCoord
{
    public readonly static GridCoord zero = new GridCoord(0, 0);
    public int x { get; private set; }
    public int y { get; private set; }

    public GridCoord(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public Tile tile
    {
        get
        {
            return BoardManager.GetTile(x, y);
        }

    }
    public Vector2 position
    {
        get
        {
            return tile.transform.position;
        }
    }

    // Operator overloads
    public static GridCoord operator +(GridCoord c1, GridCoord c2)
    {
        return new GridCoord(c1.x + c2.x, c1.y + c2.y);
    }

    public static GridCoord operator -(GridCoord c1, GridCoord c2)
    {
        return new GridCoord(c1.x - c2.x, c1.y - c2.y);
    }
}
