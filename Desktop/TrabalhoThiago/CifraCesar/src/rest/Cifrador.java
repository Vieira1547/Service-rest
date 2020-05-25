package rest;

import javax.ws.rs.Path;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/cifrador")
public class Cifrador {
	
	@Path("/crip")
	@GET
	@Produces("text/plain")
	public String encriptar(@QueryParam("crip")int crip, @QueryParam("texto") String texto){
        StringBuilder textoCifrado = new StringBuilder();
        int tamanhoTexto = texto.length();

        for(int c=0; c < tamanhoTexto; c++){
            int letraCifradaASCII = ((int) texto.charAt(c)) + crip;

            while(letraCifradaASCII > 126)
                letraCifradaASCII -= 94;

            textoCifrado.append( (char)letraCifradaASCII );
        }
        return textoCifrado.toString();
    }
	@Path("/decrip")
	@GET
    @Produces("text/plain")
    public String decriptar(@QueryParam("decrip")int desc, @QueryParam("texto-cifrado")String textoCifrado){
        StringBuilder texto = new StringBuilder();
        int tamanhoTexto = textoCifrado.length();

        for(int c=0; c < tamanhoTexto; c++){
            int letraDecifradaASCII = ((int) textoCifrado.charAt(c)) - desc;
            while(letraDecifradaASCII < 32)
                letraDecifradaASCII += 94;

            texto.append( (char)letraDecifradaASCII );
        }

        return texto.toString();
    }
}