# -*- coding:utf-8 -*-
from datetime import datetime
from time import strftime
# 패키지없음
#    모듈명          클래스명

# 현재시간날짜
# datetime _없는거
now = datetime.today() # static메소드
print(now, type(now))

# J : Date객체를 만들 때 2000년대를 고려 안했어서
# P : datetime만들 때 2000년대를 고려 했음
# 연도만
print(now.year)

# 특정시간날짜
birthday = datetime(2020, 9, 1)
print(birthday)

# help(datetime)
#############################
# 패턴 확인
help(strftime) # time소속 strftime확인

# datetime -> string
s = datetime.strftime(birthday, "%m%d")
print(s)

# string -> datetime
d = datetime.strptime("20200901", "%Y%m%d")
print(d)