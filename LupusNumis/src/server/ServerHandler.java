package server;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class ServerHandler implements HttpHandler {
	public ServerHandler() {
		try {
			HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
			server.createContext("/", this);
			server.setExecutor(null);	
		    server.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void handle(HttpExchange exchange) throws IOException {
		System.out.println("HANDLE EXCHANGE");
		String response = "Hello user :)";
		Headers headers = exchange.getResponseHeaders();
	    headers.set("Content-Type","text/plain");
	    exchange.sendResponseHeaders(200, response.length());
	    OutputStream os = exchange.getResponseBody();
	    os.write(response.getBytes()); 
	    os.close();
	}
}

