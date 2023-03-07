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
	private UserRepository userRepository;
	@Autowired
	private ScheduleRepository scheduleRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
			
		
		User user1= new User(null,"Túlius","012104505");
		User user2= new User(null,"Djalma","135649875");
		
		Payment pay1= new Payment(1L,"Bradesco",150.50,Instant.parse("2020-06-20T19:50:07Z"),user1);
		Payment pay2= new Payment(2L,"Itaú",420.50,Instant.parse("2021-03-16T12:10:07Z"),user2);
		Payment pay3= new Payment(2L,"Banco do Brasil",420.50,Instant.parse("2022-03-16T12:10:07Z"),user2);
	
		
		userRepository.saveAll(Arrays.asList(user1,user2));
		paymentRepository.saveAll(Arrays.asList(pay1,pay2,pay3));
		
		
		/*Schedule schedule1 = new Schedule(null,ScheduleStatus.PENDING, Instant.parse("2020-06-20T19:50:07Z"),user1,pay2);
		Schedule schedule2 = new Schedule(null,ScheduleStatus.PAID, Instant.parse("2021-06-20T19:50:07Z"),user2,pay1);
		Schedule schedule3 = new Schedule(null,ScheduleStatus.PAID, Instant.parse("2021-06-20T19:50:07Z"),user2,pay1);*/
		
		Schedule schedule1 = new Schedule(null,ScheduleStatus.PENDING, Instant.parse("2020-06-20T19:50:07Z"),user1,pay1);
		Schedule schedule2 = new Schedule(null,ScheduleStatus.PAID, Instant.parse("2021-06-20T19:50:07Z"),user1,pay1);
		Schedule schedule3 = new Schedule(null,ScheduleStatus.PAID, Instant.parse("2021-06-20T19:50:07Z"),user2,pay2);
		scheduleRepository.saveAll(Arrays.asList(schedule1,schedule2,schedule3));
		
	}
	
}
