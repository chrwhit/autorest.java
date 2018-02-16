/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package fixtures.azurereport.implementation;

import com.microsoft.azure.v2.AzureEnvironment;
import com.microsoft.azure.v2.AzureProxy;
import com.microsoft.azure.v2.AzureServiceClient;
import com.microsoft.rest.v2.RestResponse;
import com.microsoft.rest.v2.ServiceCallback;
import com.microsoft.rest.v2.ServiceFuture;
import com.microsoft.rest.v2.annotations.ExpectedResponses;
import com.microsoft.rest.v2.annotations.GET;
import com.microsoft.rest.v2.annotations.HeaderParam;
import com.microsoft.rest.v2.annotations.Host;
import com.microsoft.rest.v2.annotations.QueryParam;
import com.microsoft.rest.v2.annotations.UnexpectedResponseExceptionType;
import com.microsoft.rest.v2.credentials.ServiceClientCredentials;
import com.microsoft.rest.v2.http.HttpPipeline;
import fixtures.azurereport.AutoRestReportServiceForAzure;
import fixtures.azurereport.models.ErrorException;
import io.reactivex.Maybe;
import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import java.util.HashMap;
import java.util.Map;

/**
 * Initializes a new instance of the AutoRestReportServiceForAzure type.
 */
public final class AutoRestReportServiceForAzureImpl extends AzureServiceClient implements AutoRestReportServiceForAzure {
    /**
     * The proxy service used to perform REST calls.
     */
    private AutoRestReportServiceForAzureService service;

    /**
     * Gets or sets the preferred language for the response.
     */
    private String acceptLanguage;

    /**
     * Gets Gets or sets the preferred language for the response.
     *
     * @return the acceptLanguage value.
     */
    public String acceptLanguage() {
        return this.acceptLanguage;
    }

    /**
     * Sets Gets or sets the preferred language for the response.
     *
     * @param acceptLanguage the acceptLanguage value.
     * @return the service client itself.
     */
    public AutoRestReportServiceForAzureImpl withAcceptLanguage(String acceptLanguage) {
        this.acceptLanguage = acceptLanguage;
        return this;
    }

    /**
     * Gets or sets the retry timeout in seconds for Long Running Operations. Default value is 30.
     */
    private int longRunningOperationRetryTimeout;

    /**
     * Gets Gets or sets the retry timeout in seconds for Long Running Operations. Default value is 30.
     *
     * @return the longRunningOperationRetryTimeout value.
     */
    public int longRunningOperationRetryTimeout() {
        return this.longRunningOperationRetryTimeout;
    }

    /**
     * Sets Gets or sets the retry timeout in seconds for Long Running Operations. Default value is 30.
     *
     * @param longRunningOperationRetryTimeout the longRunningOperationRetryTimeout value.
     * @return the service client itself.
     */
    public AutoRestReportServiceForAzureImpl withLongRunningOperationRetryTimeout(int longRunningOperationRetryTimeout) {
        this.longRunningOperationRetryTimeout = longRunningOperationRetryTimeout;
        return this;
    }

    /**
     * When set to true a unique x-ms-client-request-id value is generated and included in each request. Default is true.
     */
    private boolean generateClientRequestId;

    /**
     * Gets When set to true a unique x-ms-client-request-id value is generated and included in each request. Default is true.
     *
     * @return the generateClientRequestId value.
     */
    public boolean generateClientRequestId() {
        return this.generateClientRequestId;
    }

    /**
     * Sets When set to true a unique x-ms-client-request-id value is generated and included in each request. Default is true.
     *
     * @param generateClientRequestId the generateClientRequestId value.
     * @return the service client itself.
     */
    public AutoRestReportServiceForAzureImpl withGenerateClientRequestId(boolean generateClientRequestId) {
        this.generateClientRequestId = generateClientRequestId;
        return this;
    }

    /**
     * Initializes an instance of AutoRestReportServiceForAzure client.
     *
     * @param credentials the management credentials for Azure.
     */
    public AutoRestReportServiceForAzureImpl(@NonNull ServiceClientCredentials credentials) {
        this(AzureProxy.createDefaultPipeline(AutoRestReportServiceForAzureImpl.class, credentials));
    }

    /**
     * Initializes an instance of AutoRestReportServiceForAzure client.
     *
     * @param credentials the management credentials for Azure.
     * @param azureEnvironment The environment that requests will target.
     */
    public AutoRestReportServiceForAzureImpl(@NonNull ServiceClientCredentials credentials, @NonNull AzureEnvironment azureEnvironment) {
        this(AzureProxy.createDefaultPipeline(AutoRestReportServiceForAzureImpl.class, credentials), azureEnvironment);
    }

    /**
     * Initializes an instance of AutoRestReportServiceForAzure client.
     *
     * @param httpPipeline The HTTP pipeline to send requests through.
     */
    public AutoRestReportServiceForAzureImpl(@NonNull HttpPipeline httpPipeline) {
        this(httpPipeline, null);
    }

    /**
     * Initializes an instance of AutoRestReportServiceForAzure client.
     *
     * @param httpPipeline The HTTP pipeline to send requests through.
     * @param azureEnvironment The environment that requests will target.
     */
    public AutoRestReportServiceForAzureImpl(@NonNull HttpPipeline httpPipeline, @NonNull AzureEnvironment azureEnvironment) {
        super(httpPipeline, azureEnvironment);
        this.acceptLanguage = "en-US";
        this.longRunningOperationRetryTimeout = 30;
        this.generateClientRequestId = true;
        this.service = AzureProxy.create(AutoRestReportServiceForAzureService.class, this);
    }

    /**
     * The interface defining all the services for
     * AutoRestReportServiceForAzure to be used by the proxy service to perform
     * REST calls.
     */
    @Host("http://localhost:3000")
    private interface AutoRestReportServiceForAzureService {
        @GET("report/azure")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(ErrorException.class)
        Single<RestResponse<Void, Map<String, Integer>>> getReport(@QueryParam("qualifier") String qualifier, @HeaderParam("accept-language") String acceptLanguage);
    }

    /**
     * Get test coverage report.
     *
     * @throws ErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the Map&lt;String, Integer&gt; object if successful.
     */
    public Map<String, Integer> getReport() {
        return getReportAsync().blockingGet();
    }

    /**
     * Get test coverage report.
     *
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return the {@link ServiceFuture&lt;Map&lt;String, Integer&gt;&gt;} object.
     */
    public ServiceFuture<Map<String, Integer>> getReportAsync(ServiceCallback<Map<String, Integer>> serviceCallback) {
        return ServiceFuture.fromBody(getReportAsync(), serviceCallback);
    }

    /**
     * Get test coverage report.
     *
     * @return the {@link Single&lt;RestResponse&lt;Void, Map&lt;String, Integer&gt;&gt;&gt;} object if successful.
     */
    public Single<RestResponse<Void, Map<String, Integer>>> getReportWithRestResponseAsync() {
        final String qualifier = null;
        return service.getReport(qualifier, this.acceptLanguage());
    }

    /**
     * Get test coverage report.
     *
     * @return the {@link Maybe&lt;Map&lt;String, Integer&gt;&gt;} object if successful.
     */
    public Maybe<Map<String, Integer>> getReportAsync() {
        return getReportWithRestResponseAsync()
            .flatMapMaybe(new Function<RestResponse<Void, Map<String, Integer>>, Maybe<Map<String, Integer>>>() {
                @Override
                public Maybe<Map<String, Integer>> apply(RestResponse<Void, Map<String, Integer>> restResponse) {
                    if (restResponse.body() == null) {
                        return Maybe.empty();
                    } else {
                        return Maybe.just(restResponse.body());
                    }
                }
            });
    }

    /**
     * Get test coverage report.
     *
     * @param qualifier If specified, qualifies the generated report further (e.g. '2.7' vs '3.5' in for Python). The only effect is, that generators that run all tests several times, can distinguish the generated reports.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the Map&lt;String, Integer&gt; object if successful.
     */
    public Map<String, Integer> getReport(String qualifier) {
        return getReportAsync(qualifier).blockingGet();
    }

    /**
     * Get test coverage report.
     *
     * @param qualifier If specified, qualifies the generated report further (e.g. '2.7' vs '3.5' in for Python). The only effect is, that generators that run all tests several times, can distinguish the generated reports.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return the {@link ServiceFuture&lt;Map&lt;String, Integer&gt;&gt;} object.
     */
    public ServiceFuture<Map<String, Integer>> getReportAsync(String qualifier, ServiceCallback<Map<String, Integer>> serviceCallback) {
        return ServiceFuture.fromBody(getReportAsync(qualifier), serviceCallback);
    }

    /**
     * Get test coverage report.
     *
     * @param qualifier If specified, qualifies the generated report further (e.g. '2.7' vs '3.5' in for Python). The only effect is, that generators that run all tests several times, can distinguish the generated reports.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return the {@link Single&lt;RestResponse&lt;Void, Map&lt;String, Integer&gt;&gt;&gt;} object if successful.
     */
    public Single<RestResponse<Void, Map<String, Integer>>> getReportWithRestResponseAsync(String qualifier) {
        return service.getReport(qualifier, this.acceptLanguage());
    }

    /**
     * Get test coverage report.
     *
     * @param qualifier If specified, qualifies the generated report further (e.g. '2.7' vs '3.5' in for Python). The only effect is, that generators that run all tests several times, can distinguish the generated reports.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return the {@link Maybe&lt;Map&lt;String, Integer&gt;&gt;} object if successful.
     */
    public Maybe<Map<String, Integer>> getReportAsync(String qualifier) {
        return getReportWithRestResponseAsync(qualifier)
            .flatMapMaybe(new Function<RestResponse<Void, Map<String, Integer>>, Maybe<Map<String, Integer>>>() {
                @Override
                public Maybe<Map<String, Integer>> apply(RestResponse<Void, Map<String, Integer>> restResponse) {
                    if (restResponse.body() == null) {
                        return Maybe.empty();
                    } else {
                        return Maybe.just(restResponse.body());
                    }
                }
            });
    }
}
