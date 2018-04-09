package mybatis.services;

import org.springframework.stereotype.Service;

@Service
public class SecurityLanguageService {

    public static String generateApiKey(int length) throws NoSuchAlgorithmException {

        SecureRandom random = new SecureRandom();

    }

}
