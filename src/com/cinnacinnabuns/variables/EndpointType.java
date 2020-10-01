package com.cinnacinnabuns.variables;

/**
 * Type constituted of the supported Endpoint types.
 * Use findEndpointType() to check if an object is of a supported type (unsupported returns null.)
 */
public enum EndpointType {

    //  Primitives and void
    BOOLEAN(Boolean.class),
    BYTE(Byte.class),
    SHORT(Short.class),
    INTEGER(Integer.class),
    LONG(Long.class),
    FLOAT(Float.class),
    DOUBLE(Double.class),
    CHARACTER(Character.class),
    VOID(Void.class),
    //  Other types marked as Endpoint
    STRING(String.class);

    Class<?> underlyingType;

    EndpointType(Class<?> underlyingType) {
        this.underlyingType = underlyingType;
    }

    public static EndpointType findEndpointType(Object object) {
        for (EndpointType endpointType : EndpointType.values()) {
            if (endpointType.underlyingType.isInstance(object)) {
                return endpointType;
            }
        }
        return null;
    }
}
