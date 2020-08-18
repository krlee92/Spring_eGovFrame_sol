# -*- coding:utf-8 -*-
# J : 
#    try-catch-finally : 해결까지

#    throws : 해결은 기능을 호출한 쪽에서
#        class단위로 작업
#        작업 끝 -> jar형태(수정불가능)로 주고받음

# P : 예외처리가 필수 아님 
#    try - except - else - finally

# error - 기계어 바꿀 때 번역 불가
# warning - 지저분한 코드
# exception - 실행 가능, 실행 도중에 발생하는 예외적인 상황

# interpreter방식 : 실행하면 한줄씩 기계어로 바꿔서 실행...
if __name__ == '__main__':
    try:
        x = int(input("x : "))
        y = int(input("y : "))
        z = x // y
        print(z)
        l = [123, 12, 45]
        print( l[y] )
    except Exception as e:
        print(e)
    else:
        print("예외발생안함")
    finally:
        print("발생하든말든 리턴보다 먼저")
    
    
    
#     try:
#         x = int(input("x : "))
#         y = int(input("y : "))
#         z = x // y
#         print(z)
#         l = [123, 12, 45]
#         print( l[y] )
#         
#     except ZeroDivisionError:
#         print("나누기 0?")
# 
#     except IndexError:
#         print("list에 그런거 없음")





