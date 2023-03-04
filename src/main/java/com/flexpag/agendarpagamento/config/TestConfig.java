package com.flexpag.agendarpagamento.config;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.flexpag.agendarpagamento.entities.Payment;
import com.flexpag.agendarpagamento.entities.Schedule;
import com.flexpag.agendarpagamento.entities.User;
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
		
		user1.getPayments(pay1);
		user2.getPayments(pay2);
		
		LocalDate data01 = LocalDate.parse("2023-03-17");
		Date date= Date.from(data01.atStartOfDay(ZoneId.systemDefault()).toInstant());
		Schedule schedule1= new Schedule(1L,false,date, user1);
		
		data01 = LocalDate.parse("2023-02-17");
		date= Date.from(data01.atStartOfDay(ZoneId.systemDefault()).toInstant());
		Schedule schedule2= new Schedule(2L,true,date,user2);
		
		userRepository.saveAll(Arrays.asList(user1,user2));
		scheduleRepository.saveAll(Arrays.asList(schedule1,schedule2));
		paymentRepository.saveAll(Arrays.asList(pay1,pay2));
	}
	
}
