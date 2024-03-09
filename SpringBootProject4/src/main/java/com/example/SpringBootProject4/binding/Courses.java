package com.example.SpringBootProject4.binding;

import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
//@Table(name = "course")
public class Courses {
	
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Long courseId;

    @Column(name = "course_name", unique = true)
    @NotNull
    private String courseName;

    @Column(name = "Marks_Allocated")
    private Integer marksAllocated;

    @OneToMany(mappedBy = "courses")
    private List<StudentCourses> studentCourses;
    
    public Courses() 
	{
		super();
	}

	public Courses(Long courseId, @NotNull String courseName, Integer marksAllocated,List<StudentCourses> studentCourses) 
	{
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.marksAllocated = marksAllocated;
		this.studentCourses = studentCourses;
	}

	public Long getCourseId()
	{
		return courseId;
	}

	public void setCourseId(Long courseId) 
	{
		this.courseId = courseId;
	}

	public String getCourseName()
	{
		return courseName;
	}

	public void setCourseName(String courseName) 
	{
		this.courseName = courseName;
	}

	public Integer getMarksAllocated()
	{
		return marksAllocated;
	}

	public void setMarksAllocated(Integer marksAllocated) 
	{
		this.marksAllocated = marksAllocated;
	}

	public List<StudentCourses> getStudentCourses() 
	{
		return studentCourses;
	}

	public void setStudentCourses(List<StudentCourses> studentCourses)
	{
		this.studentCourses = studentCourses;
	}

 
}
