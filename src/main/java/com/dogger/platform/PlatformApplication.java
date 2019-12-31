package com.dogger.platform;

import com.dogger.platform.domain.Post;
import com.dogger.platform.domain.PostRepository;
import com.dogger.platform.domain.User;
import com.dogger.platform.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PlatformApplication {
    @Autowired
	private UserRepository userRepository;
	@Autowired
	private PostRepository postRepository;

	public static void main(String[] args) {
		SpringApplication.run(PlatformApplication.class, args);
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
		    User user1 = new User("nick", "nick@plusqa.com");
			User user2 = new User("macaroni", "macaroni@plusqa.com");
			userRepository.save(user1);
			userRepository.save(user2);
			postRepository.save(
					new Post(user1, "this is a title", "this is content!")
			);
		};
	}
}
