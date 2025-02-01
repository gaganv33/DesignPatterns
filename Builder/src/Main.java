public class Main {
    public static void main(String[] args) {
        StudentDetails studentDetails = StudentDetails.builder()
                .studentFirstName("student first name")
                .studentLastName("student last name")
                .fatherName("father name")
                .motherName("mother name")
                .address("address")
                .grade(9)
                .section('A')
                .build();
        System.out.println(studentDetails);
    }
}