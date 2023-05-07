## 알고리즘 공부
***
### 1. 개인 공부
- 경로 : src/main/java/study
  - chapter 단위로 하위 패키지 생성하여 문제 풀이
- 교재 : 프로그래머스 코딩 테스트 문제 풀이 전략 : 자바편

***
### 2. 바람개비 스터디
- 경로 : src/main/java/ktds
  - 주 단위로 하위 패키지 생성하여 문제 풀이
- https://github.com/Shinminjin/Algorithm
  - 주마다 지정된 문제 (백준) 풀이

***
### [참고] 자바 입출력
>https://rhsalska55.tistory.com/6
```java
// 사용하려면 main 클래스에 throws IOException을 추가 필요
public static void main(String[] args) throws IOException

// 문자열 입력
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
String str = "";
str = br.readLine();

// 전체 입력 저장
String str = "";
String tmp = "";
while((tmp = bf.readLine())!= null){
  str += tmp + "\n";
}

// 정수 입력 (기본적으로 String으로 읽어오기 때문에 형 변환 필요) 
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
int a = "";
a = Integer.parseInt(br.readLine());

// 공백 구분 (StringTokenizer)
int [] targetArray = new int[100];
st = new StringTokenizer(sc.readLine()," ");
for(int i = 0 ; i < M ; i++){
  targetArray[i] = Integer.parseInt(st.nextToken());
}
```