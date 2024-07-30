
# # -*- coding: utf-8 -*-

import sys
# def func(a):
#     return (a)
#
#
# if __name__ == '__main__':
#     a = []
#     for i in range(1, len(sys.argv)):
#         a.append((int(sys.argv[i])))
#
#     print(func(a[0]))
from deepface import DeepFace
def add(url):
    global emotion_dict
    img_path = url
    objs = DeepFace.analyze(
        img_path=img_path,
        actions=['emotion'],
        detector_backend='opencv',
        enforce_detection=False
    )
    if isinstance(objs, list):
        objs = objs[0]
    if 'emotion' in objs:
        emotions = objs['emotion']
        dominant_emotion = max(emotions, key=emotions.get)
        emotion_dict = {
            "maxEmotion": dominant_emotion,
            "angry": "{:.2f}".format(emotions.get('angry', 0)),
            "disgust": "{:.2f}".format(emotions.get('disgust', 0)),
            "fear": "{:.2f}".format(emotions.get('fear', 0)),
            "happy": "{:.2f}".format(emotions.get('happy', 0)),
            "sad": "{:.2f}".format(emotions.get('sad', 0)),
            "surprise": "{:.2f}".format(emotions.get('surprise', 0)),
            "neutral": "{:.2f}".format(emotions.get('neutral', 0))
        }
    return emotion_dict

def haha(q):
    return q

if __name__ == '__main__':
    # a = []
    # for i in range(1, len(sys.argv)):
    #     a.append((int(sys.argv[i])))
    # print(add(a[0]))
    if len(sys.argv) < 2:
        print("Usage: python pp.py <url>")
    else:
        url = sys.argv[1]
        result = add(url)
        print(result)
    #print(add("https://636c-cloud1-9guju9ls5a0e3266-1322543279.tcb.qcloud.la/tmp/face_emotion.png"))