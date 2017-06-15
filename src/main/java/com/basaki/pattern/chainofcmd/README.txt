The Chain of Responsibility design pattern allows an object to send a command without knowing what object will receive and handle it. 
The request is sent from one object to another making them parts of a chain and each object in this chain can handle the command, 
pass it on or do both. The most usual example of a machine using the Chain of Responsibility is the vending machine coin slot:
 rather than having a slot for each type of coin, the machine has only one slot for all of them. The dropped coin is routed to the appropriate storage place that is determined by the receiver of the command.

Intent:
It avoids attaching the sender of a request to its receiver, giving this way other objects the possibility of handling the request too.
The objects become parts of a chain and the request is sent from one object to another across the chain until one of the objects will handle it.
Implementation

The UML diagram of classes below will help us understand better the way the Chain works.

Chain of Responsability Implementation - UML Class Diagram
In the diagram above some explanations are needed on what is the role of every class:
Handler - defines an interface for handling requests
RequestHandler - handles the requests it is responsible for
If it can handle the request it does so, otherwise it sends the request to its successor
Client - sends commands to the first object in the chain that may handle the command

Here is how sending a request works in the application using the Chain of Responsibility: 
the Client in need of a request to be handled sends it to the chain of handlers, 
which are classes that extend the Handler class. Each of the handlers in the chain takes i
ts turn at trying to handle the request it receives from the client. If ConcreteHandler_i can handle it, 
then the request is handled, if not it is sent to the handler ConcreteHandler_i+1, the next one in the chain.
