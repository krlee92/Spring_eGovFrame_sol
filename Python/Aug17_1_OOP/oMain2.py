# -*- coding:utf-8 -*-
from animal.pet import dog  # from 패키지명.모듈명 import 가져올거

class dog:
    def bark(self):
        print("컹")

d = dog()                   # 클래스명() : 중복되면 가까이 있는걸로
d.bark()

# import animal.pet as ap # import 패키지명.모듈명 as 별명
# d = ap.cat()            # 별명.클래스명()
# d.meow()

# import animal.pet     # import 패키지명.모듈명 -> 쓸 수 있게 됨
#                         # animal.pet에 있는 소스가 여기로
# d = animal.pet.dog()     # 패키지명.모듈명.클래스명()
# d.bark()

# P : 다른 모듈에 있는거 사용하려면 import 필수

# J : import는 옵션사항
#    원래문법 : 
#        패키지명.클래스명 변수명 = new 패키지명.클래스명();
#java.util.Random r = new java.util.Random();
#    원래문법에서 패키지명을 생략가능하게 해주는거 : import
#    import후에 : 
#        클래스명 변수명 = new 클래스명();
#Random r = new Random();
#    같은 패키지 or java.lang패키지는 import안해도
#        클래스명 변수명 = new 클래스명();가능



# J : package > class
#        class명 같을 때 package로 구별
#        전세계적으로 package명이 중복이 없어야
#            com.회사명.프로그램명.카테고리
#        무조건 package > class

# P : package > module > class
#        class명 같을 때 module, package로 구별 - ?
#        package를 안쓰는 경우, class를 안쓰는 경우 많음
#        ???




