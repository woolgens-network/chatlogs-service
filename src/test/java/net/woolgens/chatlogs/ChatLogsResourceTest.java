package net.woolgens.chatlogs;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import net.woolgens.chatlogs.model.ChatLog;
import net.woolgens.chatlogs.repository.ChatLogsRepository;
import net.woolgens.chatlogs.resource.ChatLogsResource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
@TestHTTPEndpoint(ChatLogsResource.class)
public class ChatLogsResourceTest {

    @Inject
    ChatLogsRepository repository;

    ChatLog chatlog;

    @BeforeEach
    public void setup() {
        chatlog = new ChatLog();
        chatlog.setId(UUID.randomUUID().toString());
        repository.persistOrUpdate(chatlog);
    }

    @Test
    public void testGetAllEndpoint() {
        given()
                .when().get("/")
                .then()
                .statusCode(200)
                .body("isEmpty()", is(false));
    }

    @Test
    public void testGetEndpoint() {
        given()
                .when().get("/" + chatlog.getId())
                .then()
                .statusCode(200)
                .body("id", is(chatlog.getId()));
    }

    @Test
    public void tesPutEndpoint() {
        ChatLog chatlog = new ChatLog();
        chatlog.setId(UUID.randomUUID().toString());
        given().body(chatlog).contentType(ContentType.JSON)
                .when().put("/")
                .then()
                .statusCode(200)
                .body("id", is(chatlog.getId()));
    }


    @Test
    public void tesDeleteEndpoint() {
        given()
                .when().delete("/" + chatlog.getId())
                .then()
                .statusCode(200)
                .body(is("true"));
    }

}