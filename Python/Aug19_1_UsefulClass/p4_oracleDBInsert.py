# -*- coding:utf-8 -*-
from cx_Oracle import connect

# J-O : ojdbc8.jar
# Python - OracleDB : cx_Oracle.py(instant_client가 필요)

# cmd
#    pip3 install cx_Oracle

# 연결
# cx_oracle
con = connect("krlee92/1111@192.168.0.88:1521/xe") # sqlplus쓰던 형식
# sqlplus 아이디/비번@IP주소:포트번호/DB이름

# DB관련 작업 총괄 객체(pstmt)
cur = con.cursor()

n = input("메뉴명 : ")
p = int(input("가격 : "))

# SQL완성
sql = "insert into aug19_coffee values('%s', %d)"  % (n, p)

# 수행하기
cur.execute(sql)

if cur.rowcount == 1:
    print("성공")
    con.commit()

con.close()
