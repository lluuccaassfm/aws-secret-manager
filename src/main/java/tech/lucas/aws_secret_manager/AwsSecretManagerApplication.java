package tech.lucas.aws_secret_manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AwsSecretManagerApplication implements CommandLineRunner {

	@Autowired
	SecretManagerService secretManagerService;

	public static void main(String[] args) {
		SpringApplication.run(AwsSecretManagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Username from Secrets Manager: " + secretManagerService.getSecretValue("username"));
		System.out.println("Surname from Secrets Manager: " + secretManagerService.getSecretValue("surname"));
		System.out.println("Password from Secrets Manager: " + secretManagerService.getSecretValue("password"));
	}

}
