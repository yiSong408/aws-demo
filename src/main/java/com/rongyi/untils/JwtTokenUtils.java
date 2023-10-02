package com.rongyi.untils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class JwtTokenUtils {
    private static String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCoAsaDbz2SmVxdYVAZ4uWpAKqt1XRSDgyD5giHUfQ1PbJpwvUzKvnIyoYoBs8r3G6jkRoV7Xa3PfKKu37BeHxZ+MPPFwX+9eUZQl+XeLDGOiV8Nq6PKN2AL/Aind8vuBBAI3kzKzwPrwClLVgTxut5zg6jpoWUSjYoWnupePgI7wIDAQAB";
    private static String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAKgCxoNvPZKZXF1hUBni5akAqq3VdFIODIPmCIdR9DU9smnC9TMq+cjKhigGzyvcbqORGhXtdrc98oq7fsF4fFn4w88XBf715RlCX5d4sMY6JXw2ro8o3YAv8CKd3y+4EEAjeTMrPA+vAKUtWBPG63nODqOmhZRKNihae6l4+AjvAgMBAAECgYBcklrq5IoakmGwGgRWnwxHmFRyv5/97ju7GS4t0VwrUblSSNdtwAotNlnBCC9yTVywxyyGVHcK9BkFk9V9qHNrAl1mAT81a/eI3debbUzYtFXktUsyT42LN567AfElOM4G2bNSZXQg/1Buq/JDzxQz8go4ZwvuYpa/c7JUMiJgwQJBAN8cwbE3r1bTAgm5kD169I3Y7QahknXLJ9r8DVJ9+QMjflH8d8BjPVcuTwaTgmsSDgH6oMauUvdrdT0zkwC6HLECQQDAxr1TKo3fYR4zo9mRnU+PIPrsuuFCDX2LD3yN+hi0XO3GWwc2VrohIz3Nt7zWABuoBSJp13jNPzUW1O1yZWefAkAWRXqYRCS+mAWmDt31JSbwWe0fMlW6aHMsCukRiP2ocIyVhow1qjJfV4IP9/2WzpCTZf9Sleg2RoXHfDR6aBmhAkEAr3386lIJ93nE8cPOk8X+oFCovYte9y+qw0Zk4Cb2CHO0rec+SJRpOzOG1tjWWoacpreN3YafXVGWNeO/CW4RBwJAbJ451u2gOrTmiXZxidb1H7mdGmxNuOP4SgJBeQOWrqRnaMs72td9sSWTUoPCJGAKwg+0wbpPDzqxxwjFVtkYAw==";

    /**
     * generate token with jwt methods
     * @param uid
     * @param username
     * @param avatar
     * @return
     */
    public static String generateToken(Long uid, String username, String avatar,String nickname) {
        AccToken accToken = new AccToken(uid, username, avatar, nickname, new Date(new Date().getTime() + 7 * 24 * 60 * 60 * 1000));
        JWTCreator.Builder builder = JWT.create();
        HashMap<String, Object> map = new HashMap<>();
        map.put("username", accToken.getUsername());
        map.put("uid",accToken.getUid());
        map.put("avatar",accToken.getAvatar());
        map.put("nickname",accToken.getNickname());
        String token = builder.withClaim("accToken", map).sign(Algorithm.HMAC256(privateKey));
        return token;
    }

    /**
     * verify token
     * @return
     */
    public static AccToken parseToken(String jwtToken){
        AccToken accToken = null;
        DecodedJWT decode = JWT.decode(jwtToken);
        Claim token = decode.getClaim("accToken");
        Map<String, Object> map = token.asMap();
        accToken = (AccToken) map.get("accToken");
        if(Objects.isNull(accToken))
            throw new RuntimeException();
        return accToken;
    }
}
