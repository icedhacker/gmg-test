Implement a socket server which consumes a continuous stream of characters (in UTF8) and reverses them word by word and 
outputs it. Clients connect to the server and start sending the stream, the server should receive it, 
reverse the data and send it back to the client.  
  
The client may never close the connection. The server should never close the connection. The server should be able to 
handle large number of clients sending data at high speeds.  
  
Sample input: this is a sample sentence and this stream is very long  
Sample output: siht si a elpmas ecnetnes dna siht maerts si yrev gnol