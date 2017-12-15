using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class LabelManager : MonoBehaviour {
    public static LabelManager I;

    // Use this for initialization
    void Awake () {
        if(I != null)
        {
            Debug.LogError("There should only be one LabelManager!");
        }
        I = this;
        Debug.Log("LabelManager initialized");
	}
}
