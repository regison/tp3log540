package ca.etsmtl.log540.tp3;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.SocketChannel;


public class UTFServerNetty {

	public static void main(String[] args) {
		new UTFServerNetty().run();
	}

	void run() {
		// TODO Exercice #4
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
