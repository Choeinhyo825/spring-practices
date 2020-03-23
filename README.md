# spring-practices

xml config
  1) 암시적(implicity) 설정  
	- Auto Scanning, Annotation Scanning  
	- 설정파일(<context:annotation-config />)   
		Bean Class(@Component, @Controller, @Service, Repository, @Autowired, @Named)  

  2) 명시적(explicity) 설정  
	- 설정파일 <bean></bean>  
java config  
  1) 암시적(implicity) 설정  
	- Auto Scanning, Annotation Scanning  
	- 설정파일(@Configuration, @ComponentScan)  
		Bean Class(@Component, @Controller, @Service, Repository, @Autowired, @Named)  

  2) 명시적(explicity) 설정  
	- 설정파일 (@Configuration, @Bean, @Qualifire)  
	
1. Spring Container 예제 Package  
  src/main/java  
	com.douzone.container.test  
	     └───── JavaConfig.java  
	     └───── XmlConfig.java  
	com.douzone.container.user  
	     └───── User1.java  
	     └───── USer.java  
	     └───── Friend.java  
	config.user  
	     └───── AppConfig01.xml  
	     └───── AppConfig02.xml  

  src/test/java  
	com.douzone.container.user  
	     └───── JavaConfigTest.java  
	     └───── XmlConfigTest.java  

  src/main/resources  
	config.user   
	     └───── applicationContext01.xml ( Auto Configuration, Annotation Scanning )  
	     └───── applicationContext02.xml ( Bran Configuration, implicit Configuration )  

2-1. Bean Wiring 예제 : 암시적 설정(auto scanning) Package  
  src/main/java  
	com.douzone.container.soundsystem  
	     └───── CompactDisc.java  
	     └───── HightSchoolRapper3.java  
	     └───── CDPlayer.java  
	config.soundsystem  
	     └───── CDPlaterConfig.java (Java Config)  

  src/test/java  
	com.douzone.container.soundsystem  
	     └───── CDPlayerJavaConfigTest.java  
	     └───── CDPlayerXmlConfigTest.java  

  src/main/resources  
	config.soundsystem  
	     └───── CDPlayerConfig.xml (XML Config)  

2-2. Bean Wiring 예제 : 명시적 설정 Package  







