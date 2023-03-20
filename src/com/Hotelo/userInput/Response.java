package com.Hotelo.userInput;
public class Response<X> {
    public boolean status;
    public X response;

    public Response(boolean _flag, X _response) {
        status = _flag;
        response = _response;
    }
}
