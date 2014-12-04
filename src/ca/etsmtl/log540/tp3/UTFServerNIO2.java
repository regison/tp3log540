package ca.etsmtl.log540.tp3;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutionException;

public class UTFServerNIO2 {

	int PORT = 10110;
	String address = "127.0.0.1";
	
	public static void main(String[] args) {
		System.out.println("Serveur NIO2 On\n");
		
		new UTFServerNIO2().run();
		
		System.out.println("\nServeur NIO2 Off");
	}

	void run() {
		// TODO Exercice #3
		AsynchronousServerSocketChannel serverChannel;
		
		try {
			
			serverChannel = AsynchronousServerSocketChannel.open();
			InetSocketAddress address = new InetSocketAddress(PORT);
			serverChannel.bind(address);
			serverChannel.accept(null, new AcceptCompletionHandler(serverChannel));//attachment = null
			
			//Attente
			System.in.read();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}

	static class AcceptCompletionHandler implements
			CompletionHandler<AsynchronousSocketChannel, ByteBuffer> {

		private final AsynchronousServerSocketChannel serverChannel;
		
		public AcceptCompletionHandler(AsynchronousServerSocketChannel channel) {
			this.serverChannel = channel;
		}

		
		
		@Override
		public void completed(AsynchronousSocketChannel channel,
				ByteBuffer attachment) {
			// TODO Exercice #3
			serverChannel.accept(null, this);
			ByteBuffer buffer = ByteBuffer.allocate(100);
			System.out.println("Connection etablie avec succes");
			//ByteBuffer buffer = ByteBuffer.allocate(100);
			//transmission d'information
			//while (result)
			channel.read(buffer, buffer, new ReadCompletionHandler(channel));
			//System.out.println("Lu :");
			//System.out.println("Vous avez tapez : " + new String(buffer));
			// ...
			
			try {
				System.out.println("Connection entrante0 de :" + channel.getRemoteAddress());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		@Override
		public void failed(Throwable exc, ByteBuffer attachment) {
			// TODO Exercice #3
			serverChannel.accept(null, this);
			throw new UnsupportedOperationException("impossible d'accepter la conection!");

		}

	}

	
	static class ReadCompletionHandler implements
			CompletionHandler<Integer, ByteBuffer> {

		 private final AsynchronousSocketChannel channel;
		    
		    public ReadCompletionHandler(AsynchronousSocketChannel channel) {
		    	this.channel = channel;
		    }

		
		@Override
		public void completed(Integer result, ByteBuffer buffer) {
			// TODO Exercice #3
			
			try {
				System.out.println("Connection etablie - commencez a entrer les donnees");
				//buffer.compact();
				//buffer.clear();
			//result = channel.read(buffer).get();
			while ((result = channel.read(buffer).get()) != -1){
				if (result != -1) {
					//if (result != -1) {	  
				      // …
					//System.out.println("Connection entrante de " + )
				        	//channel.read(buffer, buffer, this);
					//buffer.flip();
					String rcv = new String(buffer.array());
					System.out.println("\nVous avez tapez : " + rcv);
					rcv = "";
					buffer.compact();
					buffer.clear();
				}
				else {
					
					channel.close();
					
				}
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		}

		@Override
		public void failed(Throwable exc, ByteBuffer buffer) {
			// TODO Exercice #3
			 try {
				channel.read(buffer).get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 finally {
					try {
						channel.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			throw new UnsupportedOperationException("impossible deffectuer la lecture!");

		}

	}
	
}
