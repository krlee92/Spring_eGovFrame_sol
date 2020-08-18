# -*- coding:utf-8 -*-

# r : read
# w : write(기존 내용 다 지우고 다시 쓰기)
# a : append(기존 내용 뒤에 쓰기)
f = open("D:\\lee/0818.txt", "r", encoding="utf-8")

# cmt = f.read() # 전체 다 읽어서 str 한덩어리로
# cmt = f.readline() 한 줄 읽어서 str로
# cmt = f.readlines() # 전체 다 읽어서 엔터키 기준으로 나눠서 list로
# print(cmt, type(cmt))

for l in f.readlines():
    l = l.replace("|n", "")
    print(l)
    
f.close()