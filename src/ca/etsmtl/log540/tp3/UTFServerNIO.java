package ca.etsmtl.log540.tp3;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

//import ca.etsmtl.log540.tp1.IOUtil;

public class UTFServerNIO {
	
	public static void main(String[] args) {
		new UTFServerNIO().run();
	}

	void run() {
		// TODO Exercice #1
		
		
		
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
 