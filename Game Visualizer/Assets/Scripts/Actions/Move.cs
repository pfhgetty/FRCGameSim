using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Move : Action
{
    private float duration;
    private GridCoord startPosition, endPosition;
    public Move(GridCoord startPosition, GridCoord endPosition, float startTime, float endTime) : base(startTime, endTime)
    {
        this.duration = endTime - startTime;
        this.startPosition = startPosition;
        this.endPosition = endPosition;
    }

    protected override void Act(float time, Actor actor)
    {
        actor.SetPosition(startPosition);
        actor.transform.position = Vector2.Lerp(startPosition.position, endPosition.position, time / duration);
    }

}
