class Parent():
    def __init__(self, last_name, eye_color):
        print("Parent Constructor Called")
        self.last_name = last_name
        self.eye_color = eye_color

class Child(Parent):
    def __init__(self, last_name, eye_color, number_of_toys):
        print("Child Constructor Called")
        Parent.__init__(self, last_name, eye_color)
        self.number_of_toys = number_of_toys

#mother_bear = Parent("Bear", "brown")
baby_bear = Child("Bear", "brown", 3)

#print(mother_bear.last_name)
print(baby_bear.last_name)
print(baby_bear.number_of_toys)
