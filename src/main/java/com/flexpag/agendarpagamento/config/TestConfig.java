package com.flexpag.agendarpagamento.config;

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
		Payment pay1= new Payment(1L,"Bradesco","Túlius",150.50);
		Payment pay2= new Payment(2L,"Itaú","Túlius",420.50);
		
		paymentRepository.saveAll(Arrays.asList(pay1,pay2));
		
		LocalDate data01 = LocalDate.parse("2023-03-17");
		Date date= Date.from(data01.atStartOfDay(ZoneId.systemDefault()).toInstant());
		Schedule schedule1= new Schedule(1L,"pending",date);
		
		data01 = LocalDate.parse("2023-02-17");
		date= Date.from(data01.atStartOfDay(ZoneId.systemDefault()).toInstant());
		Schedule schedule2= new Schedule(2L,"paid",date);
		
		scheduleRepository.saveAll(Arrays.asList(schedule1,schedule2));
		
		User user1= new User(null,"Túlius","012104505");
		User user2= new User(null,"Djalma","135649875");
		
		userRepository.saveAll(Arrays.asList(user1,user2));
	}
	
}
