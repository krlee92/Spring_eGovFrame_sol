# -*- coding:utf-8 -*-

# J : 완전한 객체지향언어 -> 규칙
#        성능 중시 -> 메모리...
#        1 class = 1 file(OOP의 코드 재사용성 증가)
#        클래스명 대문자로 시작(다른 사람이 알아보기 편함)

# P : 하이브리드한 객체지향언어 -> 자유
#        개발 편의성 중시 -> 문법 간단
#        1 class != 1 file
#        클래스명 대문자로 시작 규칙 없음
#        접근제어자(private, public, ...) 없음 => 캡슐화 없음
#        static 멤버변수 없음
class Dog:
    name = None
    # age = None # 별 의미 없음

    def bark(self): # 메소드는 첫번째 파라메터로 self
        print("멍") 
    
    def bark2(self, c): # overloading없음(메소드명 다 달라야)
        for _ in range(c):
            print("왈") 

    def printInfo(self):
        # J : this.name(this.이 생략가능)
        # P : self.name(self. 생락불가)
        print(self.name, self.age, self.weight)
    
    def staticMethodTest(): # 메소드 첫번째 파라메터로 self없으면 static메소드
        print("개")

#############################
d = Dog()
d.name = "삐삐"
d.age = 3
d.weight = 5    # 외부에서 멤버를 추가 가능

d.bark() # 호출때는 self무시
Dog.bark(d) # 메소드 호출 다른 스타일
print("-----")
d.printInfo()
print("-----")
d.bark2(3)
Dog.bark2(d, 3)
print("-----")
Dog.staticMethodTest()
print("=====")
####################
class Coffee:
    def __init__(self):
        print("커피 생성")

    def __del__(self):
        print("소멸자(객체가 메모리상에서 없어질 때 자동 호출)")
####################
c = Coffee()
c2 = Coffee()
c3 = c

c = None
c3 = None

print("-----")

# Garbage Collection : heap영역 자동 정리
#    그 번지를 가리키는 변수가 없으면 자동 정리
#####################
class Computer:
       
    # overloading이 없어서 생성자는 하나만 가능
    def __init__(self, cpu, ram): 
        self.cpu = cpu  # 생성자에서 멤버변수를 결정
        self.ram = ram
        
    def printInfo(self):
        print(self.cpu)
        print(self.ram)
        
cc = Computer("i7", 16)
cc.printInfo()








