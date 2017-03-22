
package myapp;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.KeyFactory;


public class DemoServlet extends HttpServlet {


  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws IOException {
    resp.setContentType("text/plain");

	//TODO: pending fix for GAE to Datastore default auth. issue,https://github.com/GoogleCloudPlatform/google-cloud-java/issues/1731 
	//saveNameIp();  
	//Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
	//KeyFactory keyFactory = datastore.newKeyFactory().setKind("Person");
	//Key key = keyFactory.newKey("key");
	//Entity somepost = datastore.get(key);

     resp.getWriter().println("{ \"name\": \"Prempoint from Xin Liu\", \"ip\": \""+req.getRemoteAddr()+"\" }");
   }


    private void saveNameIp() {
	Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
	KeyFactory keyFactory = datastore.newKeyFactory().setKind("Person");
	Key key = keyFactory.newKey("key");
	Entity entity = Entity.newBuilder(key)
    	.set("name", "Xin Liu")
    	.set("IP", 127)
    	.build();
	datastore.put(entity);
   }
}
