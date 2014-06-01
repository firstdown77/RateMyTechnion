package com.serverapi;

import java.util.List;

import com.serverapi.communicator.Communicator;
import com.technionrankerv1.Course;
import com.technionrankerv1.CourseComment;
import com.technionrankerv1.CourseRating;
import com.technionrankerv1.Professor;
import com.technionrankerv1.ProfessorComment;
import com.technionrankerv1.ProfessorRating;
import com.technionrankerv1.StudentProfessorCourse;
import com.technionrankerv1.StudentUser;
import com.serverapi.utilities.TechnionRankerFunctions;
import com.serverapi.utilities.TechnionRankerReturnCodes;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class TechnionRankerAPI implements ITechnionRankerAPI {
  Gson gson = new Gson();
  String servlet = TechnionRankerFunctions.SERVLET.value();
  String function = TechnionRankerFunctions.FUNCTION.value();
  String course = TechnionRankerFunctions.COURSE.value();
  String professor = TechnionRankerFunctions.PROFESSOR.value();
  String professorRating = TechnionRankerFunctions.PROFESSOR_RATING.value();
  String studentUser = TechnionRankerFunctions.STUDENT_USER.value();
  String studentProfessorCourse = TechnionRankerFunctions.STUDENT_PROFESSOR_COURSE
      .value();
  String courseRating = TechnionRankerFunctions.COURSE_RATING.value();
  String professorComment = TechnionRankerFunctions.PROFESSOR_COMMENT.value();
  String courseComment = TechnionRankerFunctions.COURSE_COMMENT.value();

  @Override
  public TechnionRankerReturnCodes insertCourse(Course c) {
    return TechnionRankerReturnCodes.valueOf(Communicator.execute(servlet,
        function, TechnionRankerFunctions.INSERT_COURSE.value(), course,
        gson.toJson(c)));
  }

  @Override
  public Course getCourse(Course c) {
    return gson.fromJson(Communicator.execute(servlet, function,
        TechnionRankerFunctions.GET_COURSE.value(), course, gson.toJson(c)),
        Course.class);
  }

  @Override
  public TechnionRankerReturnCodes removeCourse(Course c) {
    return TechnionRankerReturnCodes.valueOf(Communicator.execute(servlet,
        function, TechnionRankerFunctions.REMOVE_COURSE.value(), course,
        gson.toJson(c)));
  }

  @Override
  public TechnionRankerReturnCodes dropAllCourses() {
    return TechnionRankerReturnCodes.valueOf(Communicator.execute(servlet,
        function, TechnionRankerFunctions.DROP_ALL_COURSES.value()));
  }

  @Override
  public TechnionRankerReturnCodes insertProfessor(Professor p) {
    return TechnionRankerReturnCodes.valueOf(Communicator.execute(servlet,
        function, TechnionRankerFunctions.INSERT_PROFESSOR.value(), professor,
        gson.toJson(p)));
  }

  @Override
  public TechnionRankerReturnCodes removeProfessor(Professor p) {
    return TechnionRankerReturnCodes.valueOf(Communicator.execute(servlet,
        function, TechnionRankerFunctions.REMOVE_PROFESSOR.value(), professor,
        gson.toJson(p)));
  }

  @Override
  public TechnionRankerReturnCodes dropAllProfessors() {
    return TechnionRankerReturnCodes.valueOf(Communicator.execute(servlet,
        function, TechnionRankerFunctions.DROP_ALL_PROFESSORS.value()));
  }

  @Override
  public Professor getProfessor(Professor p) {
    return gson.fromJson(Communicator.execute(servlet, function,
        TechnionRankerFunctions.GET_PROFESSOR.value(), professor,
        gson.toJson(p)), Professor.class);
  }

  @Override
  public TechnionRankerReturnCodes insertStudentUser(StudentUser s) {
    return TechnionRankerReturnCodes.valueOf(Communicator.execute(servlet,
        function, TechnionRankerFunctions.INSERT_STUDENT_USER.value(),
        studentUser, gson.toJson(s)));
  }

  @Override
  public StudentUser getStudentUser(StudentUser s) {
    return gson.fromJson(Communicator.execute(servlet, function,
        TechnionRankerFunctions.GET_STUDENT_USER.value(), studentUser,
        gson.toJson(s)), StudentUser.class);
  }

  @Override
  public TechnionRankerReturnCodes removeStudentUser(StudentUser s) {
    return TechnionRankerReturnCodes.valueOf(Communicator.execute(servlet,
        function, TechnionRankerFunctions.REMOVE_STUDENT_USER.value(),
        studentUser, gson.toJson(s)));
  }

  @Override
  public TechnionRankerReturnCodes dropAllStudentUsers() {
    return TechnionRankerReturnCodes.valueOf(Communicator.execute(servlet,
        function, TechnionRankerFunctions.DROP_ALL_STUDENT_USERS.value()));
  }

  @Override
  public TechnionRankerReturnCodes insertStudentProfessorCourse(
      StudentProfessorCourse spc) {
    return TechnionRankerReturnCodes.valueOf(Communicator.execute(servlet,
        function,
        TechnionRankerFunctions.INSERT_STUDENT_PROFESSOR_COURSE.value(),
        studentProfessorCourse, gson.toJson(spc)));
  }

  @Override
  public StudentProfessorCourse getStudentProfessorCourse(
      StudentProfessorCourse spc) {
    return gson
        .fromJson(Communicator.execute(servlet, function,
            TechnionRankerFunctions.GET_STUDENT_PROFESSOR_COURSE.value(),
            studentProfessorCourse, gson.toJson(spc)),
            StudentProfessorCourse.class);
  }

  @Override
  public TechnionRankerReturnCodes removeStudentProfessorCourse(
      StudentProfessorCourse spc) {
    return TechnionRankerReturnCodes.valueOf(Communicator.execute(servlet,
        function,
        TechnionRankerFunctions.REMOVE_STUDENT_PROFESSOR_COURSE.value(),
        studentProfessorCourse, gson.toJson(spc)));
  }

  @Override
  public TechnionRankerReturnCodes dropAllStudentProfessorCourses() {
    return TechnionRankerReturnCodes.valueOf(Communicator.execute(servlet,
        function,
        TechnionRankerFunctions.DROP_ALL_STUDENT_PROFESSOR_COURSES.value()));
  }

  @Override
  public List<Professor> getStudentProfessors(StudentUser s) {
    return gson.fromJson(Communicator.execute(servlet, function,
        TechnionRankerFunctions.GET_STUDENT_PROFESSORS.value(), studentUser,
        gson.toJson(s)), new TypeToken<List<Professor>>() {
      // default usage
    }.getType());
  }

  @Override
  public List<Course> getStudentCourses(StudentUser s) {
    return gson.fromJson(Communicator.execute(servlet, function,
        TechnionRankerFunctions.GET_STUDENT_COURSES.value(), studentUser,
        gson.toJson(s)), new TypeToken<List<Course>>() {
      // default usage
    }.getType());
  }

  @Override
  public TechnionRankerReturnCodes insertProfessorRating(ProfessorRating pr) {
    return TechnionRankerReturnCodes.valueOf(Communicator.execute(servlet,
        function, TechnionRankerFunctions.INSERT_PROFESSOR_RATING.value(),
        professorRating, gson.toJson(pr)));
  }

  @Override
  public List<ProfessorRating> getProfessorRatingByProfessor(ProfessorRating pr) {
    return gson.fromJson(Communicator.execute(servlet, function,
        TechnionRankerFunctions.GET_PROFESSOR_RATING_BY_PROFESSOR.value(),
        professorRating, gson.toJson(pr)),
        new TypeToken<List<ProfessorRating>>() {
          // default usage
        }.getType());
  }

  @Override
  public List<ProfessorRating> getProfessorRatingByStudent(ProfessorRating pr) {
    return gson.fromJson(Communicator.execute(servlet, function,
        TechnionRankerFunctions.GET_PROFESSOR_RATING_BY_STUDENT.value(),
        professorRating, gson.toJson(pr)),
        new TypeToken<List<ProfessorRating>>() {
          // default usage
        }.getType());
  }

  @Override
  public TechnionRankerReturnCodes removeProfessorRating(ProfessorRating pr) {
    return TechnionRankerReturnCodes.valueOf(Communicator.execute(servlet,
        function, TechnionRankerFunctions.REMOVE_PROFESSOR_RATING.value(),
        professorRating, gson.toJson(pr)));
  }

  @Override
  public TechnionRankerReturnCodes dropAllProfessorRatings() {
    return TechnionRankerReturnCodes.valueOf(Communicator.execute(servlet,
        function, TechnionRankerFunctions.DROP_ALL_PROFESSOR_RATINGS.value()));
  }

  @Override
  public TechnionRankerReturnCodes insertCourseRating(CourseRating cr) {
    return TechnionRankerReturnCodes.valueOf(Communicator.execute(servlet,
        function, TechnionRankerFunctions.INSERT_COURSE_RATING.value(),
        courseRating, gson.toJson(cr)));
  }

  @Override
  public List<CourseRating> getCourseRatingByCourse(CourseRating cr) {
    return gson.fromJson(Communicator.execute(servlet, function,
        TechnionRankerFunctions.GET_COURSE_RATING_BY_COURSE.value(),
        courseRating, gson.toJson(cr)), new TypeToken<List<CourseRating>>() {
      // default usage
    }.getType());
  }

  @Override
  public List<CourseRating> getCourseRatingByStudent(CourseRating cr) {
    return gson.fromJson(Communicator.execute(servlet, function,
        TechnionRankerFunctions.GET_COURSE_RATING_BY_STUDENT.value(),
        courseRating, gson.toJson(cr)), new TypeToken<List<CourseRating>>() {
      // default usage
    }.getType());
  }

  @Override
  public TechnionRankerReturnCodes removeCourseRating(CourseRating cr) {
    return TechnionRankerReturnCodes.valueOf(Communicator.execute(servlet,
        function, TechnionRankerFunctions.REMOVE_COURSE_RATING.value(),
        courseRating, gson.toJson(cr)));
  }

  @Override
  public TechnionRankerReturnCodes dropAllCourseRatings() {
    return TechnionRankerReturnCodes.valueOf(Communicator.execute(servlet,
        function, TechnionRankerFunctions.DROP_ALL_COURSE_RATINGS.value()));
  }

  @Override
  public TechnionRankerReturnCodes insertProfessorComment(ProfessorComment pc) {
    return TechnionRankerReturnCodes.valueOf(Communicator.execute(servlet,
        function, TechnionRankerFunctions.INSERT_PROFESSOR_COMMENT.value(),
        professorComment, gson.toJson(pc)));
  }

  @Override
  public List<ProfessorComment> getProfessorCommentByStudent(ProfessorComment pc) {
    return gson.fromJson(Communicator.execute(servlet, function,
        TechnionRankerFunctions.GET_PROFESSOR_COMMENT_BY_STUDENT.value(),
        professorComment, gson.toJson(pc)),
        new TypeToken<List<ProfessorComment>>() {
          // default usage
        }.getType());
  }

  @Override
  public List<ProfessorComment> getProfessorCommentByProfessor(
      ProfessorComment pc) {
    return gson.fromJson(Communicator.execute(servlet, function,
        TechnionRankerFunctions.GET_PROFESSOR_COMMENT_BY_PROESSOR.value(),
        professorComment, gson.toJson(pc)),
        new TypeToken<List<ProfessorComment>>() {
          // default usage
        }.getType());
  }

  @Override
  public TechnionRankerReturnCodes removeProfessorComment(ProfessorComment pc) {
    return TechnionRankerReturnCodes.valueOf(Communicator.execute(servlet,
        function, TechnionRankerFunctions.REMOVE_PROFESSOR_COMMENT.value(),
        professorComment, gson.toJson(pc)));
  }

  @Override
  public TechnionRankerReturnCodes dropAllProfessorComments() {
    return TechnionRankerReturnCodes.valueOf(Communicator.execute(servlet,
        function, TechnionRankerFunctions.DROP_ALL_PROFESSOR_COMMENTS.value()));
  }

  @Override
  public TechnionRankerReturnCodes insertCourseComment(CourseComment cc) {
    return TechnionRankerReturnCodes.valueOf(Communicator.execute(servlet,
        function, TechnionRankerFunctions.INSERT_COURSE_COMMENT.value(),
        courseComment, gson.toJson(cc)));
  }

  @Override
  public List<CourseComment> getCourseCommentByStudent(CourseComment cc) {
    return gson.fromJson(Communicator.execute(servlet, function,
        TechnionRankerFunctions.GET_COURSE_COMMENT_BY_STUDENT.value(),
        courseComment, gson.toJson(cc)),
        new TypeToken<List<ProfessorComment>>() {
          // default usage
        }.getType());
  }

  @Override
  public List<CourseComment> getCourseCommentByCourse(CourseComment cc) {
    return gson.fromJson(Communicator.execute(servlet, function,
        TechnionRankerFunctions.GET_COURSE_COMMENT_BY_COURSE.value(),
        courseComment, gson.toJson(cc)),
        new TypeToken<List<ProfessorComment>>() {
          // default usage
        }.getType());
  }

  @Override
  public TechnionRankerReturnCodes removeCourseComment(CourseComment cc) {
    return TechnionRankerReturnCodes.valueOf(Communicator.execute(servlet,
        function, TechnionRankerFunctions.REMOVE_COURSE_COMMENT.value(),
        courseComment, gson.toJson(cc)));
  }

  @Override
  public TechnionRankerReturnCodes dropAllCourseComments() {
    return TechnionRankerReturnCodes.valueOf(Communicator.execute(servlet,
        function, TechnionRankerFunctions.DROP_ALL_COURSE_COMMENTS.value()));
  }

  @Override
  public List<Course> getCourseByCourseNumber(Course c) {
    return gson.fromJson(Communicator.execute(servlet, function,
        TechnionRankerFunctions.GET_COURSE_BY_COURSE_NUMBER.value(), course,
        gson.toJson(c)), new TypeToken<List<Course>>() {
      // default usage
    }.getType());
  }

  @Override
  public List<Course> getAllCourses() {
    return gson.fromJson(Communicator.execute(servlet, function,
        TechnionRankerFunctions.GET_ALL_COURSES.value()),
        new TypeToken<List<Course>>() {
          // default usage
        }.getType());
  }

  @Override
  public List<Professor> getAllProfessors() {
    return gson.fromJson(Communicator.execute(servlet, function,
        TechnionRankerFunctions.GET_ALL_PROFESSORS.value()),
        new TypeToken<List<Professor>>() {
          // default usage
        }.getType());
  }

  @Override
  public List<Professor> getProfessorByProfessorName(Professor p) {
    return gson.fromJson(Communicator.execute(servlet, function,
        TechnionRankerFunctions.GET_PROFESSOR_BY_NAME.value(), professor,
        gson.toJson(p)), new TypeToken<List<Professor>>() {
      // default usage
    }.getType());
  }

  //Raphi added the following two methods on June 1st, 2014.
  
//Each Course has a professor_id that this method should use to retrieve the course's professor.
@Override
public Professor getProfessorForCourse(Course c) {
    return gson.fromJson(Communicator.execute(servlet, function,
            TechnionRankerFunctions.GET_PROFESSOR_FOR_COURSE.value(), course,
            gson.toJson(c)), Professor.class);
}

@Override
public List<Professor> getProfessorByProfessorHebrewName(Professor p) {
    return gson.fromJson(Communicator.execute(servlet, function,
            TechnionRankerFunctions.GET_PROFESSOR_BY_HEBREW_NAME.value(), professor,
            gson.toJson(p)), new TypeToken<List<Professor>>() {
          // default usage
        }.getType());
}

}
