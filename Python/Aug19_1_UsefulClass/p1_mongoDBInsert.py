# -*- coding:utf-8 -*-
#MongoDB서버 ON
#1) DB파일이 저장될 폴더 확보
#    D:\lee\MDB
# 2) 설치된곳에서 cmd
from pymongo.mongo_client import MongoClient

# 3) 명령어
#    리눅스에서 서비스를 데몬
#    mongod --dbpath DB파일저장될 폴더 --bind_ip_all
#####################################################
#MongoDB 접속
# 1) 설치된곳에서 cmd(새로)

# 2) 명령어
#    mongo 서버IP주소(자기컴퓨터면생략) => 이 컴퓨터가 서버라서 이 컴퓨터에 접속
#    mongo 
#################################
# use DB명
# use xe(cmd)
##################################
# Java - OracleDB연동 : ojdbc8.jar
#    jar파일 자동관리 시스템 : maven

# Python - MongoDB연동 : pymongo.py
#    모듈 자동관리 시스템 : pip
#    그냥cmd - pip3 install pymongo

# 새로운 cmd
#    pip3 install 모듈명
#    pip3 uninstall 모듈명
##############################

# 연결
con = MongoClient("192.168.0.88")

# 연결된 DB 가져오기
db = con.xe     # con.DB명

n = input("메뉴명 : ")
p = int(input("가격 : "))

# MongoDB : NoSQL -> JS문법 => Python문법과 비슷
#            테이블속의 데이터 x -> JS배열속의 JS객체
#                => Python list속의 dict

# pymongo의 기능 : MongoDB문법을 여기서 그대로
try:
    db.aug19_coffee.insert({"_id" : n, "c_price" : p})
    print("성공")
except Exception as e:
    print(e)
    print("실패")

con.close()