import turtle

def draw_square():
    #Add a window screen
    window = turtle.Screen()
    
    #Add a bg color to screen
    window.bgcolor("yellow")
    
    #Create a turtle
    Tonka = turtle.Turtle()
    Tonka.shape("circle")
    Tonka.color("blue")
    
    #Move the turtle
    x = 0
    while(x < 4):
        Tonka.forward(100)
        Tonka.right(90)
        x += 1        

    #Close window
    window.exitonclick()

draw_square()
