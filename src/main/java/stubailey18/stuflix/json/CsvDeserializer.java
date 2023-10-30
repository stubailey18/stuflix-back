package stubailey18.stuflix.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.util.Arrays;

public class CsvDeserializer extends JsonDeserializer<String[]> {

    @Override
    public String[] deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        var array = jsonParser.getText().split(",");
        return Arrays.stream(array).map(String::trim).toArray(String[]::new);
    }
}
