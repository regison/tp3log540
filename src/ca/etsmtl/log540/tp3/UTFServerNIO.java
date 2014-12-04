package ca.etsmtl.log540.tp3;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Collection;
import java.util.Set;

public class UTFServerNIO {

	int compt;
	
	public static void main(String[] args) throws IOException {
		new UTFServerNIO().run();
	}

	void run() throws IOException {
		int port = 10110;

		// TODO Exercice #1

		// Creation du canal
		ServerSocketChannel serverChannel = ServerSocketChannel.open();
		ServerSocket serverSocket = serverChannel.socket();
		InetSocketAddress address = new InetSocketAddress(port);
		System.out.println("ServeurSocketChannel NIO en mode on ");
		serverSocket.bind(address);

		//Element de la lecture
		//int offset = 0; int length = 100; char[] cbuf = new char[length]; 
		
		// mode asynchrone
		serverChannel.configureBlocking(false);

		// création et enregistrement du selector au canal
		Selector selector = Selector.open();
		serverChannel.register(selector, SelectionKey.OP_ACCEPT);

			while( !Thread.interrupted() ){
				
				selector.select();
				//SelectionKey key = (SelectionKey) selector.selectedKeys(); //récupération de l'évvènement associé
				
				for (SelectionKey key : selector.selectedKeys()) {
				
					if (key.isValid())
					{
						
						if (key.isReadable()) {	
							SocketChannel client = (SocketChannel) key.channel();
							ByteBuffer output  = (ByteBuffer) key.attachment() ;
							output.flip();
							int capacity = client.read(output);
							//client.read(output);
							if (capacity < 0){
								//System.out.println("Erreur de lecture, client probablement déconnecté ");
								//client.socket().close();
								//client.close();
								//key.cancel();
							}
							else 
							{
							String rcv = new String(output.array());
							System.out.println("Vous avez tapez : " + rcv);
							output.clear();
							}
						}
						
						if (key.isAcceptable()) {
							

							ServerSocketChannel server = (ServerSocketChannel) key.channel();
							SocketChannel client = server.accept();
							System.out.println("Connection " + compt + " etablie avec succes");
							compt++;
							client.configureBlocking(false);
							client.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(100));
							
						
						
						}
						
					}
					
				
			}
			
			selector.selectedKeys().clear();
	
		}
			
			
			/*
			finally { 
				
			IOUtil.closeSocket(outPut); IOUtil.closeSocket(inPut);
			IOUtil.closeSocket(socketClient);
			IOUtil.closeSocket(socketServeur); 
		
			} 	
			*/
			
	
	}

}
