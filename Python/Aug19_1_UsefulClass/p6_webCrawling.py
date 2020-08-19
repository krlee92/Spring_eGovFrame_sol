# -*- coding:utf-8 -*-
from urllib.parse import quote
from http.client import HTTPSConnection
from getNaverNews import resBody
from bs4 import BeautifulSoup


# 웹사이트 소스
w = quote("천창원")
huc = HTTPSConnection("book.naver.com")
huc.request("GET", "/search/search.nhn?sm=sta_hty.book&sug=&where=nexearch&query=" + w)
resBody = huc.getresponse().read()
print(resBody.decode())
#############################################
# HTML 파싱
#    Java : jsoup.jar 
#    Python : bs4.py(BeautifulSoup)

#    cmd
#        pip3 install bs4
#                                내장된HTML파서이름
naverBook = BeautifulSoup(resBody, "html.parser",
                           from_encoding="utf-8")
# naverBook.select("CSS선택자")
books = naverBook.select("#searchBiblioList li")
for b in books:
    print(b.select("dl a")[0].text) # 제목
    print(b.select("dl a")[1].text) # 저자
    print(b.select("dd")[2].text.strip()) # desc strip() 문자열 앞뒤공백 없애기
    print("------")