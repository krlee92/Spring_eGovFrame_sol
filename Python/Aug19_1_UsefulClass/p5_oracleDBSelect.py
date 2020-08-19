# -*- coding:utf-8 -*-
from cx_Oracle import connect

# 연결
# cx_oracle
con = connect("krlee92/1111@192.168.0.88:1521/xe") # sqlplus쓰던 형식
# sqlplus 아이디/비번@IP주소:포트번호/DB이름

# DB관련 작업 총괄 객체(pstmt)
cur = con.cursor()

# SQL완성
sql = "select * from aug19_coffee"

# 수행하기
cur.execute(sql) # select수행하면 그결과가 cur에 담김

for c in cur:
    print(c)
    print(c[0])
    print(c[1])
    print("---")

con.close()
