# -*- coding:utf-8 -*-
from http.client import HTTPConnection
from getNaverNews import resBody
from json import loads
from cx_Oracle import connect
from datetime import datetime

# api.openweathermap.org/data/2.5/weather
# ?q=seoul
# &appid=baff8f3c6cbc28a4024e336599de28c4
# &units=metric
# &lang=kr
# key = baff8f3c6cbc28a4024e336599de28c4

# HTTP통신 -> 다운받아서 콘솔 출력
huc = HTTPConnection("api.openweathermap.org")
huc.request("GET", "/data/2.5/weather?q=seoul&appid=baff8f3c6cbc28a4024e336599de28c4&units=metric&lang=kr")
resBody = huc.getresponse().read()
# print(resBody.decode())
################################################
# JOSN파싱
# JSON.init
weatherData = loads(resBody) # Python객체로
# print(type(weatherData))

# l = weatherData["weather"][0]["description"]
# print(type(l))
#오라클DB연결################################################
con = connect("krlee92/1111@192.168.0.88:1521/xe")
cur = con.cursor()
now = datetime.today()
#################################################
sql = "insert into weather "
sql += "values(%d, %d, %d, " % (now.month, now.day, now.hour)
sql += "'%s', " % weatherData["weather"][0]["description"]
sql += "%.2f, " % weatherData["main"]["temp"]
sql += "%.2f, " % weatherData["main"]["feels_like"]
sql += "%.2f) " % weatherData["main"]["humidity"]

cur.execute(sql)
if cur.rowcount == 1:
    con.commit()
    print("OK")
    
con.close()
    