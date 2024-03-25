import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
public class PoeticEndpointApplication {

    private Map<String, String> poeticData = new HashMap<>();

    public static void main(String[] args) {
        SpringApplication.run(PoeticEndpointApplication.class, args);
    }

    @PutMapping("/soratra/{id}")
    public ResponseEntity<Void> putPoeticData(@PathVariable String id, @RequestBody String poeticPhrase) {
        poeticData.put(id, poeticPhrase.toLowerCase());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/soratra/{id}")
    public ResponseEntity<Map<String, String>> getPoeticData(@PathVariable String id) {
        if (!poeticData.containsKey(id)) {
            return ResponseEntity.notFound().build();
        }

        String originalPhrase = poeticData.get(id);
        String transformedPhrase = originalPhrase.toUpperCase();

        Map<String, String> result = new HashMap<>();
        result.put("original_url", "https://original.url"); // Placeholder for original URL
        result.put("transformed_url", "https://transformed.url"); // Placeholder for transformed URL

        return ResponseEntity.ok(result);
    }
}
original.url