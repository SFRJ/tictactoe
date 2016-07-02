package application.integrationtests;

import application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.net.URL;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@org.springframework.boot.test.IntegrationTest({"server.port=0"})
public class IntegrationTest {

    @Value("${local.server.port}")
    private int port;

    private URL url;
    private RestTemplate template;
    private ResponseEntity<String> response;

    public int getPort() {
        return port;
    }

    public URL getUrl() {
        return url;
    }

    public RestTemplate getTemplate() {
        return template;
    }

    public ResponseEntity<String> getResponse() {
        return response;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public void setTemplate(RestTemplate template) {
        this.template = template;
    }

    public void setResponse(ResponseEntity<String> response) {
        this.response = response;
    }

    //common given for all integration tests
    protected void givenServerIsRunning() throws MalformedURLException {
        setUrl(new URL("http://localhost:" + getPort() + "/"));
        setTemplate(new TestRestTemplate());
    }

    @Test
    public void stabilityCheck() throws Exception {
        //empty on purpose
    }
}
