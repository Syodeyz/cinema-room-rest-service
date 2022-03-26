package cinema.Modal;

import java.util.UUID;

public class Token {
    private  UUID token;
    public Token() {
        this.token = UUID.randomUUID();
    }

    public  String getToken() {
        return token.toString();
    }

}
