package myproject.athome.chakuri.model.remote;

import myproject.athome.chakuri.model.api.APIService;

public class APIUtils {

    private APIUtils() {}

    //////////////////////////////////////////////////Local IP//////////////////////////////////////////////

    public static final String LOCAL_IP = "http://192.168.1.31:";

/////////////////////////////////////////////////////API URL's//////////////////////////////////////////////////////

    public static final String GTS_IDENTITY_SERVICE_URL = "4728/api/v1/user/";



    public static APIService getAPIService1() {

        return RetrofitClient.getClient( LOCAL_IP + GTS_IDENTITY_SERVICE_URL).create(APIService.class);

    }


}
