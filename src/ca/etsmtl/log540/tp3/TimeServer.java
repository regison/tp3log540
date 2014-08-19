package ca.etsmtl.log540.tp3;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;

public class TimeServer {

	public static void main(String[] args) {
		new TimeServer().run();
	}

	void run() {
		// TODO Exercice #5
	}

	static class TimeServerHandler extends
			SimpleChannelInboundHandler<DatagramPacket> {

		@Override
		protected void channelRead0(ChannelHandlerContext arg0,
				DatagramPacket arg1) throws Exception {
			// TODO Exercice #5
			
		}

	}
}
