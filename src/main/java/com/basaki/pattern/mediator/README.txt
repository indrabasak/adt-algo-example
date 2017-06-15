Motivation

In order to have a good object oriented design we have to create lots of classes interacting one with each other. 
If certain principles are not applied the final framework will end in a total mess where each object relies on 
many other objects in order to run. In order to avoid tight coupled frameworks, we need a mechanism to 
facilitate the interaction between objects in a manner in that objects are not aware of the existence of other objects.

Let's take the example of a screen. When we create it we add all sort of controls to the screen. 
This control need to interact with all the other control. For example when a button is pressed it must 
know if the data is valid in other controls. As you have seen if you created different applications 
using forms you don't have to modify each control class each time you add a new control to the form. A
ll the operations between controls are managed by the form class itself. This class is called mediator.

Intent

Define an object that encapsulates how a set of objects interact. Mediator promotes loose coupling 
by keeping objects from referring to each other explicitly, and it lets you vary their interaction independently.