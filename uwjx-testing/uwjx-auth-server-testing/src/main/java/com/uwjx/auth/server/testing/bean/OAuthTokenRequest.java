package com.uwjx.auth.server.testing.bean;

import lombok.Data;

@Data
public class OAuthTokenRequest {
    /**
     *  grant_type
     *          REQUIRED.  Value MUST be set to "authorization_code".
     *
     *    code
     *          REQUIRED.  The authorization code received from the
     *          authorization server.
     *
     *    redirect_uri
     *          REQUIRED, if the "redirect_uri" parameter was included in the
     *          authorization request as described in Section 4.1.1, and their
     *          values MUST be identical.
     *
     *    client_id
     */
    private String grant_type;
    private String code;
    private String redirect_uri;
    private String client_id;
}
