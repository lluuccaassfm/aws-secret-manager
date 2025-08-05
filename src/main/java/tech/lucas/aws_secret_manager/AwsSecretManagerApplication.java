package tech.lucas.aws_secret_manager;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AwsSecretManagerApplication implements CommandLineRunner {

	@Value("${db.username}")
	private String username;

	@Value("${db.surname}")
	private String surname;

	@Value("${db.password}")
	private String password;

	public static void main(String[] args) {
		SpringApplication.run(AwsSecretManagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Username from Secrets Manager: " + username);
		System.out.println("Surname from Secrets Manager: " + surname);
		System.out.println("Password from Secrets Manager: " + password);
	}

}
