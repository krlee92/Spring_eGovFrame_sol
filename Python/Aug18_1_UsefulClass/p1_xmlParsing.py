# -*- coding:utf-8 -*-
from http.client import HTTPConnection
from xml.etree.ElementTree import fromstring

# HTTP 통신
# http://openapi.seoul.go.kr:8088/4f6a6547456b6368333355736a714f/xml/Corona19Status/1/5/
# 프로토콜://주소:포트번호(80생략가능)/폴더명/폴더명/.../파일명?파라메터명=값&


# 연결(http통신 or https통신)
# huc = HTTPConnection("포트번호까지만") # HTTPSConnection()
huc = HTTPConnection("openapi.seoul.go.kr:8088")

# csv
#    comma separated value
#    MS Excel이 이쁘게 열어는 줌
# MS Eecel이 utf-8인코딩을 못알아봄 -> 한글 깨짐
f = open("D:\\lee/python/corona19.csv", "w", encoding="utf-8")
for n in range(1, 2002, 1000):
    print(n, n+999)
    # 요청
    # huc.request("GET", "폴더명~파라메터까지 다")
    huc.request("GET", "/4f6a6547456b6368333355736a714f/xml/Corona19Status/%d/%d/" %(n, n+999))
    
    # 응답온거
    res = huc.getresponse()
    
    # 응답내용
    resBody = res.read()
    print(resBody)
    
    # 한글처리해서 보려면
    print(resBody.decode())
    ####################################################
    # XML파싱
    xmlDATA = fromstring(resBody)
    
    # 여러개 찾을 때 xxx.getiterator("태그명")
    # 하나 찾을 때 xxx.find("태그명")
    # 내용 xxx.text
    row = xmlDATA.getiterator("row") # <row></row>들
    for r in row:
        f.write(r.find("CORONA19_NO").text + ",")
        f.write(r.find("CORONA19_PERSONAL").text + ",")
        f.write(r.find("CORONA19_DATE").text + ",")
        f.write(r.find("CORONA19_AREA").text + ",")
        f.write(r.find("CORONA19_CONTACT_HISTORY").text + "\n")
        
print("끝")
f.close()
