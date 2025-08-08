package tech.lucas.aws_secret_manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class SecretManagerService {

    @Value("${spring.config.secret-prefix}")
    String secretPrefix;

    @Autowired
    private ApplicationContext context;

    public String getSecretValue(String propertyName) {
        try {
            return context.getEnvironment().getProperty(secretPrefix.concat(".").concat(propertyName));
        } catch (Exception e) {
            System.err.println("Error retrieving property '" + propertyName + "': " + e.getMessage());
            return null;
        }
    }
}
