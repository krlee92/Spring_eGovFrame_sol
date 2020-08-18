# -*- coding:utf-8 -*-

class Lion:
    def bark(self):
        print("으르렁")

# J : main method
# P : 이 모듈을 실행했을 때 
#    import당했을 때 말고
if __name__ == "__main__":
    from animal.pet import dog
    d = dog()
    d.bark()



