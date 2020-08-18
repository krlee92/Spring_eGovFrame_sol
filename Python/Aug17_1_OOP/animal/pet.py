# -*- coding:utf-8 -*-

class dog:
    def bark(self):
        print("멍")
        
class cat:
    def meow(self):
        print("냥")
        
if __name__ == "__main__":
    from animal.wild import Lion
    l = Lion()
    l.bark()