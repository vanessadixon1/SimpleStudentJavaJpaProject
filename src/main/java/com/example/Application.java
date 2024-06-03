package com.example.ei;

import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
//JPQL Java persistence Query Language this is under the hood of Jpa
//    @Query() allow me to override the query and make a custom query
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentJpa, StudentCardRepository studentCardRepo ) {
        return args -> {

            Faker faker = new Faker();
            Student student = new Student(faker.name().firstName(),
                    faker.name().lastName(),
                    faker.number().numberBetween(18, 21));
//
            String cardId = "1235888898";

//            student.addEnrolment(new Enrolment(new EnrolmentId(Long.valueOf(cardId), 5L),student,
//                    new Course("Python Programming I", "Computer Science Department")));
//            student.addEnrolment(new Enrolment(new EnrolmentId(1L, 2L, LocalDateTime.now()),student,
//                    new Course("Spring Data JPA", "Computer Science Department")));
            student.addEnrolment(new Enrolment(new EnrolmentId(2L, 1L),
                    student, new Course("Java", "IT Department"), LocalDateTime.now()));
            studentJpa.save(student);

//            StudentIdCard studentIdCard = new StudentIdCard(cardId, student);
//            studentCardRepo.save(studentIdCard);


////            Student stud = studentJpa.getStudentById(8L);
////            StudentIdCard studentIdCard = new StudentIdCard("12465", stud);
////            studentCardRepo.save(studentIdCard);
////            System.out.println(stud);
//
////            studentJpa.deleteStudentById(3L);
//
////            for(int i = 0; i < 10; i++) {
////                StudentIdCard studentIdCard = new StudentIdCard(Integer.toString((int) (Math.random() * 30 - 1 + 1)),
////                        new Student(faker.name().firstName(), faker.name().lastName(),faker.number().numberBetween(40, 62)));
////                studentCardRepo.save(studentIdCard);
////            }
//
//            Student student = new Student(faker.name().firstName(), faker.name().lastName(), faker.number().numberBetween(50, 55));
//            student.addBook(new Book("Cat and Jane", LocalDateTime.now().minusDays(4)));
//            student.addBook(new Book("hat boo", LocalDateTime.now()));
//            studentJpa.save(student);
//




//            List<Student> studentList = new ArrayList<>();
//            Long i = 10L;
//
//            while (i < 21) {
//                studentList.add(studentJpa.getStudentById(i));
//                i+= 1;
//            }
//            System.out.println(studentList);
//
//
//            for (Student student : studentList) {
//                StudentIdCard studentIdCard = new StudentIdCard(Integer.toString((int) (Math.random() * 30 - 1 + 1)) + "10000000000000", student);
//                studentCardRepo.save(studentIdCard);




//            Student maria = new Student("Vanessa", "Jackson", 19);
//            Student yorkie = new Student("Yorkie", "Martin", 20);
//            Student martha = new Student("Martha", "Perry", 21);
//            List<Student> students = new ArrayList<>(List.of(maria, yorkie, martha));
//            studentJpa.saveAll(students);
//            Faker faker = new Faker();
//            for(int i = 0; i < 30; i++) {
//                Student student =  new Student(faker.name().firstName(), faker.name().lastName(), faker.number().numberBetween(50, 70));
//                studentJpa.save(student);
//            }

//            System.out.println(studentJpa.findStudentsByAgeBetween(19, 19));
//            System.out.println(studentJpa.findStudentsByAgeBetween(2,15));
//            System.out.println(studentJpa.deleteById(1L));
//            List<Student> students = new ArrayList<>();
//            List<Sort.Order> order = new ArrayList<>();

//            studentJpa.findAll(Sort.by(Sort.Direction.DESC, "lastName")).forEach(student -> System.out.println(student.getLastName()));

//            PageRequest pageRequest = PageRequest.of(0, 5, Sort.by(Sort.Direction.DESC, "lastName"));
//
//            Page<Student> page = studentJpa.findAll(pageRequest);
////
//            int currentPage = pageRequest.getPageNumber();
//            int totalPages = page.getTotalPages();
//
//
//            while(!page.isEmpty()) {
//
//                page.getContent().forEach(System.out::println);
//
//                if(page.hasNext()) {
//                   pageRequest = (PageRequest) page.nextPageable();
//                   page = studentJpa.findAll(pageRequest);
//                } else {
//                    break;
//                }
//            }

        };
    }

}
