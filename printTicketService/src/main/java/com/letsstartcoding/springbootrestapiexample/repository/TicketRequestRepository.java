package com.letsstartcoding.springbootrestapiexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.letsstartcoding.springbootrestapiexample.model.TicketRequest;

public interface TicketRequestRepository extends JpaRepository<TicketRequest, Long> {

}
