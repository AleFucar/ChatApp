package it.fucarino.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.fucarino.model.Chat;

public interface ChatRepository extends JpaRepository<Chat, Integer> {

}
