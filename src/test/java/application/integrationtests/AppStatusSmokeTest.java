package application.integrationtests;

import org.junit.Test;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;


public class AppStatusSmokeTest extends IntegrationTest {

    @Test
    public void shouldRespondWithStatus200() throws Exception {
        givenServerIsRunning();
        whenARequestIsSent();
        thenTheServerRespondsWithStatus200();
    }

    private void whenARequestIsSent() {
        setResponse(getTemplate().getForEntity(getUrl().toString() + "status", String.class));
    }

    private void thenTheServerRespondsWithStatus200() {
        assertThat(getResponse().getStatusCode()).isEqualTo(HttpStatus.OK);
    }

}