package config.videosystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.douzone.container.videosystem.Avengers;
import com.douzone.container.videosystem.DVDPlayer;

@Configuration
public class DVDPlayerConfig {
	
	@Bean
	public Avengers avengers() {
		return new Avengers();
	}
	// 주입하기 1 : Bean 생성 메소드 직접 호출
	@Bean
	public DVDPlayer dvdPlayer() {
		return new DVDPlayer(avengers());
	}
}
