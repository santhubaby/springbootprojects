package in.ashokit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import in.ashokit.model.Course;

@Service
public class Kafkaservice {
	
	

		@Autowired
		private KafkaTemplate<String, Course> kafkaTemplate;
		
		
		public String sendMessage(Course course)
		
		{
	
			kafkaTemplate.send("ashokit_topic_1", "course", course);
			return "Course message sent to kafka server";
		}
		
		
	}


