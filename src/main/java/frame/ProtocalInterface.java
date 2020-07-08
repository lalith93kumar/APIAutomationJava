package frame;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ProtocalInterface {
    String url();

    /**
     * Define HTTP method type
     * @return POST/GET/PUT/DELETE/PATCH
     */
    HttpMethod httpMethod();


    /**
     * Define service endpoint query params
     * @return List of type params
     */
    List<Param> queryParameters();

    /**
     * Define service endpoint path params
     * @return List of type params
     */
    List<Param> pathParameters();

    /**
     * Define service endpoint headers
     * @return List of type params
     */
    List<Param> headers();

    /**
     * Define service endpoint body
     *@return  an intance of type RequestBody
     */
    Object body();

    List<Param> formParam();
}
