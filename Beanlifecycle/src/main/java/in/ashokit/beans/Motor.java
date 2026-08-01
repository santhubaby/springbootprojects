package in.ashokit.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

	@Service
	@Scope("prototype")
	public class Motor {

		public Motor() {
			System.out.println("Motor :: Constructor");
			
			System.out.println(this.getClass().getName());
			System.out.println(this);
			System.out.println(this.hashCode());


		}
		

		@PostConstruct
		public void start() {
			System.out.println("motor started...");
		}

		public void doWork() {
			System.out.println("Motor working...");
		}

		@PreDestroy
		public void stop() {
			System.out.println("motor stopped...");
		}

	}


