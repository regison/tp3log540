package ca.etsmtl.log540.tp3;

import java.util.Date;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;

public class TimeClient {

	private static final int FUDGE_FACTOR = 42 * 1337;

	// L'heure sur le client est brisée! Vous devez obtenir le temps uniquement
	// avec cette méthode
	public static long getClientTime() {
		return System.currentTimeMillis() - FUDGE_FACTOR;
	}

	// Vous pouvez utiliser cette méthode pour vérifier vos résultats
	public static void report(long mauvaiseHeureClient, long estimeHeure,
			long offset) {
		System.out.println("Mauvaise heure: " + new Date(mauvaiseHeureClient));
		System.out
				.println("Estimé de la bonne heure: " + new Date(estimeHeure));
		System.out.println("Vrai heure: "
				+ new Date(System.currentTimeMillis()));
	}

	public static void main(String[] args) {
		new TimeClient().run();
	}

	void run() {
		// TODO Exercice #5
	}

	static class TimeClientHandler extends
			SimpleChannelInboundHandler<DatagramPacket> {

		@Override
		protected void channelRead0(ChannelHandlerContext ctx,
				DatagramPacket packet) throws Exception {
			// TODO Exercice #5
		}

	}

}
