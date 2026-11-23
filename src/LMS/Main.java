package LMS;
import LMS.Enums.Gender;
import LMS.exseptions.InvalidInputExceptions;
import LMS.services.Impl.AdminServiceImpl;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import LMS.user.Group;
import LMS.services.GroupService;
import LMS.services.Impl.GroupServiceImpl;
import LMS.user.Students;
import LMS.services.StudentsService;
import LMS.services.Impl.StudentServiceImpl;
import LMS.user.Lessons;
import LMS.services.LessonsService;
import LMS.services.Impl.LessonsServiceImpl;
import  LMS.Util.InputUtil;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AdminServiceImpl admin = new AdminServiceImpl();
        GroupService groupService = new GroupServiceImpl();
        StudentsService studentsService = new StudentServiceImpl();
        LessonsService lessonsService = new LessonsServiceImpl();

        LocalTime now = LocalTime.now();
        int hour = now.getHour();
        String greeting;
        if (hour >= 5 && hour < 10) {
            greeting = "Кутман таң!";
        } else if (hour >= 10 && hour < 17) {
            greeting = "Кутман күн!";
        } else if (hour >= 17 && hour < 22) {
            greeting = "Кутман кеч!";
        } else {
            greeting = "Кутман түн!";
        }

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("HH:mm");

        System.out.println("================================");
        System.out.println(greeting + " Саат: "
                + now.format(formatter));
        System.out.println("================================");

        System.out.println("========== LMS ==========");

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        boolean success = admin.signIn(username, password);
        if (success) {
            while (true) {
                System.out.println("\n========== ADMINMENU ==========");
                System.out.println("----- GROUP -----");
                System.out.println("1. ADD GROUP");
                System.out.println("2. GET GROUP BY NAME");
                System.out.println("3. UPDATE GROUP NAME");
                System.out.println("4. GET ALL GROUPS");
                System.out.println("5. DELETE GROUP");

                System.out.println("----- STUDENT -----");
                System.out.println("6. ADD STUDENT");
                System.out.println("7. GET STUDENT BY ID");
                System.out.println("8. UPDATE STUDENT");
                System.out.println("9. GET ALL STUDENTS");
                System.out.println("10. DELETE STUDENT");

                System.out.println("----- LESSON -----");
                System.out.println("11. ADD LESSON");
                System.out.println("12. GET LESSON BY ID");
                System.out.println("13. UPDATE LESSON");
                System.out.println("14. GET ALL LESSONS");
                System.out.println("15. DELETE LESSON");

                System.out.println("0. LOG OUT");
                System.out.println("16. CHANGE PASSWORD");
                System.out.println("================================");

                System.out.print("Command (Буйрук): ");
                String command = scanner.nextLine();

                if (command.equals("0")) {
                    System.out.println("Системадан чыгуу...");
                    break;
                }
                try {
                    switch (command) {
                        case "1":
                            System.out.print("Group ID: ");
                            Long id =InputUtil.readId(scanner.nextLine());
                            System.out.print("Group name: ");
                            String groupName = scanner.nextLine();
                            System.out.print("Description: ");
                            String description = scanner.nextLine();
                            Group group = new Group(id, groupName, description);
                            groupService.addGroup(group);
                            break;
                        case "2":
                            System.out.print("Group name: ");
                            String searchName = scanner.nextLine();

                            Group foundGroup = groupService.getGroupByName(searchName);

                            if (foundGroup != null) {
                                System.out.println("Группа табылды!");
                                System.out.println(foundGroup);
                            } else {
                                System.out.println("Мындай группа жок!");
                            }
                            break;
                        case "3":
                            System.out.println("===== UPDATE GROUP NAME =====");
                            System.out.print("Old group name: ");
                            String oldName = scanner.nextLine();
                            System.out.print("New group name: ");
                            String newName = scanner.nextLine();
                            groupService.updateGroupName(oldName, newName);
                            break;
                        case "4":
                            System.out.println("===== GET ALL GROUPS =====");
                            if (groupService.getAllGroups().isEmpty()) {
                                System.out.println("Группалар жок!");
                            } else {
                                for (Group groups : groupService.getAllGroups()) {
                                    System.out.println(groups);
                                }
                            }
                            break;
                        case "5":
                            System.out.println("===== DELETE GROUP =====");
                            System.out.print("Group name: ");
                            String deleteName = scanner.nextLine();
                            groupService.deleteGroup(deleteName);
                            break;
                        case "6":
                            System.out.println("===== ADD STUDENT =====");
                            System.out.print("Student ID: ");
                            Long studentId = InputUtil.readId(scanner.nextLine());
                            System.out.print("First name: ");
                            String firstName = scanner.nextLine();
                            System.out.print("Last name: ");
                            String lastName = scanner.nextLine();
                            System.out.print("Email: ");
                            String email = scanner.nextLine();
                            System.out.print("Gender: ");
                            Gender gender = Gender.valueOf(scanner.nextLine());
                            System.out.print("Password: ");
                            String studentPassword = scanner.nextLine();
                            Students student = new Students(
                                    studentId,
                                    firstName,
                                    lastName,
                                    email,
                                    gender,
                                    studentPassword
                            );
                            studentsService.addStudent(student);
                            break;
                        case "7":
                            System.out.println("===== GET STUDENT BY ID =====");
                            System.out.print("Student ID: ");
                            Long searchStudentId = InputUtil.readId(scanner.nextLine());
                            Students foundStudent =
                                    studentsService.getStudentById(searchStudentId);

                            if (foundStudent != null) {
                                System.out.println("Студент табылды!");
                                System.out.println(foundStudent);
                            } else {
                                System.out.println("Студент табылган жок!");
                            }
                            break;
                        case "8":
                            System.out.println("===== UPDATE STUDENT =====");
                            System.out.print("Student ID: ");
                            Long updateId = InputUtil.readId(scanner.nextLine());

                            Students oldStudent =
                                    studentsService.getStudentById(updateId);

                            if (oldStudent != null) {
                                System.out.print("New first name: ");
                                String newFirstName = scanner.nextLine();
                                System.out.print("New last name: ");
                                String newLastName = scanner.nextLine();
                                System.out.print("New email: ");
                                String newEmail = scanner.nextLine();
                                System.out.print("New gender (MALE/FEMALE): ");
                                Gender newGender = Gender.valueOf(
                                        scanner.nextLine().toUpperCase()
                                );
                                System.out.print("New password: ");
                                String newPassword = scanner.nextLine();
                                Students newStudent = new Students(
                                        updateId,
                                        newFirstName,
                                        newLastName,
                                        newEmail,
                                        newGender,
                                        newPassword
                                );
                                studentsService.updateStudent(updateId, newStudent);
                            } else {
                                System.out.println("Студент табылган жок!");
                            }
                            break;
                        case "9":
                            System.out.println("===== GET ALL STUDENTS =====");
                            if (studentsService.getAllStudents().isEmpty()) {
                                System.out.println("Студенттер жок!");
                            } else {
                                for (Students students : studentsService.getAllStudents()) {
                                    System.out.println(students);
                                }
                            }
                            break;
                        case "10":
                            System.out.println("===== DELETE STUDENT =====");
                            System.out.print("Student ID: ");
                            Long deleteStudentId =
                                    InputUtil.readId(scanner.nextLine());

                            studentsService.deleteStudent(deleteStudentId);
                            break;
                        case "11":
                            System.out.println("===== ADD LESSON=====");
                            System.out.print("Lesson ID: ");
                            Long lessonId = InputUtil.readId(scanner.nextLine());
                            System.out.print("Lesson name: ");
                            String lessonName = scanner.nextLine();
                            System.out.print("Description: ");
                            String lessonDescription = scanner.nextLine();
                            Lessons lesson = new Lessons(
                                    lessonId,
                                    lessonName,
                                    lessonDescription
                            );
                            lessonsService.addLesson(lesson);
                            break;
                        case "12":
                            System.out.println("===== GET LESSON BY DI =====");
                            System.out.print("Lesson ID: ");
                            Long searchLessonId = InputUtil.readId(scanner.nextLine());
                            Lessons foundLesson =
                                    lessonsService.getLessonById(searchLessonId);
                            if (foundLesson != null) {
                                System.out.println("Сабак табылды!");
                                System.out.println(foundLesson);
                            } else {
                                System.out.println("Сабак табылган жок!");
                            }
                            break;
                        case "13:":
                            System.out.println("===== UPDATE LESSON =====");
                            System.out.print("Lesson ID: ");
                            Long updateLessonId = Long.parseLong(scanner.nextLine());
                            Lessons oldLesson =
                                    lessonsService.getLessonById(updateLessonId);
                            if (oldLesson != null) {
                                System.out.print("New lesson name: ");
                                String newLessonName = scanner.nextLine();
                                System.out.print("New description: ");
                                String newDescription = scanner.nextLine();
                                Lessons newLesson = new Lessons(
                                        updateLessonId,
                                        newLessonName,
                                        newDescription
                                );
                                lessonsService.updateLesson(updateLessonId, newLesson);
                            } else {
                                System.out.println("Сабак табылган жок!");
                            }
                            break;
                        case "14:":
                            System.out.println("===== GET ALL LESSONS =====");
                            if (lessonsService.getAllLessons().isEmpty()) {
                                System.out.println("Сабактар жок!");
                            } else {
                                for (Lessons lessonItem : lessonsService.getAllLessons()) {
                                    System.out.println(lessonItem);
                                }
                            }
                            break;
                        case "15":
                            System.out.println("===== DELETE LESSON =====");
                            System.out.print("Lesson ID: ");
                            Long deleteLessonId = InputUtil.readId(scanner.nextLine());
                            lessonsService.deleteLesson(deleteLessonId);
                            break;
                        case "16":
                            System.out.println("===== CHANGE PASSWORD =====");
                            System.out.print("Old password: ");
                            String oldPassword = scanner.nextLine();
                            System.out.print("New password: ");
                            String newPassword = scanner.nextLine();
                            admin.changePassword(oldPassword, newPassword);
                            break;

                        default:
                            throw new InvalidInputExceptions("Мындай команда жок!");
                    }
                } catch (InvalidInputExceptions e) {
                    System.out.println("Ката: " + e.getMessage());
                } catch (NumberFormatException e) {
                    System.out.println("Ката! ID үчүн сан гана киргизиңиз.");
                } catch (IllegalArgumentException e) {
                    System.out.println("Ката! Туура эмес маалымат киргизилди.");
                } catch (Exception e) {
                    System.out.println("Ката кетти: " + e.getMessage());
                }
            }
        } else {
            System.out.println("Системага кирууго мумкун эмес!");
        }
        scanner.close();
    }
}

