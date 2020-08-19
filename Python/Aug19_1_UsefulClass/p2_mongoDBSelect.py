# -*- coding:utf-8 -*-
from pymongo.mongo_client import MongoClient


# 연결
con = MongoClient("192.168.0.88")

# 연결된 DB 가져오기
db = con.xe     # con.DB명

coffees = db.aug19_coffee.find()
for c in coffees:
    print(c)
    print(c["_id"])
    print(c["c_price"])
    print("-----")