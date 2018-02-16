/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package fixtures.xml.implementation;

import com.microsoft.rest.v2.RestProxy;
import com.microsoft.rest.v2.RestResponse;
import com.microsoft.rest.v2.ServiceCallback;
import com.microsoft.rest.v2.ServiceFuture;
import com.microsoft.rest.v2.Validator;
import com.microsoft.rest.v2.annotations.BodyParam;
import com.microsoft.rest.v2.annotations.ExpectedResponses;
import com.microsoft.rest.v2.annotations.GET;
import com.microsoft.rest.v2.annotations.Host;
import com.microsoft.rest.v2.annotations.PUT;
import com.microsoft.rest.v2.annotations.UnexpectedResponseExceptionType;
import fixtures.xml.Xmls;
import fixtures.xml.models.AppleBarrel;
import fixtures.xml.models.ErrorException;
import fixtures.xml.models.Slideshow;
import fixtures.xml.models.XmlGetHeadersHeaders;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * An instance of this class provides access to all the operations defined in
 * Xmls.
 */
public final class XmlsImpl implements Xmls {
    /**
     * The proxy service used to perform REST calls.
     */
    private XmlsService service;

    /**
     * The service client containing this operation class.
     */
    private AutoRestSwaggerBATXMLServiceImpl client;

    /**
     * Initializes an instance of XmlsImpl.
     *
     * @param client the instance of the service client containing this operation class.
     */
    public XmlsImpl(AutoRestSwaggerBATXMLServiceImpl client) {
        this.service = RestProxy.create(XmlsService.class, client);
        this.client = client;
    }

    /**
     * The interface defining all the services for Xmls to be used by the proxy
     * service to perform REST calls.
     */
    @Host("http://localhost")
    private interface XmlsService {
        @GET("xml/simple")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(ErrorException.class)
        Single<RestResponse<Void, Slideshow>> getSimple();

        @PUT("xml/simple")
        @ExpectedResponses({201})
        @UnexpectedResponseExceptionType(ErrorException.class)
        Single<RestResponse<Void, Void>> putSimple(@BodyParam("application/xml; charset=utf-8") Slideshow wrappedLists);

        @GET("xml/wrapped-lists")
        @ExpectedResponses({200})
        Single<RestResponse<Void, AppleBarrel>> getWrappedLists();

        @PUT("xml/wrapped-lists")
        @ExpectedResponses({201})
        @UnexpectedResponseExceptionType(ErrorException.class)
        Single<RestResponse<Void, Void>> putWrappedLists(@BodyParam("application/xml; charset=utf-8") AppleBarrel wrappedLists);

        @GET("xml/headers")
        @ExpectedResponses({200})
        Single<RestResponse<XmlGetHeadersHeaders, Void>> getHeaders();
    }

    /**
     * Get a simple XML document.
     *
     * @throws ErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the Slideshow object if successful.
     */
    public Slideshow getSimple() {
        return getSimpleAsync().blockingGet();
    }

    /**
     * Get a simple XML document.
     *
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return the {@link ServiceFuture&lt;Slideshow&gt;} object.
     */
    public ServiceFuture<Slideshow> getSimpleAsync(ServiceCallback<Slideshow> serviceCallback) {
        return ServiceFuture.fromBody(getSimpleAsync(), serviceCallback);
    }

    /**
     * Get a simple XML document.
     *
     * @return the {@link Single&lt;RestResponse&lt;Void, Slideshow&gt;&gt;} object if successful.
     */
    public Single<RestResponse<Void, Slideshow>> getSimpleWithRestResponseAsync() {
        return service.getSimple();
    }

    /**
     * Get a simple XML document.
     *
     * @return the {@link Maybe&lt;Slideshow&gt;} object if successful.
     */
    public Maybe<Slideshow> getSimpleAsync() {
        return getSimpleWithRestResponseAsync()
            .flatMapMaybe(new Function<RestResponse<Void, Slideshow>, Maybe<Slideshow>>() {
                @Override
                public Maybe<Slideshow> apply(RestResponse<Void, Slideshow> restResponse) {
                    if (restResponse.body() == null) {
                        return Maybe.empty();
                    } else {
                        return Maybe.just(restResponse.body());
                    }
                }
            });
    }

    /**
     * Put a simple XML document.
     *
     * @param wrappedLists the Slideshow value.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    public void putSimple(@NonNull Slideshow wrappedLists) {
        putSimpleAsync(wrappedLists).blockingAwait();
    }

    /**
     * Put a simple XML document.
     *
     * @param wrappedLists the Slideshow value.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return the {@link ServiceFuture&lt;Void&gt;} object.
     */
    public ServiceFuture<Void> putSimpleAsync(@NonNull Slideshow wrappedLists, ServiceCallback<Void> serviceCallback) {
        return ServiceFuture.fromBody(putSimpleAsync(wrappedLists), serviceCallback);
    }

    /**
     * Put a simple XML document.
     *
     * @param wrappedLists the Slideshow value.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return the {@link Single&lt;RestResponse&lt;Void, Void&gt;&gt;} object if successful.
     */
    public Single<RestResponse<Void, Void>> putSimpleWithRestResponseAsync(@NonNull Slideshow wrappedLists) {
        if (wrappedLists == null) {
            throw new IllegalArgumentException("Parameter wrappedLists is required and cannot be null.");
        }
        Validator.validate(wrappedLists);
        return service.putSimple(wrappedLists);
    }

    /**
     * Put a simple XML document.
     *
     * @param wrappedLists the Slideshow value.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return the {@link Completable} object if successful.
     */
    public Completable putSimpleAsync(@NonNull Slideshow wrappedLists) {
        return putSimpleWithRestResponseAsync(wrappedLists)
            .toCompletable();
    }

    /**
     * Get an XML document with multiple wrapped lists.
     *
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the AppleBarrel object if successful.
     */
    public AppleBarrel getWrappedLists() {
        return getWrappedListsAsync().blockingGet();
    }

    /**
     * Get an XML document with multiple wrapped lists.
     *
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return the {@link ServiceFuture&lt;AppleBarrel&gt;} object.
     */
    public ServiceFuture<AppleBarrel> getWrappedListsAsync(ServiceCallback<AppleBarrel> serviceCallback) {
        return ServiceFuture.fromBody(getWrappedListsAsync(), serviceCallback);
    }

    /**
     * Get an XML document with multiple wrapped lists.
     *
     * @return the {@link Single&lt;RestResponse&lt;Void, AppleBarrel&gt;&gt;} object if successful.
     */
    public Single<RestResponse<Void, AppleBarrel>> getWrappedListsWithRestResponseAsync() {
        return service.getWrappedLists();
    }

    /**
     * Get an XML document with multiple wrapped lists.
     *
     * @return the {@link Maybe&lt;AppleBarrel&gt;} object if successful.
     */
    public Maybe<AppleBarrel> getWrappedListsAsync() {
        return getWrappedListsWithRestResponseAsync()
            .flatMapMaybe(new Function<RestResponse<Void, AppleBarrel>, Maybe<AppleBarrel>>() {
                @Override
                public Maybe<AppleBarrel> apply(RestResponse<Void, AppleBarrel> restResponse) {
                    if (restResponse.body() == null) {
                        return Maybe.empty();
                    } else {
                        return Maybe.just(restResponse.body());
                    }
                }
            });
    }

    /**
     * Put an XML document with multiple wrapped lists.
     *
     * @param wrappedLists the AppleBarrel value.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    public void putWrappedLists(@NonNull AppleBarrel wrappedLists) {
        putWrappedListsAsync(wrappedLists).blockingAwait();
    }

    /**
     * Put an XML document with multiple wrapped lists.
     *
     * @param wrappedLists the AppleBarrel value.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return the {@link ServiceFuture&lt;Void&gt;} object.
     */
    public ServiceFuture<Void> putWrappedListsAsync(@NonNull AppleBarrel wrappedLists, ServiceCallback<Void> serviceCallback) {
        return ServiceFuture.fromBody(putWrappedListsAsync(wrappedLists), serviceCallback);
    }

    /**
     * Put an XML document with multiple wrapped lists.
     *
     * @param wrappedLists the AppleBarrel value.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return the {@link Single&lt;RestResponse&lt;Void, Void&gt;&gt;} object if successful.
     */
    public Single<RestResponse<Void, Void>> putWrappedListsWithRestResponseAsync(@NonNull AppleBarrel wrappedLists) {
        if (wrappedLists == null) {
            throw new IllegalArgumentException("Parameter wrappedLists is required and cannot be null.");
        }
        Validator.validate(wrappedLists);
        return service.putWrappedLists(wrappedLists);
    }

    /**
     * Put an XML document with multiple wrapped lists.
     *
     * @param wrappedLists the AppleBarrel value.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return the {@link Completable} object if successful.
     */
    public Completable putWrappedListsAsync(@NonNull AppleBarrel wrappedLists) {
        return putWrappedListsWithRestResponseAsync(wrappedLists)
            .toCompletable();
    }

    /**
     * Get strongly-typed response headers.
     *
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    public void getHeaders() {
        getHeadersAsync().blockingAwait();
    }

    /**
     * Get strongly-typed response headers.
     *
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return the {@link ServiceFuture&lt;Void&gt;} object.
     */
    public ServiceFuture<Void> getHeadersAsync(ServiceCallback<Void> serviceCallback) {
        return ServiceFuture.fromBody(getHeadersAsync(), serviceCallback);
    }

    /**
     * Get strongly-typed response headers.
     *
     * @return the {@link Single&lt;RestResponse&lt;XmlGetHeadersHeaders, Void&gt;&gt;} object if successful.
     */
    public Single<RestResponse<XmlGetHeadersHeaders, Void>> getHeadersWithRestResponseAsync() {
        return service.getHeaders();
    }

    /**
     * Get strongly-typed response headers.
     *
     * @return the {@link Completable} object if successful.
     */
    public Completable getHeadersAsync() {
        return getHeadersWithRestResponseAsync()
            .toCompletable();
    }
}
