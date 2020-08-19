# -*- coding:utf-8 -*-
from http.client import HTTPSConnection
from urllib.parse import quote
from xml.etree.ElementTree import fromstring
from pymongo.mongo_client import MongoClient
from datetime import datetime

# https://developers.naver.com/apps/#/myapps/lA5FivJ5MenI3OvwU03a/overview
# 네이버 개발자센터

# https://developers.naver.com/docs/search/news/
# 검색-뉴스

# lA5FivJ5MenI3OvwU03a
# Tra6RYPObW

# https://openapi.naver.com/v1/search/news.xml
huc = HTTPSConnection("openapi.naver.com")

# 인터넷 주소에 한글 - x
# ㅋ -> %2D
# urllib.parse

# URL인코딩
w = quote("코로나")
# 헤더
h = {"X-Naver-Client-Id" : "lA5FivJ5MenI3OvwU03a",
     "X-Naver-Client-Secret" : "Tra6RYPObW" }


huc.request("GET", "/v1/search/news.xml?query=" + w, headers=h)
resBody = huc.getresponse().read()
print(resBody.decode())

def cut(s):
    s = s.replace("&lt;", "").replace("&gt;", "")
    s = s.replace("&quot;", "").replace("<b>", "")
    s = s.replace("</b>", "").replace("&amp;", "")
    return s
###################################
con = MongoClient("192.168.0.88")
db = con.xe
now = datetime.today()
####################################
for n in fromstring(resBody).getiterator("item"):
    nn = {"m" : now.month,
          "d" : now.day,
          "h" : now.hour,
          "t" : cut(n.find("title").text),
          "desc" : cut(n.find("description").text)
          }
    db.naverNews.insert(nn)
print("끝")
con.close()
