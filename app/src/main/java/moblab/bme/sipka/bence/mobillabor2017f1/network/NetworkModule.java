package moblab.bme.sipka.bence.mobillabor2017f1.network;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import moblab.bme.sipka.bence.mobillabor2017f1.network.recipe.RecipeApi;
import moblab.bme.sipka.bence.mobillabor2017f1.utils.GsonHelper;
import okhttp3.OkHttpClient;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

@Module
public class NetworkModule {

    @Provides
    @Singleton
    public OkHttpClient.Builder provideOkHttpClientBuilder() {
        return new OkHttpClient().newBuilder();
    }


    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(OkHttpClient.Builder builder) {
        return builder.build();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient client) {
        return new Retrofit.Builder().baseUrl(NetworkConfig.SERVICE_ENDPOINT).client(client)
                .addConverterFactory(GsonConverterFactory.create(GsonHelper.getGson())).build();
    }

    @Provides
    @Singleton
    public RecipeApi provideARecipeApi(Retrofit retrofit) {
        return retrofit.create(RecipeApi.class);
    }


}