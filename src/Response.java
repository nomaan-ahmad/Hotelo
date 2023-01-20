public class Response<X> {
    boolean status;
    X response;

    Response(boolean _flag, X _response) {
        status = _flag;
        response = _response;
    }
}
