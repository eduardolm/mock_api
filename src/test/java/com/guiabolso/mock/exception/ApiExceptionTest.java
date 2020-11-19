package com.guiabolso.mock.exception;

import com.guiabolso.mock.helper.ApiExceptionParameterResolver;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

@ExtendWith(ApiExceptionParameterResolver.class)
public class ApiExceptionTest {

    @Test
    public void testEmptyConstructor(){
        ApiException apiException = new ApiException();

        assertNotNull(apiException);
    }

    @Test
    public void testOverloadedConstructor(ApiException apiException) {
        ApiException apiException1 = new ApiException(apiException.getHttpStatus(),
                apiException.getMessage(),
                apiException.getErrors());

        assertNotNull(apiException1);
    }
}
