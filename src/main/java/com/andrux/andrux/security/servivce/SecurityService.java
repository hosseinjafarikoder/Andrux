package com.andrux.andrux.security.servivce;


public interface SecurityService {

    String findLoggedInUsername();

    void autologin(String username, String password);

}
