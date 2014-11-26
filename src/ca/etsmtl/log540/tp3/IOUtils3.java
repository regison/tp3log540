package ca.etsmtl.log540.tp3;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;

public class IOUtils3 {
	
	public static void closeSocket(Object monObjet) {
        String objClassName = monObjet.getClass().getName();
        final String socketVar="java.net.Socket";
        final String serverSocket="java.net.ServerSocket";
        final String reader ="ava.io.Reader";
        final String writer="java.io.Writer";
        final String printWriter ="java.io.PrintWriter";
        final String inputStream="java.io.InputStream";
        final String outPutStream="java.io.OutputStream";
        final String inputStreamReader="java.io.InputStreamReader";
        final String outPutStreamWriter= "java.io.OutputStreamWriter";
       
        if (monObjet != null)
        {
                try {
                        if(objClassName.equals(socketVar)) {
                                ((Socket) monObjet).close();
                                
                        } else if(objClassName == serverSocket) {
                                ((ServerSocket) monObjet).close();
                                
                        } else if(objClassName == reader) {
                                ((Reader) monObjet).close();
                                
                        } else if(objClassName == writer ) {
                                ((Writer) monObjet).close();
                                
                        } else if(objClassName == printWriter) {
                                ((PrintWriter) monObjet).close();
                                
                        } else if(objClassName == inputStream) {
                                ((InputStream) monObjet).close();
                                
                        } else if(objClassName == outPutStream) {
                                ((OutputStream) monObjet).close();
                                
                        } else if(objClassName ==inputStreamReader ) {
                                ((InputStreamReader) monObjet).close();
                                
                        } else if(objClassName ==outPutStreamWriter) {
                                ((OutputStreamWriter) monObjet).close();
                        }
                        
                } catch(IOException e) {
                        e.printStackTrace();
                }
               
        }
}


}
