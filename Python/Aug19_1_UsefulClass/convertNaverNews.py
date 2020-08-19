# -*- coding:utf-8 -*-
from time import sleep

from pymongo.mongo_client import MongoClient


try:
    con = MongoClient("192.168.0.88")
    db = con.xe
    f = open("d:/lee/naverNews.txt", "a", encoding="utf-8")
    
    for nn in db.naverNews.find():
        f.write(str(nn["m"]) + "\t")
        f.write(str(nn["d"]) + "\t")
        f.write(str(nn["h"]) + "\t")
        f.write(nn["t"] + "\t")
        f.write(nn["desc"] + "\n")
    
    print("끝")
    f.close()
    con.close()
except Exception as e:
    print(e)
