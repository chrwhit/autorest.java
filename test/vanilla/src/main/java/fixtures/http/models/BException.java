// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License. See License.txt in the project root for
// license information.
//
// Code generated by Microsoft (R) AutoRest Code Generator.
// Changes may cause incorrect behavior and will be lost if the code is
// regenerated.

package fixtures.http.models;

import com.azure.core.exception.HttpResponseException;
import com.azure.core.http.HttpResponse;

/**
 * Exception thrown for an invalid response with B information.
 */
public final class BException extends HttpResponseException {
    /**
     * Initializes a new instance of the BException class.
     *
     * @param message the exception message or the response content if a message is not available.
     * @param response the HTTP response.
     */
    public BException(String message, HttpResponse response) {
        super(message, response);
    }

    /**
     * Initializes a new instance of the BException class.
     *
     * @param message the exception message or the response content if a message is not available.
     * @param response the HTTP response.
     * @param value the deserialized response value.
     */
    public BException(String message, HttpResponse response, B value) {
        super(message, response, value);
    }

    @Override
    public B value() {
        return (B) super.value();
    }
}