package myproject.athome.chakuri.model.remote;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitClient  {

    private static Retrofit retrofit = null;
    private static Retrofit retrofit2 = null;
    private static Retrofit retrofit3 = null;
    private static Retrofit retrofit4 = null;
    private static Retrofit retrofit5 = null;
    private static Retrofit retrofit6 = null;
    private static Retrofit retrofit7 = null;
    private static Retrofit retrofit8 = null;
    private static Retrofit retrofit9 = null;
    private static Retrofit retrofit10 = null;
    private static Retrofit retrofit11 = null;
    private static Retrofit retrofit12 = null;
    private static Retrofit retrofit13 = null;
    private static Retrofit retrofit14 = null;
    private static Retrofit retrofit15 = null;
    private static Retrofit retrofit16 = null;
    private static Retrofit retrofit17 = null;
    private static Retrofit retrofit18 = null;
    private static Retrofit retrofit19 = null;
    private static Retrofit retrofit20 = null;







    public static Retrofit getClient(String baseUrl) {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();


        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .client(client)
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
/////////////////////////////for Personal Details/////////////////////////////////////////////////////////

    public static Retrofit getClient2(String baseUrl2) {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();


        if (retrofit2==null) {
            retrofit2 = new Retrofit.Builder()
                    .client(client)
                    .baseUrl(baseUrl2)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit2;
    }

    /////////////////////////////forResume Upload/////////////////////////////////////

    public static Retrofit getClient3(String baseUrl3) {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();


        if (retrofit3==null) {
            retrofit3 = new Retrofit.Builder()
                    .client(client)
                    .baseUrl(baseUrl3)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit3;
    }

    /////////////////////////////////For Resume Download////////////////////////////
    public static Retrofit getClient4(String baseUrl4) {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        if (retrofit4==null) {
            retrofit4 = new Retrofit.Builder()
                    .client(client)
                    .baseUrl(baseUrl4)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit4;
    }

    ////////////////////////////////FOR Getting Country Name/////////////////////////////////////
    public static Retrofit getClient5(String baseUrl5) {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        if (retrofit5==null) {
            retrofit5 = new Retrofit.Builder()
                    .client(client)
                    .baseUrl(baseUrl5)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit5;
    }

    ////////////////////////////////FOR Getting States Name/////////////////////////////////////
    public static Retrofit getClient6(String baseUrl6) {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        if (retrofit6==null) {
            retrofit6 = new Retrofit.Builder()
                    .client(client)
                    .baseUrl(baseUrl6)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit6;
    }

    ////////////////////////////////FOR Getting City Name/////////////////////////////////////
    public static Retrofit getClient7(String baseUrl7) {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        if (retrofit7==null) {
            retrofit7 = new Retrofit.Builder()
                    .client(client)
                    .baseUrl(baseUrl7)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit7;
    }

    ////////////////////////////////FOR ADDRESS SERVICE ////////////////////////////////////
    public static Retrofit getClient8(String baseUrl8) {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        if (retrofit8==null) {
            retrofit8 = new Retrofit.Builder()
                    .client(client)
                    .baseUrl(baseUrl8)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit8;
    }

    ////////////////////////////////FOR GETTING NATIONALITIES ////////////////////////////////////
    public static Retrofit getClient9(String baseUrl9) {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        if (retrofit9==null) {
            retrofit9 = new Retrofit.Builder()
                    .client(client)
                    .baseUrl(baseUrl9)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit9;
    }

    ////////////////////////////////FOR GETTING skills ////////////////////////////////////
    public static Retrofit getClient10(String baseUrl10) {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        if (retrofit10 == null) {
            retrofit10 = new Retrofit.Builder()
                    .client(client)
                    .baseUrl(baseUrl10)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit10;
    }

    ////////////////////////////////FOR GETTING USER skills ////////////////////////////////////
    public static Retrofit getClient11(String baseUrl11) {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        if (retrofit11 == null) {
            retrofit11 = new Retrofit.Builder()
                    .client(client)
                    .baseUrl(baseUrl11)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit11;
    }

    ////////////////////////////////FOR DEGREES API ////////////////////////////////////
    public static Retrofit getClient12(String baseUrl12) {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        if (retrofit12 == null) {
            retrofit12 = new Retrofit.Builder()
                    .client(client)
                    .baseUrl(baseUrl12)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit12;
    }

    ////////////////////////////////FOR INSTITUTES API ////////////////////////////////////
    public static Retrofit getClient13(String baseUrl13) {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        if (retrofit13 == null) {
            retrofit13 = new Retrofit.Builder()
                    .client(client)
                    .baseUrl(baseUrl13)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit13;
    }

    ////////////////////////////////FOR USER EDUCATION API ////////////////////////////////////
    public static Retrofit getClient14(String baseUrl14) {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        if (retrofit14 == null) {
            retrofit14 = new Retrofit.Builder()
                    .client(client)
                    .baseUrl(baseUrl14)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit14;
    }

    ////////////////////////////////FOR LANGUAGES API ////////////////////////////////////
    public static Retrofit getClient15(String baseUrl15) {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        if (retrofit15 == null) {
            retrofit15 = new Retrofit.Builder()
                    .client(client)
                    .baseUrl(baseUrl15)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit15;
    }

    ////////////////////////////////FOR USER LANGUAGES API ////////////////////////////////////
    public static Retrofit getClient16(String baseUrl16) {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        if (retrofit16 == null) {
            retrofit16 = new Retrofit.Builder()
                    .client(client)
                    .baseUrl(baseUrl16)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit16;
    }










}
