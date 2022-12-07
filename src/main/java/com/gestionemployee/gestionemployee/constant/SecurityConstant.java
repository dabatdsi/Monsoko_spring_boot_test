package com.gestionemployee.gestionemployee.constant;

public class SecurityConstant {
    // enumeration des roles
    public static  final long EXPIRATION_TIME= 432_000_000; // exprimer en 5jour
    public static  final String TOKEN_PREFIX= "Bearer";
    public static  final String  JWT_TOKEN_HEADER= "Jwt_Token";
    public static  final String  TOKEN_CANNOT_BE_VERIFIED= "Token cannot be verified";
    public static  final String GET_ARRAYS_LLC="Get Arrays , LLC";
    public static  final String GET_ARRAYS_ADMINISTRATION="User Management portal";
    public static final String AUTHORITIES= "Authoritie";
    public static final  String FORBIDDEN_MESSAGE= "You need be log in to access this page";
    public static  final String ASSEC_DINEED_MESSAGE= "You do not  have permission to access this page";
    public static final String OPTIONS_HTTP_METHOD="Options";
    public static final String[] PUBLIC_URLS= {"/api/users/login","/api/users/register","/api/users/resetPassword/**"};
}
