Chat Application
This is a simple multi-client chat application built using Java. It allows clients to connect to a server and send messages to each other in real time. The project showcases fundamental networking concepts using Socket, ServerSocket, and multithreading in Java.

Features:
Multi-Client Support: Multiple clients can connect to the server and communicate with each other.
Real-Time Communication: Clients can send and receive messages instantly.
Simple Command Interface: The client can send messages via the console.
Graceful Shutdown: Clients can disconnect using the "QUIT" command.

Technologies Used
Java

Sockets for Networking
Multithreading for handling multiple clients
How It Works
The application is divided into two parts:

Server: The server listens for incoming client connections on a specified port. Once a client connects, a new thread is created for that client to handle communication.
Client: The client connects to the server and can send messages. All clients connected to the server receive the messages sent by any other client.

Installation:

Clone the repository:
git clone https://github.com/subash3650/ChatApplication.git

Navigate to the project directory:
cd ChatApplication

Compile the server and client files:
javac mserver.java mclient.java

Run the server:
java mserver

In a separate terminal, run the client:
java mclient

Usage:
Start the server on your machine by running the mserver.java file.
Run multiple instances of mclient.java (representing different clients).
The clients can send messages, which will be broadcast to all connected clients.
To quit, type QUIT in the client terminal.

Example
Client 1: Hello from Client 1!
Client 2: Hello from Client 2!
Server response to Client 1: Hello from Client 2!

Future Enhancements
GUI Support: Implement a graphical user interface for the chat application.
Private Messaging: Add support for private messaging between clients.
Encryption: Implement message encryption for secure communication.
