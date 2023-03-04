package com.flexpag.agendarpagamento.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.flexpag.agendarpagamento.entities.Payment;
import com.flexpag.agendarpagamento.entities.Schedule;
import com.flexpag.agendarpagamento.entities.User;
import com.flexpag.agendarpagamento.entities.enums.ScheduleStatus;
//import com.flexpag.agendarpagamento.entities.enums.ScheduleStatus;
import com.flexpag.agendarpagamento.repositories.PaymentRepository;
import com.flexpag.agendarpagamento.repositories.ScheduleRepository;
import com.flexpag.agendarpagamento.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	//Instanciando as injeções de dependência
	@Autowired
	private PaymentRepository paymentRepository;
	@Autowired
	private ScheduleRepository scheduleRepository;
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		
		
		
		
		
		User user1= new User(null,"Túlius","012104505");
		User user2= new User(null,"Djalma","135649875");
		
		Payment pay1= new Payment(1L,"Bradesco",150.50,Instant.parse("2020-06-20T19:50:07Z"),user1);
		Payment pay2= new Payment(2L,"Itaú",420.50,Instant.parse("2021-03-16T12:10:07Z"),user2);
		
		Schedule schedule1= new Schedule(1L,ScheduleStatus.PAID,Instant.parse("2020-06-20T19:50:07Z"),
				user1,pay1);
		Schedule schedule2= new Schedule(2L,ScheduleStatus.PENDING,Instant.parse("2020-06-20T19:50:07Z"),
				user2,pay2);
		
		
		pay1.setSchedule(schedule1);
		pay2.setSchedule(schedule2);
		userRepository.saveAll(Arrays.asList(user1,user2));
		paymentRepository.saveAll(Arrays.asList(pay1,pay2));
		scheduleRepository.saveAll(Arrays.asList(schedule1,schedule2));
		
	}
	
}
