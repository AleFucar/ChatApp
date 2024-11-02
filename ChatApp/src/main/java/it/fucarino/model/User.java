package it.fucarino.model;

import java.time.LocalDateTime;

import java.util.List;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	@NotBlank
	private String username;
	
	@Column
	@NotBlank
	private String mail;
	
	@Column
	@NotBlank
	private String password;
	
	@Column
	@NotNull
	private LocalDateTime dataCreazione;
	
	@Column(name = "profile_photo")
	private String profilePhoto;

	@ManyToMany(fetch = FetchType.EAGER)
	private List<Role> roles;

    @ManyToMany
    @JoinTable(name = "user_chat", joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name = "chat_id"))
    private List<Chat> chats;
    
    
    @OneToMany(mappedBy = "user")
    private List<Message> message;
    
    public User() {
    	this.dataCreazione = dataCreazione.now();
    	}
    
    
	//	GETTER AND SETTER //
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDateTime getDataCreazione() {
		return dataCreazione;
	}

	public void setDataCreazione(LocalDateTime dataCreazione) {
		this.dataCreazione = dataCreazione.now();
	}

	public String getProfilePhoto() {
		return profilePhoto;
	}

	public void setProfilePhoto(String profilePhoto) {
		this.profilePhoto = profilePhoto;
	}

	public List<Chat> getChats() {
		return chats;
	}

	public void setChats(List<Chat> chats) {
		this.chats = chats;
	}


	public List<Role> getRoles() {
		return roles;
	}


	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}


	public List<Message> getMessage() {
		return message;
	}


	public void setMessage(List<Message> message) {
		this.message = message;
	}
	
	
	
	
	
}
