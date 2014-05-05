package com.serverapi.utilities;

public enum TechnionRankerFunctions {
  INSERT_COURSE("INSERT_COURSE"), GET_COURSE("GET_COURSE"), INSERT_PROFESSOR(
      "INSERT_PROFESSOR"), GET_PROFESSOR("GET_PROFESSOR"), INSERT_STUDENT_USER(
      "INSERT_STUDENT_USER"), GET_STUDENT_USER("GET_STUDENT_USER"),
  INSERT_STUDENT_PROFESSOR_COURSE("INSERT_STUDENT_PROFESSOR_COURSE"),
  GET_STUDENT_PROFESSOR_COURSE("GET_STUDENT_PROFESSOR_COURSE"),
  GET_STUDENT_PROFESSORS("GET_STUDENT_PROFESSORS"), GET_STUDENT_COURSES(
      "GET_STUDENT_COURSES"),
  INSERT_PROFESSOR_RATING("INSERT_PROFESSOR_RATING"),
  GET_PROFESSOR_RATING_BY_PROFESSOR("GET_PROFESSOR_RATING_BY_PROFESSOR"),
  GET_PROFESSOR_RATING_BY_STUDENT("GET_PROFESSOR_RATING_BY_STUDENT");

  private final String value;

  private TechnionRankerFunctions(String s) {
    value = s;
  }

  public String value() {
    return value;
  }
}