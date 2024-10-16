package it.fucarino.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.fucarino.model.Message;

public interface MessageRepository extends JpaRepository<Message, Integer> {
}
