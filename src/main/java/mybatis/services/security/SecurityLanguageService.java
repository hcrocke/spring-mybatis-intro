package mybatis.services.security;

import org.springframework.stereotype.Service;

import javax.xml.bind.DatatypeConverter;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

@Service
public class SecurityLanguageService {

    public static String generateApiKey(int length) throws NoSuchAlgorithmException {

        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[length/8];
        random.nextBytes(bytes);

        return DatatypeConverter.printHexBinary(bytes).toLowerCase();
    }

    public boolean authenticateApiKey(String apiKey) {

        return false;
    }

}
