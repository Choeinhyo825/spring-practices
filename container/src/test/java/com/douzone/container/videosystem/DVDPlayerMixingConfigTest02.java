package com.douzone.container.videosystem;

import static org.junit.Assert.assertNotNull;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.videosystem.mixing.DVDConfig;
import config.videosystem.mixing.DVDPlayerConfig;
import config.videosystem.mixing.VideoSystemConfig;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {DVDConfig.class, DVDPlayerConfig.class})
@ContextConfiguration(classes = VideoSystemConfig.class)
public class DVDPlayerMixingConfigTest02 {
	@Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
	
	@Autowired
	private DVDPlayer player;
	
	@Test
	public void testPlayerNotNull() {
		assertNotNull(player);
	}

}
