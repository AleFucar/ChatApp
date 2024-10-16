package it.fucarino.model;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "message")
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "chat_id")
	private Chat chat;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@Column
	private String text;
	
	@Column
	private LocalDate date;
	
	@Column
	private Time time;
}
