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

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

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
			userRepository.saveAll(Arrays.asList(user1, user2));
			Post post1 = new Post(user1, "this is a title", "this is content!");
			Post post2 = new Post(user2, "Cats: Why they're so cool!", "this is content!");
			postRepository.saveAll(Arrays.asList(post1, post2));
			userRepository.deleteById(1L);
		};
	}
}
