package com.example.SpringBootProject4.binding;

import java.time.LocalDate;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name = "StudentCourses" ,uniqueConstraints = {@UniqueConstraint(columnNames = { "student_id", "course_id" })})
public class StudentCourses {
	 
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

	@ManyToOne
	@JoinColumn(name = "student_id")  //nullable=false
	private Students students;

	@ManyToOne
	@JoinColumn(name = "course_id")
	private Courses courses;

	@Column(name = "start_date")
	@NotNull
	private LocalDate startDate;

	@Column(name = "end_date")
	@NotNull
	private LocalDate endDate;

	@Column(name = "stud_score")
	@NotNull
	private Integer studScore;

	public StudentCourses() {
	    super();
	}

	public StudentCourses(Long id, @NotNull Students students, @NotNull Courses courses,
	                      @NotNull LocalDate startDate, @NotNull LocalDate endDate, @NotNull Integer studScore) {
	    super();
	    this.id = id;
	    this.students = students;
	    this.courses = courses;
	    this.startDate = startDate;
	    this.endDate = endDate;
	    this.studScore = studScore;
	}


	public Long getId()
	{
		return id;
	}

	public void setId(Long id) 
	{
		this.id = id;
	}

	public Students getStudent() 
	{
		return students;
	}

	public void setStudent(Students students) 
	{
		this.students = students;
	}

	public Courses getCourse() {
		return courses;
	}

	public void setCourse(Courses courses) 
	{
		this.courses = courses;
	}

	public LocalDate getStartDate() 
	{
		return startDate;
	}

	public void setStartDate(LocalDate startDate) 
	{
		this.startDate = startDate;
	}

	public LocalDate getEndDate() 
	{
		return endDate;
	}

	public void setEndDate(LocalDate endDate) 
	{
		this.endDate = endDate;
	}

	public Integer getStudScore() 
	{
		return studScore;
	}

	public void setStudScore(Integer studScore) 
	{
		this.studScore = studScore;
	}

}
