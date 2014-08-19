package ca.etsmtl.log540.tp3;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class UTFServerNIO2 {

	public static void main(String[] args) {
		new UTFServerNIO2().run();
	}

	void run() {
		// TODO Exercice #3
	}

	static class AcceptCompletionHandler implements
			CompletionHandler<AsynchronousSocketChannel, ByteBuffer> {

		@Override
		public void completed(AsynchronousSocketChannel result,
				ByteBuffer attachment) {
			// TODO Exercice #3

		}

		@Override
		public void failed(Throwable exc, ByteBuffer attachment) {
			// TODO Exercice #3

		}

	}

	static class ReadCompletionHandler implements
			CompletionHandler<Integer, ByteBuffer> {

		@Override
		public void completed(Integer result, ByteBuffer attachment) {
			// TODO Exercice #3

		}

		@Override
		public void failed(Throwable exc, ByteBuffer attachment) {
			// TODO Exercice #3

		}

	}
}
