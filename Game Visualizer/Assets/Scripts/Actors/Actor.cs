using UnityEngine;
using System.Collections.Generic;

public abstract class Actor : MonoBehaviour
{
    // Update is called once per frame
    private void Update()
    {
        
        // Overridable for custom behaviour of children
        this.Process();
    }

    /// <summary>
    /// Called once every frame. Basically a psuedo-update loop
    /// </summary>
    abstract protected void Process();

    public void SetPosition(int x, int y)
    {
        this.transform.parent = BoardManager.GetTile(x, y).transform;
        this.transform.localPosition = Vector3.zero;
    }

    public void SetPosition(GridCoord position)
    {
        this.SetPosition(position.x, position.y);
    }
}
