package hello_springboot.springboot.parse.client;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;

import hello_springboot.springboot.entity.Institution;

public class ParseClient {
	
	protected final Logger logger = Logger.getLogger(getClass().getName());
	
	public List<Institution> getInstitutions() {
		
		try {
			Form form = Form.form()
					.add("X-Parse-Master-Key", "c4b4c12325224cdb0d4ed883468e4cc2")
					.add("X-Parse-Application-Id", "br.com.metasix.skedly");
			
			HttpResponse response = Request
					.Get("http://h.skedly.com.br/parse/classes/Institution")
					//.bodyForm(form.build())
					.addHeader("X-Parse-Master-Key", "c4b4c12325224cdb0d4ed883468e4cc2")
					.addHeader("X-Parse-Application-Id", "br.com.metasix.skedly")
					.execute().returnResponse();
			
			if(response.getStatusLine().getStatusCode() == 400){
				// throw message error
			}
			
			return new ArrayList<Institution>((Collection<? extends Institution>) response.getEntity().getContent());
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Erro desconhecido: " + e.getMessage());
		}
		return null;
		
	}

}
