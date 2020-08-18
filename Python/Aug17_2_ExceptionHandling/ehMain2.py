# -*- coding:utf-8 -*-
from time import sleep

if __name__ == '__main__':
    try:
        while True:
            cmt = input("뭐 : ")
            print(cmt)
    except KeyboardInterrupt: # ctrl + c(콘솔창에서)
        print("끝")
        sleep(5)
