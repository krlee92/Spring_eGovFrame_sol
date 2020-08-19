# -*- coding:utf-8 -*-
from http.client import HTTPConnection
from getNaverNews import resBody
from json import loads

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
print(type(weatherData))

l = weatherData["weather"][0]["description"]
# print(type(l))
print(weatherData["weather"][0]["description"])
print(weatherData["main"]["temp"])
print(weatherData["main"]["feels_like"])
print(weatherData["main"]["humidity"])