using UnityEngine;
using System.Collections.Generic;

public abstract class Actor : MonoBehaviour
{
    private List<Action> actions;

    private void Awake()
    {
        actions = new List<Action>();
    }

    // Update is called once per frame
    private void Update()
    {
        List<Action> currentActions = this.GetCurrentActions(VisualizerManager.SimulationTime);
        foreach(Action action in currentActions){
            action.Do(VisualizerManager.SimulationTime, this);
        }

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

    public void AddAction(Action action)
    {
        this.actions.Add(action);
    }

    public void AddAction(List<Action> actionsToAdd)
    {
        foreach(Action action in actionsToAdd)
        {
            this.AddAction(action);
        }
    }

    public void AddAction(Action[] actionsToAdd)
    {
        foreach (Action action in actionsToAdd)
        {
            this.AddAction(action);
        }
    }

    private List<Action> GetCurrentActions(float curTime)
    {
        List<Action> curActions = new List<Action>();
        for(int i = 0; i < actions.Count; i++)
        {
            Action action = actions[i];
            if(action.startTime <= curTime && action.endTime >= curTime)
            {
                curActions.Add(action);
            }
        }

        return curActions;
      
    }

}
