package com.zensar.Dto;

public class StudentDto {
		private int studId;
		private String studName;
		private int studAge;
		public StudentDto() {
			super();
		}
		public StudentDto(int studId, String studName, int studAge) {
			super();
			this.studId = studId;
			this.studName = studName;
			this.studAge = studAge;
		}
		public int getStudId() {
			return studId;
		}
		public void setStudId(int studId) {
			this.studId = studId;
		}
		public String getStudName() {
			return studName;
		}
		public void setStudName(String studName) {
			this.studName = studName;
		}
		public int getStudAge() {
			return studAge;
		}
		public void setStudAge(int studAge) {
			this.studAge = studAge;
		}
		@Override
		public String toString() {
			return "StudentDto [studId=" + studId + ", studName=" + studName + ", studAge=" + studAge + "]";
		}
		
	

}
