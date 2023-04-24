package study.chapter1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 31p
 * 사용자가 입력한 전화번호를 가진 사람들을 전화번호부에서 검색하는 기능 구현
 * 1. 전화번호는 어떤 형식으로 나타낼 것인지
 * 2. 전화번호부에서 저장되어 있는 사람은 어떻게 나타낼 것인지
 * 3. 사람과 전화번호는 어떻게 비교할 것인지
 * 4. 전화번호부는 어떤 형식으로 나타낼 것인지
 */
public class Phone {
  public static void main(String[] args) {
//    System.out.println(new PhoneNumber("010-1234-5678"));
//    System.out.println(new PhoneNumber("010 1234 5678"));
//    System.out.println(new PhoneNumber("01012345678"));

//    Person person = new Person("홍길동");
//    person.addPhoneNumber(new PhoneNumber("010-1234-5678"));
//    person.addPhoneNumber(new PhoneNumber("010 1234 5678"));
//    person.addPhoneNumber(new PhoneNumber("01012345678"));
//    System.out.println(person);
//
//    System.out.println(person.hasPhoneNumber(new PhoneNumber("01012345678")));

    Person person1 = new Person("홍길동");
    person1.addPhoneNumber(new PhoneNumber("010-1234-5678"));
    person1.addPhoneNumber(new PhoneNumber("010-2345-6789"));

    Person person2 = new Person("김철수");
    person2.addPhoneNumber(new PhoneNumber("010-2468-0246"));

    Person person3 = new Person("이영희");
    person3.addPhoneNumber(new PhoneNumber("010-1357-9135"));

    PhoneBook phoneBook = new PhoneBook();
    phoneBook.addPerson(person1);
    phoneBook.addPerson(person2);
    phoneBook.addPerson(person3);

//    System.out.println(phoneBook);
    System.out.println(phoneBook.search(new PhoneNumber("01023456789")));
    System.out.println(phoneBook.search(new PhoneNumber("01024680246")));
    System.out.println(phoneBook.search(new PhoneNumber("01013579135")));
    System.out.println(phoneBook.search(new PhoneNumber("01000000000")));
  }

  /**
   * 1. 전화번호 나타내기
   */
  private static class PhoneNumber {
    public final String phoneNumber;

    public PhoneNumber(String rawPhoneNumber) {
      // 숫자가 아닌 문자 제거
      this.phoneNumber = rawPhoneNumber.replaceAll("[^0-9]", "");
    }

    // 객체를 구성하는 멤버 변수들을 문자열로 구성하여 반환
    @Override
    public String toString() {
      return "PhoneNumber{phoneNumber='" + phoneNumber + "'}";
    }

    @Override
    public boolean equals(Object obj) {
      if (!(obj instanceof PhoneNumber)) return false;
      return phoneNumber.equals(((PhoneNumber) obj).phoneNumber);
    }
  }

  /**
   * 2. 전화번호부의 사람 나타내기
   */
  private static class Person {
    /**
     * name과 numbers는 모두 생성자에서 한번 값이 정해진 이후에는 값이 변경되지 않음 => final로 선언하여 이후에 의도치 않게 값이 변경되는 것 방지
     * List와 같이 외부에서 접근하여 임의로 값을 바꿀 수 있는 변수들은 private로 선언하여 클래스 내부에서 의도한 대로만 해당 객체를 사용할 수 있게 함
     * => String처럼 값이 불변인 객체는 외부에서 읽기만 할 수 있으므로 public으로 선언
     */
    public final String name;
    private final List<PhoneNumber> numbers;

    public Person(String name) {
      this.name = name;
      numbers = new ArrayList<>();
    }

    public void addPhoneNumber(PhoneNumber number) {
      numbers.add(number);
    }

    /**
     * 3. 사람과 전화번호 비교하기
     */
    public boolean hasPhoneNumber(PhoneNumber number) {
      /**
       * contains() 메서드는 equals() 메서드를 사용하여 객체를 비교
       * => equals() 메서드는 별도의 오버라이딩이 없으면 객체가 같을 때만 true를 반환
       * => 테스트코드에서는 서로 다른 두 객체를 이용하여 진행했으므로 false 반환
       * => PhoneNumber 클래스에 equals() 메서드 오버라이딩
       */
      return numbers.contains(number);
    }

    @Override
    public String toString() {
      return "Person{name='" + name + "', numbers=" + numbers + "}";
    }
  }

  /**
   * 4. 전화번호부 나타내기
   */
  private static class PhoneBook {
    // 중복 제거
    private final Set<Person> people;

    private PhoneBook() {
      people = new HashSet<>();
    }

    public void addPerson(Person person) {
      people.add(person);
    }

    public Person search(PhoneNumber number) {
      /**
       * 1. people.stream() : Set<Person> => Stream<Person> 으로 변환
       * 2. filter() : number를 가지는 Person 객체들을 찾음
       * 3. fineFirst() : number를 갖는 Person 객체가 있는지 검사
       * 4. orElse() : 없다면 null을 반환
       */
      return people.stream()
          .filter(p -> p.hasPhoneNumber(number))
          .findFirst()
          .orElse(null);
    }

    @Override
    public String toString() {
      return "PhoneBook{people=" + people + "}";
    }
  }
}