package frame;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class Handler {
    public Response requestHandler(ProtocalInterface request)
    {
        return makeAPIRequestAsPerHTTPMethod(request.url(),request.httpMethod(),formRequestSpecification(request));
    }

    private Response makeAPIRequestAsPerHTTPMethod(String url, HttpMethod httpMethod, RequestSpecification requestSpecification) {
        Response response = null;
        switch (httpMethod) {
            case GET:
                response = requestSpecification.get(url);
                break;
            case POST:
                response = requestSpecification.post(url);
                break;
            case PUT:
                response = requestSpecification.put(url);
                break;
            case PATCH:
                response = requestSpecification.patch(url);
                break;
            case DELETE:
                response = requestSpecification.delete(url);
        }

        return response;
    }

    private RequestSpecification formRequestSpecification(ProtocalInterface iServiceEndpoint) {
        RequestSpecification request = given();

        if (iServiceEndpoint.headers() != null) {
            iServiceEndpoint.headers().forEach(h -> request.header(h.getKey(), h.getValue()));
        }

        if (iServiceEndpoint.queryParameters() != null) {
            iServiceEndpoint.queryParameters().forEach(q -> request.queryParam(q.getKey(), q.getValue()));
        }

        if (iServiceEndpoint.pathParameters() != null) {
            iServiceEndpoint.pathParameters().forEach(p -> request.pathParam(p.getKey(), p.getValue()));
        }

        if (iServiceEndpoint.body() != null) {
            request.body(RequestHelper.getJsonString(iServiceEndpoint.body()));
        }

        if (iServiceEndpoint.formParam() != null)
            iServiceEndpoint.formParam().forEach(p -> request.formParam(p.getKey(), p.getValue()));

        request.log().all();
        return request;
    }
}
