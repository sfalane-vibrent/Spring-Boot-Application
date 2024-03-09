package com.example.SpringBootProject4.binding;
import java.util.List;
import java.util.Set;
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
//Data
//@Table(name = "student")
public class Students 
{
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long studentId;
 
    @Column(name = "first_name")
    @NotNull
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "contact_no",unique=true)
    private String contact;

    @OneToMany(mappedBy = "students",cascade = CascadeType.REMOVE)  //Maintains referential integrity
    private List<StudentCourses> coursesCompleted;
    
    public Students() 
    {
		super();
	}

	public Students(Long studentId, String firstName, String lastName, String email, String contact,List<StudentCourses> coursesCompleted)
	{
	    this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.contact = contact;
		this.coursesCompleted = coursesCompleted;
	}

	public Long getStudentId() 
	{
		return studentId;
	}

	public void setStudentId(Long studentId) 
	{
		this.studentId = studentId;
	}

	public String getFirstName() 
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getContact()
	{
		return contact;
	}

	public void setContact(String contact)
	{
		this.contact = contact;
	}

	public List<StudentCourses> getCoursesCompleted()
	{
		return coursesCompleted;
	}

	public void setCoursesCompleted(List<StudentCourses> coursesCompleted) 
	{
		this.coursesCompleted = coursesCompleted;
	}

    
}



















/*{
"studentId":13,
"firstName":"Sejal",
"lastName":"Shinde",
"email": "sejal.shinde@gmail.com",
"contact": "9011234567"

}*/
/*{

"courseName":"Cyber Security",
"marksAllocated":150
}*/

/*"student": 
{
    "studentId": 2,
    "firstName":"Riya",
    "lastName":"Roy",
    "email":"riya.roy@gmail.com",
    "contact":"9876543212"
}*/




/*{

"student": 
{
    "studentId":13,
   "firstName":"Sakshi",
   "lastName":"Ugale",
   "email": "sakshi.ugale@gmail.com",
   "contact": "9823255064"
},

"course": 
{
    "courseId": 1,
    "CourseName":"Data Science",
    "marksAllocated":100
},

"startDate": "2023-10-01",
"endDate": "2024-03-01",
"studScore": 99
}*/


