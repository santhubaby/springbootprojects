package in.ashokit.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import in.ashokit.model.Course;

@Service
public class Kafkaconsumerservice {

	
	

		private String message;
		
		@KafkaListener(topics= "ashokit_topic_1" , groupId = "ashokit-group")
		public void consume(Course course)
		{
			message = course + " Got the data from kafka";
			System.out.println(message);
			
		}

		public String getMessage() {
			return message;
		}

		
		
		
		
		
	}

