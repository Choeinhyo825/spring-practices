package config.videosystem.mixing;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/*
 * Explicit Configuration : Java Configuration
 * 
 * JavaConfig2 <--- {JavaConfig1} : import
 * 	[JavaConfig2 + JavaConfig1]
 * 
 */
@Configuration
@Import({ DVDConfig.class, DVDPlayerConfig.class})
public class VideoSystemConfig {

}
