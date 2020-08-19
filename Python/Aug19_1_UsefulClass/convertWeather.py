# -*- coding:utf-8 -*-
from cx_Oracle import connect

# 연결

# cx_oracle
con = connect("krlee92/1111@192.168.0.88:1521/xe") # sqlplus쓰던 형식
# sqlplus 아이디/비번@IP주소:포트번호/DB이름

# DB관련 작업 총괄 객체(pstmt)
cur = con.cursor()

f = open("d:/lee/weather.csv", "a", encoding="utf-8")

sql = "select * from weather" 
cur.execute(sql) # cur에 select결과 담김
for w in cur:
    f.write(str(w[0]) + ",")
    f.write(str(w[1]) + ",")
    f.write(str(w[2]) + ",")
    f.write(w[3] + ",")
    f.write(str(w[4]) + ",")
    f.write(str(w[5]) + ",")
    f.write(str(w[6]) + "\n")

f.close()
con.close()