package ca.etsmtl.log540.tp3;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;

import ca.etsmtl.log540.tp3.UTFServerNIO2.AcceptCompletionHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.SocketChannel;


public class UTFServerNetty {

	int PORT = 10110;
	String address = "127.0.0.1";
	
	public static void main(String[] args) {
		new UTFServerNetty().run();
	}

	void run() {
		// TODO Exercice #4
		
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
	
	
	static class UTFServerInitializer extends ChannelInitializer<SocketChannel> {

		@Override
		protected void initChannel(SocketChannel channel) throws Exception {
			
		}
		
	}
	
	static class UTFServerHandler extends SimpleChannelInboundHandler<String> {

		@Override
		protected void channelRead0(ChannelHandlerContext ctx, String msg)
				throws Exception {
			
		}
		
	}
}
