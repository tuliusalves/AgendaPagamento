package com.flexpag.agendarpagamento.controller;

import static org.assertj.core.api.BDDAssumptions.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.flexpag.agendarpagamento.controllers.SchedulesController;
import com.flexpag.agendarpagamento.entities.Payments;
import com.flexpag.agendarpagamento.entities.Schedules;
import com.flexpag.agendarpagamento.entities.Users;
import com.flexpag.agendarpagamento.entities.enums.ScheduleStatus;
import com.flexpag.agendarpagamento.services.SchedulesService;

@ExtendWith(MockitoExtension.class)
public class SchedulesControllerTest {

    @Mock
    private SchedulesService scheduleService;

    @InjectMocks
    private SchedulesController scheduleController;

    private static List<Schedules> mockScheduleEntities = new ArrayList<>();
    @BeforeAll
    public static void setUp() {
        Users user1 = new Users(null, "Túlius", "012104505");
        Users user2 = new Users(null, "Djalma", "135649875");

        Payments pay1 = new Payments(null, "Bradesco", 150.50, Instant.parse("2020-06-20T19:50:07Z"));
        Payments pay2 = new Payments(null, "Itaú", 420.50, Instant.parse("2021-03-16T12:10:07Z"));
        Payments pay3 = new Payments(null, "Banco do Brasil", 420.50, Instant.parse("2022-03-16T12:10:07Z"));

        mockScheduleEntities.add(new Schedules(null, ScheduleStatus.PENDING, Instant.parse("2020-06-20T19:50:07Z"), user1, pay1));
        mockScheduleEntities.add(new Schedules(null, ScheduleStatus.PAID, Instant.parse("2021-06-20T19:50:07Z"), user1,  pay1));
        mockScheduleEntities.add(new Schedules(null, ScheduleStatus.PAID, Instant.parse("2021-06-20T19:50:07Z"), user2, pay2));
    }




    @Test
    void testFindAll() {
        // Configura o comportamento simulado do serviço para retornar as entidades de agendamento simuladas
        when(scheduleService.findAll()).thenReturn(mockScheduleEntities);

        // Chama o método findAll() no controlador de agendamento
        ResponseEntity<List<Schedules>> response = scheduleController.findAll();

        // Verifica se a resposta tem o código de status HTTP correto (200 OK)
        assertEquals(200, response.getStatusCodeValue());

        // Verifica se a lista de entidades de agendamento na resposta é igual à lista simulada
        List<Schedules> scheduleEntities = response.getBody();
        assertEquals(mockScheduleEntities, scheduleEntities);
    }
    @Test
    public void testFindById() throws Exception {
        Users user1 = new Users(null, "Túlius", "012104505");

        Payments pay1 = new Payments(null, "Bradesco", 150.50, Instant.parse("2020-06-20T19:50:07Z"));


        Schedules schedule1 = new Schedules(null, ScheduleStatus.PENDING, Instant.parse("2020-06-20T19:50:07Z"), user1,
                pay1);
        // Simulate the call to the service
        when(scheduleService.findById(1L)).thenReturn(schedule1);

        // Call the controller method
        ResponseEntity<Schedules> responseEntity = scheduleController.findById(1l);

        // Verify the response
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(schedule1, responseEntity.getBody());
    }


}
