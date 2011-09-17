package com.ideas.utils;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.deser.CustomDeserializerFactory;
import org.codehaus.jackson.map.deser.StdDeserializerProvider;
import org.codehaus.jackson.map.ser.CustomSerializerFactory;

/**
 * Factory for configuring Jackson to use all our custom settings, serializers, and deserializers.
 * This is also very performant because the ObjectMapper is thread-safe
 */
public class JSONObjectMapper
{
    private static final JSONObjectMapper instance = new JSONObjectMapper();
    private final ObjectMapper defaultOm = new ObjectMapper();

    private JSONObjectMapper()
    {

        //custom serializers
        CustomSerializerFactory csf = new CustomSerializerFactory();
        getDefaultOm().setSerializerFactory(csf);

        //custom deserializers
        CustomDeserializerFactory cdsf = new CustomDeserializerFactory();

        StdDeserializerProvider sdp = new StdDeserializerProvider(cdsf);

        getDefaultOm().setDeserializerProvider(sdp);

        getDefaultOm().configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        getDefaultOm().configure(SerializationConfig.Feature.AUTO_DETECT_GETTERS, false);
        getDefaultOm().configure(SerializationConfig.Feature.AUTO_DETECT_IS_GETTERS, false);
        getDefaultOm().setVisibilityChecker(
                getDefaultOm().getVisibilityChecker().withFieldVisibility(JsonAutoDetect.Visibility.ANY)
                                           );

        getDefaultOm().configure(SerializationConfig.Feature.WRITE_ENUMS_USING_TO_STRING, true);
        getDefaultOm().configure(DeserializationConfig.Feature.READ_ENUMS_USING_TO_STRING, true);

    }

    public static JSONObjectMapper getInstance()
    {
        return instance;
    }

    public ObjectMapper createDefaultObjectMapper()
    {
        return defaultOm;
    }

    private ObjectMapper getDefaultOm()
    {
        return defaultOm;
    }
}
