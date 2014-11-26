package ca.etsmtl.log540.tp3;


import java.io.IOException;
<<<<<<< Updated upstream
import java.net.InetSocketAddress;
import java.net.ServerSocket;
=======
<<<<<<< HEAD
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.ServerSocketChannel;
=======
import java.net.InetSocketAddress;
import java.net.ServerSocket;
>>>>>>> Stashed changes
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

<<<<<<< Updated upstream
=======
>>>>>>> FETCH_HEAD
>>>>>>> Stashed changes


public class UTFServerNIO {
	int PORT = 10110;
	
	public static void main(String[] args) throws IOException {
		new UTFServerNIO().run();
	}

	void run() throws IOException {
<<<<<<< Updated upstream
		int port = 10110;
		
		// TODO Exercice #1
		
=======
<<<<<<< HEAD
		// TODO Exercice #1
		
		ServerSocketChannel serverChannel = ServerSocketChannel.open();
		ServerSocket serverSocket = serverChannel.socket();
		InetSocketAddress address = new InetSocketAddress(PORT);
		serverSocket.bind(address);

		
		ServerSocket socketServeur = null;
		Socket socketClient = null;
		BufferedWriter outPut = null;
		InputStreamReader inPut = null;
        

		try {
			socketServeur = new ServerSocket(PORT);
			System.out.println("Serveur_simple en mode on ");

			socketClient = socketServeur.accept();
			System.out.println("Connection etablie avec succes");

			outPut = new BufferedWriter(new OutputStreamWriter(System.out,
					"UTF8"));
			inPut = new InputStreamReader(socketClient.getInputStream(),
					"UTF-8");

			int offset = 0;
			int length = 256;
			char[] cbuf = new char[length];

			while (inPut.read(cbuf, offset, cbuf.length) != -1) {
				outPut.write("Vous avez tapez : " + new String(cbuf));
				outPut.newLine();
				outPut.flush();
				cbuf = new char[length];
				
			}

		
               
} catch (IOException e) {
	System.err.println("On ne peut pas ecouter sur le   port: 10110."); 
	System.exit(1); 
               
} finally {
        IOUtils3.closeSocket(outPut);
        IOUtils3.closeSocket(inPut);
        IOUtils3.closeSocket(socketClient);
        IOUtils3.closeSocket(socketServeur);
}
		
	}

}

/*
 *
 * public class UTFServer {
	
	public static void main(String[] args) throws IOException {
        

} 
}
 * 
 * */
 
=======
		int port = 10110;
		
		// TODO Exercice #1
		
>>>>>>> Stashed changes
		//Creation du canal
				ServerSocketChannel serverChannel = ServerSocketChannel.open();
				ServerSocket serverSocket = serverChannel.socket();
				InetSocketAddress address = new InetSocketAddress(port);
				System.out.println("Serveur_simple en mode on ");
				serverSocket.bind(address);

		//mode asynchrone
				serverChannel.configureBlocking(false);
		//enregistrement au canal du selector		
				Selector selector = Selector.open();
				serverChannel.register(selector, SelectionKey.OP_ACCEPT);
				
				for(SelectionKey key : selector.selectedKeys() )
				{
					if (key.isAcceptable()) {
						ServerSocketChannel server = (ServerSocketChannel)key.channel();
						SocketChannel client = server.accept();
						System.out.println("Connection etablie avec succes");
						client.configureBlocking(false);						
						client.register(selector, SelectionKey.OP_READ,ByteBuffer.allocate(100));
					}
					 if (key.isReadable()){
						 SocketChannel client = (SocketChannel) key.channel();
						 ByteBuffer output = (ByteBuffer) key.attachment();
						 client.read(output);
						 
						 
						 /*int offset = 0;
							int length = 256;
							char[] cbuf = new char[length];
							
							while (client.read(cbuf, offset, cbuf.length) != -1) {
								outPut.write("Vous avez tapez : " + new String(cbuf));
								outPut.newLine();
								outPut.flush();
								cbuf = new char[length];
								
							}*/
						 output.clear();
					 }
				}
				
		
				
				
	}
	/*
	 *
	 * public class UTFServer {
		
		public static void main(String[] args) throws IOException {
	        
			ServerSocket socketServeur = null;
			Socket socketClient = null;
			BufferedWriter outPut = null;
			InputStreamReader inPut = null;
	        int port = 10110;
			try {
				socketServeur = new ServerSocket(port);
				System.out.println("Serveur_simple en mode on ");
				socketClient = socketServeur.accept();
				System.out.println("Connection etablie avec succes");
				outPut = new BufferedWriter(new OutputStreamWriter(System.out,
						"UTF8"));
				inPut = new InputStreamReader(socketClient.getInputStream(),
						"UTF-8");
				int offset = 0;
				int length = 256;
				char[] cbuf = new char[length];
				while (inPut.read(cbuf, offset, cbuf.length) != -1) {
					outPut.write("Vous avez tapez : " + new String(cbuf));
					outPut.newLine();
					outPut.flush();
					cbuf = new char[length];
					
				}
			
	               
	} catch (IOException e) {
		System.err.println("On ne peut pas ecouter sur le   port: 10110."); 
		System.exit(1); 
	               
	} finally {
	        IOUtil.closeSocket(outPut);
	        IOUtil.closeSocket(inPut);
	        IOUtil.closeSocket(socketClient);
	        IOUtil.closeSocket(socketServeur);
	}
	} 
	}
	 * 
	 * */

}
<<<<<<< Updated upstream
=======
>>>>>>> FETCH_HEAD
>>>>>>> Stashed changes
