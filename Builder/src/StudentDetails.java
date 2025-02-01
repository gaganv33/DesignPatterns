public class StudentDetails {
    private final String studentFirstName;
    private final String studentLastName;
    private final String fatherName;
    private final String motherName;
    private final String address;
    private final Integer grade;
    private final Character section;

    private StudentDetails(Builder builder) {
        this.studentFirstName = builder.studentFirstName;
        this.studentLastName = builder.studentLastName;
        this.fatherName = builder.fatherName;
        this.motherName = builder.motherName;
        this.address = builder.address;
        this.grade = builder.grade;
        this.section = builder.section;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "StudentDetails{" +
                "studentFirstName='" + studentFirstName + '\'' +
                ", studentLastName='" + studentLastName + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", motherName='" + motherName + '\'' +
                ", address='" + address + '\'' +
                ", grade=" + grade +
                ", section=" + section +
                '}';
    }

    public static class Builder {
        private String studentFirstName;
        private String studentLastName;
        private String fatherName;
        private String motherName;
        private String address;
        private Integer grade;
        private Character section;

        public Builder studentFirstName(String studentFirstName) {
            this.studentFirstName = studentFirstName;
            return this;
        }
        public Builder studentLastName(String studentLastName) {
            this.studentLastName = studentLastName;
            return this;
        }
        public Builder fatherName(String fatherName) {
            this.fatherName = fatherName;
            return this;
        }
        public Builder motherName(String motherName) {
            this.motherName = motherName;
            return this;
        }
        public Builder address(String address) {
            this.address = address;
            return this;
        }
        public Builder grade(Integer grade) {
            this.grade = grade;
            return this;
        }
        public Builder section(Character section) {
            this.section = section;
            return this;
        }
        public StudentDetails build() {
            return new StudentDetails(this);
        }
    }
}
