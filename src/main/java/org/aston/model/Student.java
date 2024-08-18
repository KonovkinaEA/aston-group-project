package org.aston.model;

public final class Student extends BaseEntity {
    private final String groupNumber;
    private final double averageGrade;
    private final String recordBookNumber;

    private Student(Builder builder) {
        this.groupNumber = builder.groupNumber;
        this.averageGrade = builder.averageGrade;
        this.recordBookNumber = builder.recordBookNumber;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public String getRecordBookNumber() {
        return recordBookNumber;
    }

    public static class Builder {
        private String groupNumber;
        private double averageGrade;
        private String recordBookNumber;

        public Builder setGroupNumber(String groupNumber) {
            this.groupNumber = groupNumber;
            return this;
        }

        public Builder setAverageGrade(double averageGrade) {
            this.averageGrade = averageGrade;
            return this;
        }

        public Builder setRecordBookNumber(String recordBookNumber) {
            this.recordBookNumber = recordBookNumber;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }

    @Override
    public String toString() {
        return "Student(" +
                "groupNumber=" + groupNumber +
                ", averageGrade=" + averageGrade +
                ", recordBookNumber=" + recordBookNumber +
                ')';
    }
}
