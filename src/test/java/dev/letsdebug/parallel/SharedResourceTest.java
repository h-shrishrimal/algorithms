package dev.letsdebug.parallel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/** Junit test to demo usage of @{code ResourceLock} */
@Execution(ExecutionMode.CONCURRENT)
public class SharedResourceTest {

  static final String LOCK_STRING = "ANY_DUMMY_STRING";

  @BeforeEach
  void init() {
    Users.clear();
  }

  @Test
  @ResourceLock(value = LOCK_STRING, mode = ResourceAccessMode.READ)
  void isEmptyTest() {
    Assertions.assertTrue(Users.USERS.isEmpty());
  }

  @Test
  @ResourceLock(value = LOCK_STRING, mode = ResourceAccessMode.READ_WRITE)
  void addTest() {
    Users.add(1, "Harshad"); // method under test
    Assertions.assertEquals("Harshad", Users.get(1));
  }

  @Test
  @ResourceLock(value = LOCK_STRING, mode = ResourceAccessMode.READ_WRITE)
  void updateTest() {
    Users.update(1, "Harshad S");
    Assertions.assertEquals("Harshad S", Users.get(1));
  }

  @Test
  @ResourceLock(value = LOCK_STRING, mode = ResourceAccessMode.READ_WRITE)
  void removeTest() {
    Users.remove(1);
    Assertions.assertEquals(0, Users.allUsers().size());
  }

  /**
   * Class whose methods needs to be accessed in a threadsafe manner
   */
  static class Users {
    private static Map<Integer, String> USERS = new HashMap<>();

    public static String get(int id) {
      return USERS.get(id);
    }

    public static void add(int id, String user) {
      USERS.put(id, user);
    }

    public static void update(int id, String user) {
      USERS.put(id, user);
    }

    public static void remove(int id) {
      USERS.remove(id);
    }

    public static Collection<String> allUsers() {
      return USERS.values();
    }

    public static void clear() {
      USERS.clear();
    }
  }
}
