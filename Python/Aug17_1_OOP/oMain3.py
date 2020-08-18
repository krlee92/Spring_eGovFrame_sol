# -*- coding:utf-8 -*-
class Avengers:
    # 생성자도 상속 됨
    def __init__(self, name, age):
        self.name = name
        self.age = age
        
    def attack(self):
        print("공격")
########################
class Ironman(Avengers):
    def attack(self):
        Avengers.attack(self) # super().attack()
        print("빔 발사")
########################
class Hulk(Avengers):
    # 보통 멤버변수가 추가됨
    # 상속된 메소드의 기능을 바꿈 -> overriding
    # overriding 상위, 하위 메소드 모양이 같아야
    # overloading 메소드명 같은데 파라메터 다른 메소드가 여러개
    def __init__(self, name, age, pantsSize):  
        Avengers.__init__(self, name, age)
        self.pantsSize = pantsSize      
########################
class Human:
    def __init__(self, name, addr):
        self.name = name
        self.addr = addr
    
    def eat(self):
        print("냠")
        
    def attack(self):
        print("공격(사람)")
########################
# 다중상속
#    Avengers에 attack
#    Human에 attack
#    CA의 attack은 어디거? -> 먼저 상속받은(Avengers)걸로
class CA(Avengers, Human):
    def __init__(self, name, age, addr):
        Avengers.__init__(self, name, age)
        Human.__init__(self, name, addr)
        
    def attack(self):
        Avengers.attack(self)
        Human.attack(self)
        # super().attack() # super도 먼저 상속받은(Avengers)걸로
########################
if __name__ == '__main__':
    ca = CA("스티브", 50, "미국")
    ca.attack()
    ca.eat()
    print(ca.name, ca.age, ca.addr)
    print("-----")
    
    i = Ironman("토니", 30)
    i.attack()
    
    h = Hulk("배너", 25, 40)
    print(h.name, h.age, h.pantsSize)
    
    
    
    
    