using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class TextDisplay : MonoBehaviour {
    private Text text;

    private void Awake()
    {
        this.text = GetComponent<Text>();
        this.text.rectTransform.SetParent(LabelManager.I.transform);
    }

    public void SetPosition(Vector3 position)
    {
        text.rectTransform.position = position;
    }

    public void SetText(string text)
    {
        this.text.text = text;
    }
}
