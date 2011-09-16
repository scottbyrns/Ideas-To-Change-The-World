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
 * @author ryan
 */
public class JacksonFactory {
    private static final JacksonFactory instance = new JacksonFactory();
    private final ObjectMapper defaultOm = new ObjectMapper();

    private JacksonFactory() {

        //custom serializers
        CustomSerializerFactory csf = new CustomSerializerFactory();
//        csf.addSpecificMapping(URL.class, new URLJsonSerializer());
//        csf.addSpecificMapping(ReturnCode.class, new ReturnCodeJsonSerializer());
//        csf.addSpecificMapping(Date.class, new EpochDateJsonSerializer());
        defaultOm.setSerializerFactory(csf);

        //custom deserializers
        CustomDeserializerFactory cdsf = new CustomDeserializerFactory();
//        cdsf.addSpecificMapping(URL.class, new URLJsonDeserializer());
//        cdsf.addSpecificMapping(ReturnCode.class, new ReturnCodeJsonDeserializer());
//        cdsf.addSpecificMapping(Date.class, new DateJsonDeserializer());

        StdDeserializerProvider sdp = new StdDeserializerProvider(cdsf);

        defaultOm.setDeserializerProvider(sdp);

        defaultOm.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        defaultOm.configure(SerializationConfig.Feature.AUTO_DETECT_GETTERS, false);
        defaultOm.configure(SerializationConfig.Feature.AUTO_DETECT_IS_GETTERS, false);
        defaultOm.setVisibilityChecker(
                defaultOm.getVisibilityChecker().withFieldVisibility(JsonAutoDetect.Visibility.ANY));

        defaultOm.configure(SerializationConfig.Feature.WRITE_ENUMS_USING_TO_STRING, true);
        defaultOm.configure(DeserializationConfig.Feature.READ_ENUMS_USING_TO_STRING, true);

    }

    public static JacksonFactory getInstance() {
        return instance;
    }

    public ObjectMapper createDefaultObjectMapper() {
        return defaultOm;
    }
}
