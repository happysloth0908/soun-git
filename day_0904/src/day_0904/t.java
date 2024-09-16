using UnityEngine;
using UnityEngine.UI;
using System.Collections.Generic;

public class VisualNovelManager : MonoBehaviour
{
    public Text dialogueText;
    public Text characterNameText;
    public Image backgroundImage;
    public Image characterImage;

    private List<string> dialogue;
    private List<string> characters;
    private List<string> backgrounds;
    private int currentIndex;

    void Start()
    {
        dialogue = new List<string>
        {
            "안녕하세요. 저희 학교에 오신 것을 환영합니다.",
            "저는 당신의 담임 선생님입니다.",
            "앞으로 잘 지내봐요!"
        };

        characters = new List<string>
        {
            "선생님",
            "선생님",
            "선생님"
        };

        backgrounds = new List<string>
        {
            "교실",
            "교실",
            "교실"
        };

        currentIndex = 0;
        UpdateScene();
    }

    void Update()
    {
        if (Input.GetMouseButtonDown(0))
        {
            NextDialogue();
        }
    }

    void NextDialogue()
    {
        currentIndex++;
        if (currentIndex < dialogue.Count)
        {
            UpdateScene();
        }
        else
        {
            Debug.Log("게임 종료");
            // 여기에 게임 종료 로직 추가
        }
    }

    void UpdateScene()
    {
        dialogueText.text = dialogue[currentIndex];
        characterNameText.text = characters[currentIndex];
        // 배경과 캐릭터 이미지 업데이트 로직 추가 필요
    }
}