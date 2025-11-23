package br.com.feSchulz.serializer;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class GenderSerializer  extends JsonSerializer<String> {
    @Override
    public void serialize(String gender, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {

        String formatedGender = "male".equalsIgnoreCase(gender) ? "M" : "F";
        jsonGenerator.writeString(formatedGender);
    }
}
