package cinema;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class UUIDToken {

    @JsonProperty("token")
    public UUID token;

    public UUID getToken() {
        return this.token;
    }

}


