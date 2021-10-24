package br.com.fiap.epictask.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
public class Task {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "{error.task.title.blank}")
	private String title;
	
	@Size(min = 10, message = "A descrição deve ter pelo menos 10 caracteres")
	private String description;
	
	@Min(value=1, message = "A pontuação deve ser maior que 1")
	@Max(value=10, message = "A pontuação deve ser menos que 10")
	private int points;
	
	@Min(value=1, message = "O valor deve ser maior ou igual a 1")
	@Max(value=1000, message = "O valor deve ser menor ou igual a 1000")
	private int status;
	
	@ManyToOne
	private User user;

}
